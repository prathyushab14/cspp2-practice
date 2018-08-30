import java.util.*;
/**
*Do not modify this main function.
**/
final class Solution {
    /**
    *constructor.
    **/
    private Solution() { }
    /**
    * @param args maximum element of array.
    **/
    public static void main(final String[] args) {
    /** main
    *function
    **/
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr1[];
        int max = 0;
        arr1 = new int[n];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = sc.nextInt();
        }
        for (int j = 0; j < arr1.length; j++) {
            if (arr1[j] > max) {
                max = arr1[j];
            } else {
                max = max;
            }
        } System.out.println(max);
    }
}
