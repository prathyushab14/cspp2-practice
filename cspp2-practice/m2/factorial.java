import java.util.Scanner;
class Factorial{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		System.out.println(fact(num));
	}
	public static int fact(int num){
		if (num == 1){
			return 1;
		}
		else {
			return num * fact(num - 1);
		}
	}
}