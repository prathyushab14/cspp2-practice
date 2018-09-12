public class BookyourShow {
	public Show[] showList;
	public int size;
	BookyourShow() {
		showList = new Show[10];
		size = 0;
	}
	public int size() {
		return size;
	}
	public void addAShow(Show var) {
		showList[size++] = var;
    }
	public Show getAShow(String moviename, String datetime) {
		for (Show s : showList) {
			if ((s.movieName.equals(moviename)) && (s.dateTime.equals(datetime))) {
					return s;
			}
	    }
		return null;
    }
	public void bookAShow(String movieName, String datetime, Patron p, String[] bookingSeats) {
		if (size == 0) {
			System.out.println("No show");
			return;
		}
		int c = 0;
		for (Show s : showList) {
			if ((s.movieName.equals(movieName)) && (s.dateTime.equals(datetime))) {
				    c = 1;
				for (String seatnum : bookingSeats) {
					for (int i = 0; i < s.seatNums.length; i++) {
						if (s.seatNums[i].equals(seatnum)) {
							s.seatNums[i] = "N/A";
							s.bookedSeats[i] = p;
						}
					}
				}
            }
		}
		if (c == 0) {
			System.out.println("No show");
		}
	}
	public void printTicket(String movieName,String datetime,String mobileNo) {
		boolean b = false;
		for (Show s : showList) {
			if (s != null) {
				if (s.movieName.equals(movieName) && s.dateTime.equals(datetime)) {
					for (int i = 0;i < s.bookedSeats.length; i++) {
						if (s.bookedSeats[i].mobileNo.equals(mobileNo)) {
							b = true;
						}
					}
				}
			}
		}
		if (b) {
			System.out.println(mobileNo+" "+movieName+" "+datetime);
		} else {
			System.out.println("Invalid");
		}
    }
	public void showAll() {
		for (Show s : showList)
		if (s!= null) {
			String res = s.movieName+",";
			res += s.dateTime+",[";
			for (int i = 0; i < s.seatNums.length - 1; i++) {
				res+= s.seatNums[i] + ",";
			}
			res+=s.seatNums[s.seatNums.length - 1]+"]";
			System.out.println(res);
		}
	}
}