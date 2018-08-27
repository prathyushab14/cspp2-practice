import java.util.Scanner;
class Quotient_remainder
{
    public static void main(String args[])
    {
        int x, y, q, r;
        System.out.println("enter two numbers");
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();

        q = x / y;
        r = x % y;

        

        System.out.println(q  + ","+ r);
    }
}