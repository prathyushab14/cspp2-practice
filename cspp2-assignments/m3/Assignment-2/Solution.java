import java.util.Scanner;
/**
*Do not modify this main function.
**/
final class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    /**
    *Do not modify this main function.
    **/
    private Solution() { }
    /**
    * @param args finding no of 7's
    **/
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int c = 0;
        final int ten = 10;
        final int seven = 7;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while (j != 0) {
                if (j % ten == seven) {
                    c = c + 1;
                }
                j = j / ten;
            }
        } System.out.print(c);
    }
}