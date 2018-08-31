import java.util.Scanner;
/**
* item_description.
**/
final class Solution {
/**
Do not modify the main function.
**/
    private Solution() { }
    /**
    * @param args  The arguments.
    **/
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
    /**
    * Write reverseString function.
    **/
    /**
    * @param s s is a string
    * @return k
    **/
    public static String reverseString(final String s) {
        String k = "";
        /**
         * @param i i is a variable.
         */
        for (int i = s.length() - 1; i >= 0; i--) {
            k += s.charAt(i);
        } return k;
    }
}
