import java.util.Scanner;
/**
* { item_description }
**/
import java.lang.Math;
/**
* Class for solution.
**/
final class Solution {
/**
*Do not modify this main function.
**/
    private Solution() { }
    /**
    * @param args  The arguments.
    **/
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            String res = binaryToDecimal(s);
            System.out.println(res);
        }
    }
    /**
     * function_description.
     *
     * @param s parameter_description
     *
     * @return sum description_of_the_return_value.
     */
    public static String binaryToDecimal(final String s) {
        int sum = 0;
        /**
         * var_description.
         */
        int j = s.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            int v = Character.getNumericValue(s.charAt(i));
                sum = sum + (int) Math.pow(2, j) * v;
                j--;
        } return Integer.toString(sum);
    }
}
