import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : 
 */
class Set {
    //your code goes here...
    //Good luck :-)
    int[] set;
    int size;
    /**
     * Constructs the object.
     */
    public Set() {
    	set = new int[10];
    	size = 0;
    }
    /**
     * Constructs the object.
     *
     * @param      n    size of the set
     */
    public Set(final int n) {
    	set = new int[n];
    	size = 0;
    }
    /**
     * size of the set.
     *
     * @return     size
     */
    public int size() {
    	return size;
    }
    /**
     * changes the size.
     */
    private void resize() {
    	set = Arrays.copyOf(set, 2 * size);
    }
    /**
     * checks if item is in set.
     *
     * @param      item  The item
     *
     * @return     true or false
     */
    public boolean contains(final int item) {
    	for (int i = 0; i < size; i++) {
    		if (set[i] == item) {
    			return true;
    		}
    	}
    	return false;
    }
    /**
     * adds elements into set.
     *
     * @param      item  The item
     */
    public void add(final int item) {
    	if (size == set.length) {
    	 	resize();
    	}
    	if (!(contains(item))) {
    	    set[size] = item;
    	    size++;
    	}
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
    	if (size == 0) {
    		return "{}";
    	}
    	String res = "{";
    	for(int i = 0; i < size-1;i++) {
    		res += set[i] + ", ";
    	}
    	res = res + set[size-1] + "}";
    	return res;
    }
    /**
     * adds an array of elements.
     *
     * @param      intArray  The int array
     */
    public void add(final int[] intArray) {
    	for (int i : intArray) {
    		add(i);
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
    	for (int i = 0; i < size; i++) {
    		for (int j = 0; j < t.set.length; j++) {
    			if (t.set[j] == set[i]) {
    				ns.add(set[i]);
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
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < intArray.length; j++)
            if (intArray[j] == set[i]) {
                na.add(set[i]);
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
    	if (size == 0 || t.size() == 0) {
    		return null;
    	}
    	int[][] arr = new int[size * t.size()][2];
    	int k = 0;
    	for (int i = 0; i < size; i++) {
    		for (int j = 0; j < t.size(); j++) {
    			arr[k][0] = set[i];
    			arr[k++][1] = t.set[j];
    		}
    	}
    	return arr;
    }
}
/**
 * Solution class for code-eval.
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
        Set s = new Set();
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
                case "contains":
                System.out.println(s.contains(Integer.parseInt(tokens[1])));
                break;
                case "print":
                System.out.println(s);
                break;
                case "add":
                int[] intArray = intArray(tokens[1]);
                if (intArray.length == 1) {
                    s.add(intArray[0]);
                } else {
                    s.add(intArray);
                }
                break;
                case "intersection":
                s = new Set();
                Set t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(s.intersection(t));
                break;
                case "retainAll":
                s = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
                case "cartesianProduct":
                s = new Set();
                t = new Set();
                intArray = intArray(tokens[1]);
                s.add(intArray);
                intArray = intArray(tokens[2]);
                t.add(intArray);
                System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
                break;
                default:
                break;
            }
        }
    }
}
