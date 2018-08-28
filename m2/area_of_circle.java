import java.util.Scanner;
class AreaofCircle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int radius = sc.nextInt();
		double a = areaofcircle(radius);
		System.out.println(a);
	}
	public static double areaofcircle(int radius){
		return (pi() * radius * radius);
	}
	public static double pi(){
		return 3.14;
	}
}