import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author :
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    static void oddComposites(final int n) {
    // write your code here
        int i;
        int c = 0;
        final int three = 3;
        for (i = three; i < n; i++) {
            if (i % 2 != 0) {
                for (int j = 2; j <= i / 2; j++) {
                    if (i % j == 0) {
                        c += 1;
                        if (c >= 1) {
                           System.out.println(i);
                           break;
                        }
                    }
                }
            }
        }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}
