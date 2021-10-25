

public class Ticket {
	private int age;
	private boolean isFirstYear;
	
	public Ticket(int oldness, boolean caloirada) {
		age = oldness;
		isFirstYear = caloirada;
	}
	
	public int getPrice() {
		int ticketPrice = 20;
		if(isFirstYear) {
			ticketPrice = 16;
		}
		if(age < 5) {
			ticketPrice = 0;
		}
		else if(age > 65) {
			ticketPrice /= 2;
		}
		return ticketPrice;
	}

}
