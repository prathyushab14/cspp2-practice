import java.util.Scanner;
final class Average{
	public static void main(final String[] args){
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr1[];
		int sum = 0;
		arr1 = new int[size];
		for(int i = 0;i<arr1.length;i++){
			arr1[i] = sc.nextInt();
		}
		for(int j =0;j<arr1.length;j++){
			sum = sum + arr1[j];
		}
	    int avg = sum/size;
	    System.out.println(avg);
    }
}
