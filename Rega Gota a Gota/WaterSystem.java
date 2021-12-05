
public class WaterSystem {
	public Crop crop_1;
	public Crop crop_2;
	public int bestDays1 = 0;
	public int bestDays2 = 0;
	public int bestDaysBoth = 0;
	
	public WaterSystem(String name1, int min1, int max1, String name2, int min2, int max2) {
		this.crop_1 = new Crop(name1, min1, max1);
		this.crop_2 = new Crop(name2, min2, max2);
	}
	
	public void registerDay(String day) {
		int drops = 0;
		for(int i = 0; i < day.length(); i++) {
			if(day.charAt(i) == '1') {
				drops++;
			}
		}
		if(crop_1.calculateIfSuitable(drops)) bestDays1++;
		if(crop_2.calculateIfSuitable(drops)) bestDays2++;
		if(crop_1.calculateIfSuitable(drops) && crop_2.calculateIfSuitable(drops)) bestDaysBoth++;
	}
	
	public boolean isEquivalent() {
		return bestDays1 == bestDays2;
	}

	public int getBestDaysBotht() {
		return bestDaysBoth;
	}
	
	public String bestCrop() {
		if(bestDays1 > bestDays2) {
			return crop_1.getName();
		} else {
			return crop_2.getName();
		}
	}
}
