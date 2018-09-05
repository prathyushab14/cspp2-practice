import java.util.Scanner;
/**
 * input validator class.
 */
final class InputValidator {
    /** declaring variables in class.
    *
    **/
    private String INPUT;
    /**
     *
     *
     * @param      input  The input
    **/
    InputValidator(final String input) {
        INPUT = input;
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
        int length = INPUT.length();
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
     * Constructs the object.
     */
    private Solution() { }
    /**
     * @param args The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}
