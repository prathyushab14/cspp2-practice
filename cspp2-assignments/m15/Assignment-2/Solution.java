import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
/**
 * Exception for signaling invalid position errors.
 */
class InvalidArgumentstoSubsetException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      s   string type
     */
    InvalidArgumentstoSubsetException(final String s) {
        super(s);
    }
}
/**
 * Exception for signaling set empty errors.
 */
class SetEmptyException extends Exception {
    /**
     * Constructs the object.
     *
     * @param      st    string type
     */
    SetEmptyException(final String st) {
        super(st);
    }
}
/**
 * Class for sorted set.
 */
class SortedSet extends Set {
    /**
     * default constructor.
     */
    SortedSet() {
    }
    /**
     * subset consits of elements from starting element to end element.
     *
     * @param      fromElement  The from element
     * @param      toElement    To element
     *
     * @return    a subset array
     */
    public int[] subSet(final int fromElement, final int toElement) {
        final int ten = 10;
        int[] arr = new int[ten];
        try {
            if (fromElement <= toElement) {
               int count = 0;
               for (int i = 0, j = 0; i < size(); i++) {
                   if (get(i) >= fromElement && get(i) < toElement) {
                        arr[j++] = get(i);
                        count++;
                    }
                } return Arrays.copyOf(arr, count);
            } else {
            throw new InvalidArgumentstoSubsetException(
                "Invalid Arguments to Subset Exception");
            }
        } catch (Exception e) {
            System.out.println("Invalid Arguments to Subset Exception");
            return null;
        }
    }
    /**
     * headset array consists of elements less than the given element.
     *
     * @param      toElement  To element
     *
     * @return     an array
     * @throws      SetEmptyException raises if there are no elements
     */
    public int[] headSet(final int toElement) throws SetEmptyException {
        if (toElement <= get(0)) {
            throw new SetEmptyException("Set Empty Exception");
        }

        final int ten = 10;
        int[] array = new int[ten];
        int count = 0;
        for (int i = 0, j = 0; i < size(); i++) {
            if (get(i) < toElement) {
                array[j++] = get(i);
                count++;
            }
        }
        return Arrays.copyOf(array, count);
    }

     /**
     * last element in the array.
     *
     * @return     { description_of_the_return_value }
     *
     * @throws     SetEmptyException  { exception_description }
     */
    public int last() throws SetEmptyException  {
        if (size() != 0) {
            return get(size() - 1);
        } else {
            throw new SetEmptyException("Set Empty Exception");
        }

    }
    /**
     * Adds all elements of the array.
     *
     * @param      ar    The archive
     */
    public void addAll(final int[] ar) {
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
    public void add(final int ele) {
        int index = 0;
        if (!(contains(ele))) {
            int i;
            for (i = 0; i < size(); i++) {
                if (get(i) > ele) {
                    index = i;
                    break;
                }
            }
            if (i == size()) {
                index = i;
            }
            for (int j = size(); j > index; j--) {
                setArrayElement(j, get(j - 1));
            }
            setArrayElement(index, ele);
            sizeincrement();
        }
    }
    /**
     * returns elements that are in both sets.
     *
     * @param      t     object of set
     *
     * @return   intersection set
     */
    public Set intersection(final Set t) {
        Set ns = new Set();
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < t.getArrayLength(); j++) {
                if (t.get(j) == get(i)) {
                    ns.add(get(i));
                }
            }
        }
        return ns;
    }
    /**
     * returns  elements.
     *
     * @param      intArray  The int array
     *
     * @return     returns elements that are in both sets
     */
    public Set retainAll(final int[] intArray) {
        Set na = new Set();
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < intArray.length; j++) {
                if (intArray[j] == get(i)) {
                    na.add(get(i));
                }
            }
        }
        return na;
    }
    /**
     * cartesian product.
     *
     * @param      t     { parameter_description }
     *
     * @return    array set
     */
    public int[][] cartesianProduct(final Set t) {
        if (size() == 0 || t.size() == 0) {
            return null;
        }
        int[][] arr = new int[size() * t.size()][2];
        int k = 0;
        for (int i = 0; i < size(); i++) {
            for (int j = 0; j < t.size(); j++) {
                arr[k][0] = get(i);
                arr[k++][1] = t.get(j);
            }
        }
        return arr;
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
        if (input.equals("[]")) {
            return new int[0];
        }
        if (s.contains("[")) {
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
                    int[] tmp = s.subSet(Integer.parseInt(arrstring3[0]),
                        Integer.parseInt(arrstring3[1]));
                    if (tmp != null) {
                        System.out.println(Arrays.toString(
                            tmp).replace(
                            "[", "{").replace("]", "}"));
                    }
                break;
                case "headSet":
                    try {
                        System.out.println(Arrays.toString(
                        s.headSet(Integer.parseInt(
                            tokens[1]))).replace(
                            "[", "{").replace("]", "}"));
                    } catch (Exception e) {
                        System.out.println("Set Empty Exception");
                    }
                break;
                case "last":
                    try {
                    System.out.println(s.last());
                } catch (Exception e) {
                    System.out.println("Set Empty Exception");
                }
                break;
                case "add":
                    String[] t1 = tokens[1].split(",");
                    s.add(Integer.parseInt(tokens[1]));
                break;
                case "intersection":
                    s = new SortedSet();
                    SortedSet i = new SortedSet();
                    int[] intArray  = intArray(tokens[1]);
                    s.add(intArray);
                    intArray = intArray(tokens[2]);
                    i.add(intArray);
                    System.out.println(s.intersection(i));
                break;
                case "retainAll":
                    s = new SortedSet();
                    intArray = intArray(tokens[1]);
                    s.add(intArray);
                    intArray = intArray(tokens[2]);
                    System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                    s = new SortedSet();
                    SortedSet t = new SortedSet();
                    intArray = intArray(tokens[1]);
                    s.add(intArray);
                    intArray = intArray(tokens[2]);
                    t.add(intArray);
                    System.out.println(Arrays.deepToString(
                        s.cartesianProduct(t)));
                default:
                break;
            }
        }
    }
}
