import java.util.Scanner;
/**
*Do not modify this main function.
**/
public class Solution {
/* Fill the main function to print the number of 7's between 1 to n*/
    public static void main(final String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int c = 0;
        int ten = 10;
        int seven = 7;
        for (int i = 1; i <= n; i++) {
            int j = i;
            while( j != 0 ) {
                if(j % ten == seven) {
                    c = c + 1;
                }
                j = j / ten;
            }
        } System.out.print(c);
    }
}