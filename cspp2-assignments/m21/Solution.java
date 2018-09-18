import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
class FoodLog {
	String name;
	double quantity;
	String date;
	String time;
	FoodLog(String name1, String quantity1, String date1, String time1) {
		this.name = name1;
		this.quantity = Double.parseDouble(quantity1);
		this.date = date1;
		this.time = time1;
	}
	public String getFname() {
		return name;
	}
	public double getQuan() {
		return quantity;
	}
	public String getDate() {
		return date;
	}
	public String getTime() {
		return time;
	}
}
class WaterLog {
	double watercons;
	String dat;
	String tim;
	WaterLog(String watercons1, String dat, String tim) {
		this.watercons = Double.parseDouble(watercons1);
		this.dat = dat;
		this.tim = tim;
    }
    public double getWatercon() {
    	return watercons;
    }
    public String getdat() {
    	return dat;
    }
    public String gettim() {
    	return tim;
    }
}
class Weight {
	String weight;
	String fat;
	String date;
	String time;
	Weight(String date1, String time1, String weight1, String fat1) {
		this.weight = weight1;
		this.fat = fat1;
		this.date = date1;
		this.time = time1;
	}
    public String getwt() {
    	return weight;
    }
    public String getfat() {
    	return fat;
    }
    public String getd() {
    	return date;
    }
    public String gett() {
    	return time;
    }
}
class Physicalac {
	String activityname;
	String date;
	String starttime;
	String endtime;
	String notes;
	Physicalac(String activity, String notes, String dt, String stti, String entm) {
		this.activityname = activity;
		this.date = dt;
		this.starttime = stti;
		this.endtime = entm;
		this.notes = notes;
	}
    public String getac() {
    	return activityname;
    }
    public String getdatep() {
    	return date;
    }
    public String getSttim() {
    	return starttime;
    }
    public String getEntm() {
    	return endtime;
    }
    public String getnot() {
    	return notes;
    }
}
class Sleep {
	String statim;
	String endtim;
	String dt;
	Sleep(String dat, String stti, String entm) {
		this.statim = stti;
		this.endtim = entm;
		this.dt = dat;
	}
    public String getstatim() {
    	return statim;
    }
    public String getendtim() {
    	return endtim;
    }
    public String getdatee() {
    	return dt;
    }
}
class Summary {
	public FoodLog[] food;
	public WaterLog[] water;
	public Physicalac[] phy;
	public Weight[] wei;
	public Sleep[] sl;
	public int fsize;
	public int wsize;
	public int phsize;
	public int wtsize;
	public int ssize;
	Summary() {
		food = new FoodLog[10];
		water = new WaterLog[10];
		phy = new Physicalac[10];
		wei = new Weight[10];
		sl = new Sleep[10];
		fsize = 0;
		wsize = 0;
		phsize = 0;
		wtsize = 0;
		ssize = 0;
	}
	public void addF(FoodLog f) {
		food[fsize++] = f;
    }
	public void addW(WaterLog w) {
		water[wsize++] = w;
    }
	public void addP(Physicalac p) {
		phy[phsize++] = p;
    }
	public void addwt(Weight wt) {
		wei[wtsize++] = wt;
    }
    public void adds(Sleep s) {
    	sl[ssize++] = s;
    }
    public void printFL() {
    	for (int i = 0; i < fsize; i++) {
    		System.out.println("Food");
    		System.out.println("Date:" + food[i].getDate());
    		System.out.println("Time:" + food[i].getTime());
            System.out.println("Name:" + food[i].getFname());
            System.out.println("Quantity:" + food[i].getQuan());
    	}
    }
    public void printWL() {
    	for (int i = 0; i < wsize; i++) {
            System.out.println("Water");
    	    System.out.println("Date:" + water[i].getdat());
    		System.out.println("Quantity:" + water[i].getWatercon()+ "ml");
    	}
    }
    public void printPA() {
    	for (int i = 0; i < phsize; i++) {
    		System.out.println("PhysicalActivity");
    		System.out.println("Name:" + phy[i].getac());
    		System.out.println("Notes:" + phy[i].getnot());
    		System.out.println("Date:" + phy[i].getdatep());
    		System.out.println("Starttime:" + phy[i].getSttim());
    		System.out.println("Endtime:" + phy[i].getEntm());
    	}
    }
    public void printWtl() {
    	for (int i = 0; i < wtsize; i++) {
    		System.out.println("Weight");
    		System.out.println("Date:" + wei[i].getd());
    		System.out.println("Time:" + wei[i].gett());
    		System.out.println("Weight:" + wei[i].getwt());
    		System.out.println("Fat:" + wei[i].getfat());
    	}
    }
    public void printSL() {
    	for (int i = 0; i < ssize; i++) {
            System.out.println("Sleep");
    		System.out.println("Date:" + sl[i].getdatee());
    		System.out.println("Starttime:" + sl[i].getstatim());
    		System.out.println("Endtime:" + sl[i].getendtim());
    	}
    }
    public void show(String date) {
    	for (int i = 0; i < fsize; i++) {
    		if (food[i].getDate().equals(date)) {
    			System.out.println("Food");
    			System.out.println("Date:" + food[i].getDate());
    			System.out.println("Time:" + food[i].getTime());
                System.out.println("Name:" + food[i].getFname());
                System.out.println("Quantity:" + food[i].getQuan());
    		}
    	}
    	for (int i = 0; i < wsize; i++) {
    		if (water[i].dat.equals(date)) {
    			System.out.println("Water");
    			System.out.println("Date:" + water[i].getdat());
    			System.out.println("Quantity:" + water[i].getWatercon());
    		}
    	}
    	for (int i = 0; i < phsize; i++) {
    		if (phy[i].date.equals(date)) {
    			System.out.println("PhysicalActivity");
    			System.out.println("Name:" + phy[i].getac());
    			System.out.println("Notes:" + phy[i].getnot());
    			System.out.println("Date:" + phy[i].getdatep());
    			System.out.println("Starttime:" + phy[i].getSttim());
    			System.out.println("Endtime:" + phy[i].getEntm());
    		}
    	}
    	for (int i = 0; i < wtsize; i++) {
    		if (wei[i].date.equals(date)) {
    			System.out.println("Weight");
    			System.out.println("Date:" + wei[i].getd());
    			System.out.println("Time:" + wei[i].gett());
    			System.out.println("Weight:" + wei[i].getwt());
    			System.out.println("Fat:" + wei[i].getfat());
    		}
    	}
    	for (int i = 0; i < ssize; i++) {
    		if (sl[i].dt.equals(date)) {
    			System.out.println("Sleep");
    			System.out.println("Date:" + sl[i].getdatee());
    			System.out.println("Starttime:" + sl[i].getstatim());
    			System.out.println("Endtime:" + sl[i].getendtim());
    		}
    	}
    }
}
class Solution {
	Solution() {

	}
	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
        Summary summ = new Summary();
		Scanner scan = new Scanner(System.in);
		int lines = Integer.parseInt(scan.nextLine());
		for (int i = 0; i < lines; i++) {
			String[] input = scan.nextLine().split(" ");
			switch (input[0]) {
				case "Food":
				String[] tokens = input[1].split(",");
				summ.addF(new FoodLog(tokens[0], tokens[1], tokens[2], tokens[3]));
				break;
				case "Water":
				String[] tok = input[1].split(",");
				summ.addW(new WaterLog(tok[0], tok[1],tok[2]));
				break;
				case "PhysicalActivity":
				String[] tokens1 = input[1].split(",");
				summ.addP(new Physicalac(tokens1[0], tokens1[1], tokens1[2], tokens1[3], tokens1[4]));
				break;
				case "Weight":
				String[] tokens2 = input[1].split(",");
				summ.addwt(new Weight(tokens2[0], tokens2[1], tokens2[2], tokens2[3]));
				break;
				case "Sleep":
				String[] tokens3 = input[1].split(",");
				summ.adds(new Sleep(tokens3[0], tokens3[1], tokens3[2]));
				break;
				case "Foodlog":
				summ.printFL();
				break;
				case "Waterlog":
				summ.printWL();
				break;
				case "PhysicalActivitylog":
				summ.printPA();
				break;
				case "Weightlog":
				summ.printWtl();
				break;
				case "Sleeplog":
				summ.printSL();
				case "Summary":
				summ.show(formatter2.format(date));
				break;
				default:
				break;
			}
		} 
	}
}