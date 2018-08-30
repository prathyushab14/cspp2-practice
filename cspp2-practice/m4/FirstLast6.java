import java.util.Scanner;
final class FiLa6{
	public static void main(final String[] args){
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int arr1[];
		arr1 = new int[size];
		for(int i = 0;i<arr1.length;i++){
			arr1[i] = sc.nextInt();
		}
		if(arr1[0] == 6 || arr1[arr1.length - 1] == 6 ){
				System.out.println("true");
		}else System.out.println("false");
	}
}