import java.util.*;
public class Solution {
	/* Fill the main function to print resultant of addition of matrices*/
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int arr1 [][] = new int[m][n];
        int arr2 [][] = new int[m][n];
        for (int i=0;i<m;i++) {
        	for(int j=0;j<n;j++) {
        		arr1[i][j] = sc.nextInt();
        	}
        }
        m = sc.nextInt();
        n = sc.nextInt();
        for(int i=0;i<m;i++) {
         	for(int j=0;j<arr1[i].length;j++) {
                arr2[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<m;i++) {
        	for(int j=0;j<arr1[i].length;j++) {
        		arr1[i][j] = arr1[i][j] + arr2[i][j];
          	}
        }
        for(int i=0;i<m;i++) {
        	for(int j=0;j<arr1[i].length;j++){
                System.out.print(arr1[i][j]);
                if(j==0 && j==1) {
                	System.out.print(" ");
                }
            }System.out.print("\n");
        }
    }
} 