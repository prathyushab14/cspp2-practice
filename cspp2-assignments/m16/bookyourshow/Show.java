public class Show {
	String movieName;
	String dateTime;
	String[] seatNums;
	Patron[] bookedSeats;
	Show(String name, String dateTime, String[] seats) {
		this.movieName = name;
		this.dateTime = dateTime;
	    this.seatNums = seats;
	    this.bookedSeats = new Patron[seats.length];
	}
	public String toString() {
		return movieName+","+dateTime;
	}
}