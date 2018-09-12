public class Show {
	String movieName;
	String dateTime;
	String[] seatNums;
	Patron[] bookedSeats;
	Show(String movieName, String datetime, String[] seatno) {
		this.movieName = movieName;
		this.dateTime = datetime;
	    this.seatNums = seatno;
	    bookedSeats = new Patron[seatno.length];
	}


	// public static void main(String[] args) {
	// 	String[] seatno = {"A1","A2","A3"};
	// 	Show s = new Show("mission", "Sep 12,2018 4:30",seatno);
	// 	System.out.println(s.movieName);
	// 	System.out.println(s.datetime);
	// 	for (int i = 0; i < seatno.length; i++) {
	// 	    System.out.println(s.seatno[i]);
	// 	}
	// }
}