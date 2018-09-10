import java.util.Scanner;
import java.io.BufferedInputStream;
import java.util.Arrays;
class SortedSet extends Set {
	int[] set1;
	int size;
	public SortedSet() {
		set1 = new int[10];
		size = 0;
	}
	public int[] subSet(int fromElement, int toElement) {
	    int[] arr = new int[10];
	    if (fromElement > toElement) {
		    System.out.println("Invalid Arguments to Subset Exception");
	    }
	    int count=0;
	    for (int i = 0,j=0; i < size; i++,j++) {
		    if (set1[i] > fromElement && set1[i] < toElement) {
			    arr[j]=set1[i];
			    count++;
		    }
	    }
	    return Arrays.copyOf(arr,count);
    }
    public int[] headSet(int toElement) {
    	int[] array = new int[10];
    	int count = 0;
    	for (int i = 0,j=0; i < size; i++,j++) {
    		if (set1[i] < toElement) {
    			array[j]=set1[i];
    			count++;
    		}
    	}
    	return Arrays.copyOf(array,count);
    }
    public int last() {
    	return set1[size - 1];
    }
    public void addAll(int[] ar) {
    	for (int i : ar) {
    		add(i);
    	}
    }
    public void add(int ele) {
    	int index = 0;
    	if (size == 0) {
    		set1[size++] = ele;
    	}
    	if (!(contains(ele))) {
    	    for (int i = 0; i < size; i++) {
    		    if (set1[i] > ele) {
    		    	index = i;
    		    	break;
    		    }
    	    }
    	    for (int j = size; j > index; j--) {
    	    	set1[j] = set1[j - 1];
    	    }
    	    set1[index] = ele;
        }
    }
}
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
                // case "contains":
                // System.out.println(s.contains(Integer.parseInt(tokens[1])));
                // break;
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
                        System.out.println(Arrays.toString(tmp));
                    }
                break;
                case "headSet":
                    s.headSet(Integer.parseInt(tokens[1]));
                break;
                case "last":
                System.out.println(s.last());
                break;
                default:
                break;
            }
        }
    }
}