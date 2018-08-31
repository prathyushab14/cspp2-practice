import java.util.Scanner;
final class concatinate{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s = "Hello ";
		String c = sc.nextLine();
		System.out.println(s.concat(c) + "!");
	}
}