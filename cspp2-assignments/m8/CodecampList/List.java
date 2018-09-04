import java.io.BufferedInputStream;
import java.util.Scanner;
/**
 * List class.
**/
public class List {
    /**
     * Implement all the methods mentioned to build a ListADT.
    **/
    /**
     * { var_description }.
     */
    private int[] list;
    /**
     * { var_description }.
     */
    private int size;
    /**
     * @param size size of list.
     */
    /*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, assume we are only going to have ints in the list
     * We need to create an array of ints to store the items
     * added to the list.
     *
     * Create a variable of the type int[]
     * Use the private access specifier
     * Why private access specifier and why not public?
     * Well, we don't want the array to be manipulated by
     * methods that are outside the List class.
     * If you allow methods outside the List class to manipulate
     * the array then there is a possibility of having a corrupted
     * list i.e., a list with incorrect items.
     * This is not desirable and so having private access specifer
     * will protect the array such corruption.
     * This is a hard concept to understand. Discuss with your mentor.
     *
    */
    // declare a private int[]
    // don't create the array yet using new
    // that's the job of the List constructor
    /*
     * What are the other class variables needed for creating a list?
     * How about keeping track of the size of the list?
     * If you add 2 items to the list then the size should be 2.
     * Let's think about the size of the list by comparing it to the
     * length of the array. Do they mean the same?
     * No, Array length signifies the maximum number of items
     * you can store in the list. Whereas, the size of the list
     * denotes the number of items in the list. Makes sense?
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * The length of the array is 10 and size is 3.
     * This means you can store 10 items in the list and
     * currently it has 3 items.
     * So, to keep track of the size we need a variable called size
     * Again, we use private as we don't want that size variable
     * to be accessed by the methods that are outside of the List class.
     *
     */
    // declare a private int size
    // again, don't initialize it here
    // variable initialization should be done in the constructor
    /*
     * The purpose of the constructor is to initialize the
     * class variables with some default values.
     */
        public List() {
        list = new int[10];
        size = 0;
        // what are the two variables to be initialized here?
        // think about the private variables described above.
        // What should be the default values?
        // In the case of the list, it should be empty but
        // it should be initialized with an array size like 10
        // Think about the initial value for size.
        // How many items do we have in the list when you create it?
        // An empty list has how many items?
        // That is the initial value to use for size.
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     */
    public void add(int item) {
        //Inserts the specified element at the end of the list.
        list[size] = item;
        size++;
    }
    /**
     * { function_description }.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }
    /**
     * { function_description }.
     *
     * @param      index  The index
     */
    public void remove(final int index) {
        // write the logic for remove here.
        // Think about what to do to the size variable.
        if (index >= 0 && index < size) {
            for (int i = index; i < size; i++) {
                list[i] = list[i + 1];
            }
        list[size] = 0;
        size--;
        } else {
            System.out.println("Invalid Position Exception");
        }
    }
    /**
     * { function_description }.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public int get(final int index) {
        // Replace the code below to write the code for get
        if (index >= 0 && index < size) {
            return list[index];
        }
        return -1;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        // Replace the code below
        String res = "[";
        for (int i = 0; i < size - 1; i++) {
            res = res + list[i] + ",";
        }
        res += list[size - 1] + "]";
        return res;
    }
    /**
     * { function_description }.
     *
     * @param      item  The item
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(final int item) {
        // Replace the code below
        if (indexOf(item) >= 0) {
            return true;
        }
        return false;
    }
    /*
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    public int indexOf(final int item) {
        // Replace the code below
        int index = -1;
        for (int i : list) {
            index++;
            if (i == item) {
                return index;
            }
        }
        return -1;
    }
    /**
     * { function_description }
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        List l = new List();
        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                l.add(Integer.parseInt(tokens[1]));
                break;
                case "size":
                // invoke size method and print the list size
                // BTW, list size is not the array size
                // it is the number of items in the list
                System.out.println(l.size());
                break;
                case "print":
                // print the list (implement toString for this to work)
                // expected format is [item-1,item-2,...,item-n]
                // review the output testcase file
                System.out.println(l);
                break;
                case "remove":
                l.remove(Integer.parseInt(tokens[1]));
                break;
                case "indexOf":
                System.out.println(l.indexOf(Integer.parseInt(tokens[1])));
                break;
                case "get":
                if ((l.get(Integer.parseInt(tokens[1]))) != -1) {
                    System.out.println(l.get(Integer.parseInt(tokens[1])));
                }
                break;
                case "contains":
                System.out.println(l.contains(Integer.parseInt(tokens[1])));
                break;
            }
        }
    }
}