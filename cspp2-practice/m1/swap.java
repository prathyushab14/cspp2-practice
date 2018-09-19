import java.util.Scanner;
class SwapNumbers
{
    public static void main(final String[] args)
    {
        int x, y, temp;
        x = 5;
        y = 8;
        temp = x;
        x = y;
        y = temp;

        System.out.println(x  + "," + y);
    }
}