import java.util.*;
public class StudentDetails {
	double m1;
	double m2;
	double m3;
	StudentDetails(double m1, double m2, double m3) {
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
	}
    double GPA() {
	    double sum;
	    sum = m1 + m2 + m3;
	    return sum / 3;
    }
    public static void main(String[] args) {
        StudentDetails o1 = new StudentDetails(7.5, 7.0, 8.0);
        StudentDetails o2 = new StudentDetails(8.5, 6.0, 7.5);
        StudentDetails o3 = new StudentDetails(7.5, 8.0, 9.0);
        System.out.format("%.1f", o1.GPA());
        System.out.println();
        System.out.format("%.1f", o2.GPA());
        System.out.println();
        System.out.format("%.1f", o3.GPA());
    }
}