import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
class SortedSet extends Set {
    /**
     * default constructor.
     */
    public SortedSet() {
        
    }
    /**
     * subset consits of elements from starting element to end element.
     *
     * @param      fromElement  The from element
     * @param      toElement    To element
     *
     * @return    a subset array
     */
    public int[] subSet(int fromElement, int toElement) {
        int[] arr = new int[10];
        if (fromElement > toElement) {
            System.out.println("Invalid Arguments to Subset Exception");
            return null;
        }
        int count=0;
        for (int i = 0,j=0; i < size; i++) {
            if (set[i] >= fromElement && set[i] < toElement) {
                arr[j++]=set[i];
                count++;
            }
        }
        return Arrays.copyOf(arr,count);
    }
    /**
     * headset array consists of elements less than the given element.
     *
     * @param      toElement  To element
     *
     * @return     an array
     */
    public int[] headSet(int toElement) {
        int[] array = new int[10];
        int count = 0;
        for (int i = 0,j=0; i < size; i++) {
            if (set[i] < toElement) {
                array[j++]=set[i];
                count++;
            }
        }
        return Arrays.copyOf(array,count);
    }
    /**
     * last element of set.
     *
     * @return     last element of the set
     */
    public int last() {
        if (size != 0) {
            return set[size - 1];   
        }
        System.out.println("Set Empty Exception");
        return -1;
    }
    /**
     * Adds all elements of the array.
     *
     * @param      ar    The archive
     */
    public void addAll(int[] ar) {
        for (int i : ar) {
            add(i);
        }
    }
    @Override
    /**
     * adds the given element to the set.
     *
     * @param      ele   The element
     */
    public void add(int ele) {
        int index = 0;
 
        if (!(contains(ele))) {
            int i;
            for (i = 0; i < size; i++) {
                if (set[i] > ele) {
                    index = i;
                    break;
                }
            }
            if (i == size) {
                index = i;
            }
            for (int j = size; j > index; j--) {
                set[j] = set[j - 1];
            }
            set[index] = ele;
            size++;
        }
    }
}
/**
 * Solution class.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * helper function to convert string input to int array.
     *
     * @param      s     { string input from test case file }
     *
     * @return     { int array from the given string }
     */
    public static int[] intArray(final String s) {
        String input = s;
        if (input.equals("{}")) {
            return new int[0];
        }
        if (s.contains("{")) {
            input = s.substring(1, s.length() - 1);
        }
        return Arrays.stream(input.split(","))
                            .mapToInt(Integer::parseInt)
                            .toArray();
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this set
        SortedSet s = new SortedSet();
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
                case "size":
                System.out.println(s.size());
                break;
                case "print":
                System.out.println(s);
                break;
                case "addAll":
                if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        int[] temp = new int[t1.length];
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = Integer.parseInt(t1[i]);
                        }
                        s.addAll(temp);
                    }
                break;
                case "subSet":
                    if (tokens.length != 2) {
                        break;
                    }
                    String[] arrstring3 = tokens[1].split(",");
                    int[] tmp =s.subSet(Integer.parseInt(arrstring3[0]),
                        Integer.parseInt(arrstring3[1]));
                    if (tmp != null) {
                        System.out.println(Arrays.toString(tmp).replace("[","{").replace("]","}"));
                    }
                break;
                case "headSet":
                    System.out.println(Arrays.toString(s.headSet(Integer.parseInt(tokens[1]))).replace("[","{").replace("]","}"));
                break;
                case "last":
                System.out.println(s.last());
                break;
                case "add":
                    String[] t = tokens[1].split(",");
                    s.add(Integer.parseInt(tokens[1]));
                break;
                default:
                break;
            }
        }
    }
}