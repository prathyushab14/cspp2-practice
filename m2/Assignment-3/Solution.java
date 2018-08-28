import java.util.Scanner;
/** power of base.**/
final class Solution {
    /**
    *Do not modify this main function.
    **/
    private Solution() { }
    /**
    * @param args finding power
    **/
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }
    /**
    *Need to write the rootsOfQuadraticEquation function.
    **/
    /**
    * @param base baseis a variable
    * @param exponent exponent is a variable
    * @return returns power
    **/
    public static long power(final int base, final int exponent) {
        if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        } else {
            return base * power(base, exponent - 1);
        }
    }
}
