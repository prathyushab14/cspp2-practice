import java.util.Scanner;
/*
 * In the previous module you have created List ADT.
 * ADTs are developed as reusable libraries
 * i.e., anyone who needs the ADT can use it in their program
 * A program that uses the ADT is called a "client" of the ADT
 * The client typically instantiates an object of the ADT
 * and invokes the public methods on the ADT object.
 *
 * This assignment is to practice the idea of client to the ADT.
 * Client class is Fibonacci and the client needs to use the List ADT
 * to store fibonacci numbers in the List ADT.
 * So, Fibonacci is going to instantiate an object of List ADT
 * generate fibonacci numbers and add them to the list
 * by invoking the add method provided in the List ADT.
 *
 */
/**
 * fibonacci class.
 */
final class Fibonacci {
    /**
     * n1 variable.
    **/
    private int n1;
    /**
     * n2 variable.
    **/
    private int n2;
    /**
     * sum.
     */
    private int sum;
    /**
     * @param n1 n1 is first element of fibonacci
     * @param n2 n2 is the second element of fibonacci
     * @param sum sum
     */
    /*
     * fib is a static method takes a argument n
     * n is the count of the fibonacci numbers to be generated.
     * The method returns a List with the n fibonacci numbers.
     *
     * Look for the hint.txt if some of the testcases fail.
     */
    /**
     * default constructor.
    **/
    private Fibonacci() {
    }
    /**
     *
     *
     * @param n no of fiboncci numbers
     *
     * @return list
     */
    public static List fib(final int n) {
        // todo - complete this method
        List l = new List(n);
        /**
         * @param n1 n1
         * @param n2 n2
         * @param sum sum
         */
        int n1 = 0;
        int n2 = 1;
        int sum = 0;
        int s = n;
        l.add(n1);
        l.add(n2);
        while (s - 2 > 0) {
            sum = n1 + n2;
            l.add(sum);
            n1 = n2;
            n2 = sum;
            s--;
        }
        return l;
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println(fib(n));
    }
}

