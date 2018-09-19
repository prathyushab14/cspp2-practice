import java.util.*;
import java.text.SimpleDateFormat;  
import java.util.Date;    
abstract class Log
{
	 String date; 
	 String time;
	 public Log() {

	 }
	 public Log(String date, String time) {
	 	this.date = date;
	 	this.time = time; 
	 }

	 public String getDate() {
	 	return this.date;
	 }

	 public String getTime() {
	 	return this.time;
	 }
}
class Food extends Log{
	private String itemName;
	private int itemQuantity;
	private String time;

	Food() {

	}
	Food(String i,int q,String t,String d) {
		super(t, d);
		this.itemName=i;
		this.itemQuantity=q;
		this.time=d;
	}
	public String getitemName() {
		return this.itemName;
	}
	public int getitemQuantity() {
		return this.itemQuantity;
	}
	public String toString()
	{
		String s="";
		s+="Date:"+this.date+"\n";
		s+="Time:"+this.time+"\n";
		s+="Name:"+this.itemName+"\n";
		s+="Quantity:"+this.itemQuantity;
		return s;
	}
}
class Water extends Log{
	private int waterQuantity;

	Water(){}
	Water(int q,String d,String t)
	{
		super(d, t);
		this.waterQuantity=q;
	}
	public int getwaterQuantity() {
		return this.waterQuantity;
	}

	public String toString()
	{
		String s="";
		s+="Date:"+this.date+"\n";
		s+="Quantity:"+this.waterQuantity+"ml";
		return s;
	}

}
class PhysicalActivity extends Log{
	private String activityName;
	private String activityNotes;
	private String activityStarttime;
	private String activityEndtime;

	PhysicalActivity(){}
	PhysicalActivity(String name,String notes,String stime,String etime,String d)
	{
		super(d, stime);
		this.activityName=name;
		this.activityNotes=notes;
		this.activityEndtime=etime;
	}
	public String getactivityName() {
		return this.activityName;
	}

	public String getactivityNotes() {
		return this.activityNotes;
	}
	public String getactivityEndTime() {
		return this.activityEndtime;
	}
	public String toString()
	{
		String s="";
		s+="Name:"+this.activityName+"\n";
		s+="Notes:"+this.activityNotes+"\n";
		s+="Date:"+this.date+"\n";
		s+="Starttime:"+this.time+"\n";
		s+="Endtime:"+this.activityEndtime;
		return s;
	}
}
class Weight extends Log{
	int fatPercentage;
	int currentWeight ;
	Weight(){}
	Weight(String d,String t,int c,int fp)
	{
		super(d, t);
		this.fatPercentage=fp;
		this.currentWeight=c;
	}

	public int getcurrentWeight() {
		return this.currentWeight;
	}

	public int getfatPercentage() {
		return this.fatPercentage;
	}

	public String toString()
	{
		String s="";
		s+="Date:"+this.date+"\n";
		s+="Time:"+this.time+"\n";
		s+="Weight:"+this.currentWeight+"KG"+"\n";
		s+="Fat:"+this.fatPercentage+"%";
		return s;
	}
}
class Sleep extends Log{
	String sleepEndtime;
	Sleep(){}
	Sleep(String d,String stime,String etime)
	{
		super(d, stime);
		this.sleepEndtime=etime;
	}

	public String getsleepEndtime() {
		return this.sleepEndtime;
	}

	public String toString() {
		String s="";
		s+="Date:"+this.date+"\n";
		s+="Starttime:"+this.time+"\n";
		s+="Endtime:"+this.sleepEndtime;
		return s;
	}
}

public class Fitbyte {
	public Log[] log;
	public int logsize;
	Fitbyte()
	{
		log = new Log[20];
		logsize = 0;
	}

	void add(Log l) {
		log[logsize++] = l;
	}

	public void log(String type) {
		boolean flag = false;
	 for(int i=0;i<logsize;i++) {
	 	if(type.equals("Food")&&log[i] instanceof Food) {
	 		flag = true;
			System.out.println(log[i]);
	 	}
		else if (type.equals("Water")&&log[i] instanceof Water) {
			flag = true;
			System.out.println(log[i]);
		}
		else if (type.equals("Weight")&&log[i] instanceof Weight) {
			flag = true;
			System.out.println(log[i]);
		}
		else if (type.equals("PhysicalActivity")&&log[i] instanceof PhysicalActivity) {
			flag = true;
			System.out.println(log[i]);
		}
		else if (type.equals("Sleep")&&log[i] instanceof Sleep) {
			flag = true;
			System.out.println(log[i]);
		}
		}
		if (flag == false) {
			System.out.println("None");
		}
	}
	
	void summaryLog(String date)
	{
		
		for(int i=0;i<logsize;i++)
		{
			if(date.equals(log[i].getDate())){
				if(log[i] instanceof Food) {
					System.out.println("Food");}
				if(log[i] instanceof Water) {
					System.out.println("Water");}
				if(log[i] instanceof PhysicalActivity) {
					System.out.println("PhysicalActivity");}
				if(log[i] instanceof Weight) {
					System.out.println("Weight");}
				if(log[i] instanceof Sleep) {
					System.out.println("Sleep");}
				System.out.println(log[i]);
			}
		}
		
	}
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		Fitbyte fb=new Fitbyte(); 
   		SimpleDateFormat formatter;  
   		Date date;
		while(s.hasNext()){
		String line=s.nextLine();
		String tokens[]=line.split(" ");
		String details[];
		switch(tokens[0])
		{
			case "Food":details=tokens[1].split(",");
						Log fo=new Food(details[0],Integer.parseInt(details[1]),details[2],details[3]);
						fb.add(fo);
						break;
			case "Water":details=tokens[1].split(",");
						Log wo=new Water(Integer.parseInt(details[0]),details[1],details[2]);
						fb.add(wo);
						break;
			case "PhysicalActivity":
						details=tokens[1].split(",");
						Log po=new PhysicalActivity(details[0],details[1],details[3],details[4],details[2]);
						fb.add(po);
						break;
			case "Weight":details=tokens[1].split(",");
						  String[] weight=details[2].split("KG");
						  String[] fat=details[3].split("%");
						  Log w=new Weight(details[0],details[1],Integer.parseInt(weight[0]),Integer.parseInt(fat[0]));
						  fb.add(w);
						  break;
			case "Sleep":
						  details=tokens[1].split(",");
						  Log so=new Sleep(details[0],details[1],details[2]);
						  fb.add(so);
						  break;
			
			case "Foodlog":System.out.println("Food");
							fb.log("Food");
							System.out.println();
							break;
			case "Waterlog":System.out.println("Water");
							fb.log("Water");
							System.out.println();
							break;
			case "PhysicalActivitylog":System.out.println("PhysicalActivity");
							fb.log("PhysicalActivity");
							System.out.println();
							break;
			case "Weightlog":System.out.println("Weight");
							fb.log("Weight");
							System.out.println();
							break;
			case "Sleeplog":System.out.println("Sleep");
							fb.log("Sleep");
							System.out.println();
							break;
		    case "Summary":	//System.out.println("Summary");
							if(tokens.length==1) {
								formatter = new SimpleDateFormat("dd/M/yyyy");  
   								date = new Date();  
   								String d=formatter.format(date);
   								fb.summaryLog(d);
							}
							else {
							fb.summaryLog(tokens[1]);
							}
							break;				  
		}
	  }
	}
}



