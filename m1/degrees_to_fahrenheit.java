import java.util.Scanner;
class Degrees_fahrenheit
{
    public static void main(String args[])
    {
        int c,f;
        System.out.println("enter the temperature in celsius");
        Scanner in = new Scanner(System.in);
        c = in.nextInt();

        f = (c * 9 / 5) + 32;

        System.out.println(f);
    }
}