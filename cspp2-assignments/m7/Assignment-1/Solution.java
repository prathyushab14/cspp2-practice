import java.util.Scanner;
final class InputValidator {
    /** declaring variables in class.
    *
    **/
    private String a;
    /**
     *
     *
     * @param      input  The input
     */
    InputValidator(final String input) {
        a = input;
    }
    /**
     * validates the string length.
     *
     * @return returns boolean type
     */
     boolean validateData() {
        final int six = 6;
        /**
         * @param length length of the string
         */
        int length = a.length();
        if (length >= six) {
            return true;
        }
        return false;
    }
}
/**
 * class solution.
 */
final class Solution {
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}