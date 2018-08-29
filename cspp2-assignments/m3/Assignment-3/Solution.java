import java.util.Scanner;
/**
*Do not modify this main function.
**/
final class Solution {
    /**
    *Do not modify this main function.
    **/
    private Solution() { }
    /**
    * @param args finding gcd
    **/

    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        gcd(n1, n2);
        System.out.println(gcd(n1, n2));
    }
    /**
    *Need to write the gcd function and print the output.
    **/
    /**
    * @param n11 n1 is a variable
    * @param n21 n2 is a variable
    * @return gcd
    **/
    public static int gcd(final int n11, final int n21) {
        int r;
        /**
         * @param n1 n1
         * @param n2 n2
         */
        int n1 =n11, n2 =n21;
        while (n2 > 0) {
            r = n1 % n2;
            if (r == 0) {
                return n2;
            } else {
                n1 = n2;
                n2 = r;
            }
        }
        return n2;
    }
}
