
public class Lamp {
	private boolean isLampOn;
	
	public void turnOn() {
		isLampOn = true;
	}
	
	public void turnOff() {
		isLampOn = false;
	}
	
	public boolean isOn() {
		return isLampOn;
	}
}
