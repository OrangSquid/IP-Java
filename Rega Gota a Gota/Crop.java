
public class Crop {
    private String name;
    private int minRain;
    private int maxRain;

    // pre: 1000 >= maxRain > minRain >= 0 && name.length < 20
    public Crop(String name, int minRain, int maxRain) {
        this.name = name;
        this.minRain = minRain;
        this.maxRain = maxRain;
    }

    public boolean calculateIfSuitable(int drops) {
       if(drops >= minRain && drops <= maxRain)
    	   return true;
       else
           return false;
    }

    public String getName() {
        return name;
    }
}