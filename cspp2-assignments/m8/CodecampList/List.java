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
     * { int array list }.
     */
    private int[] list;
    /**
     * { size of the list }.
     */
    private int size;
    /**
     * Constructs the object.
     */
        public List() {
        final int ten = 10;
        list = new int[ten];
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
     * { adding the item to list }.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        //Inserts the specified element at the end of the list.
        list[size] = item;
        size++;
    }
    /**
     * { to find size of the list }.
     *
     * @return     { returns size }
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }
    /**
     * { remove the item from the list }.
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
     * { to get the item from the list }.
     *
     * @param      index  The index
     *
     * @return     { item at the particular index }
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
     * { to check if the item is in the list }.
     *
     * @param      item  The item
     *
     * @return     { returns boolean value }
     */
    public boolean contains(final int item) {
        // Replace the code below
        if (indexOf(item) >= 0) {
            return true;
        }
        return false;
    }
    /**
     * Searches for the first match.
     *
     * @param      item  The item
     *
     * @return     { returns index value }
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
    public void add(int item, int index) {
        if (index >= 0 && index < size) {
            size = size + 1;
            for (int i = size; i > index; i--){
                list[i] = list[i - 1];
            }
            list[index] = item;
        }
    }
    public int count(int item){
        int c = 0;
        for (int i : list) {
            if (list[i] == item) {
                c++;
            }
        }
        return c;
    }
    /**
     * main function.
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
                default:
                break;
            }
        }
    }
}
