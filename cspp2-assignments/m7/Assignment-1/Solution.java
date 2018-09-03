import java.util.*;
class InputValidator {
    /** declaring variables in class.
    *
    **/
    String a;
    /**
     * 
     *
     * @param      input  The input
     */
    InputValidator(String input) {
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
        } else {
            return false;
        }
    }
}
/**
 * class solution.
 */
final class Solution {
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        InputValidator i = new InputValidator(input);
        System.out.println(i.validateData());
    }
}