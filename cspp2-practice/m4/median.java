//median program
// public class median{
// 	public static void main(String[] args){
// 	int[] arr = {1, 2, 3, 4};
// 	double median=0;
// 	if(arr.length%2!=0){
// 			 median = arr[arr.length/2];
// 		} else {
// 		double m = (arr[(arr.length/2)-1]) + arr[arr.length/2];
// 		median = m/2;
// 	}System.out.println(median);
// }
// }
// fibonacci program
// public class median{
// 	public static void main(String[] args){
// 		int n = 5;
//         fibonacci(n);
//         System.out.println(fibonacci(n));
// 	}
// 	public static int fibonacci(final int n){
// 		if(n == 1)
// 			return 0;
// 		if(n == 2)
// 			return 1;
// 		return fibonacci(n-1) + fibonacci(n-2);
// 	}
import java.util.Scanner;	
public class median{
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	System.out.println(n);
}
}