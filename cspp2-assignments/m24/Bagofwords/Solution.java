import java.util.Scanner;
import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
/**
*class data.
*/
class Doc {
    /** empty constructor.
    */
    Doc() {
    }
    /**
    * file document text to string.
    *@param f File
    *@return str returns string.
    */
    public static String toText(final File f) {
        String s = "";
        try {
            Scanner sc = new Scanner(new FileReader(f));
            StringBuilder t = new StringBuilder();
            while (sc.hasNext()) {
                t.append(sc.next());
                t.append(" ");
            }
            sc.close();
            s = t.toString();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
        }
        return s;
    }
    /**
     * to remove the unwanted characters.
     *
     * @param      t  The text
     *
     * @return map which contains
     * freq of words.
     */
    public Map remove(final String t) {
        t.toLowerCase();
        t.replaceAll("[0-9_]", "");
        String[] words = t.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String ele : words) {
         if (ele.length() > 0) {
            if (!(map.containsKey(ele))) {
                map.put(ele, 1);
            } else {
                map.put(ele, map.get(ele) + 1);
            }
        }
    }
        return map;
    }
    /**
     *document distance.
     *@param text1 first file string
     *@param text2 second file string
     *@return document distance
     */

    public int similarity(final String text1, final String text2) {
        double n = 0;
        double d = 1;
        double sum1 = 0;
        double sum2 = 0;
        final int hun = 100;
        Map<String, Integer> mapOne = remove(text1);
        Map<String, Integer> mapTwo = remove(text2);
        for (String ele: mapOne.keySet()) {
            for (String item: mapTwo.keySet()) {
                if (ele.equals(item)) {
                    n += mapOne.get(ele) * mapTwo.get(item);
                }
            }
        }

        for (String word: mapOne.keySet()) {
            sum1 += mapOne.get(word) * mapOne.get(word);
        }
        for (String word: mapTwo.keySet()) {
            sum2 += mapTwo.get(word) * mapTwo.get(word);
        }
        d = Math.sqrt(sum1) * Math.sqrt(sum2);
        double documentDistance = (
            (n / d) * hun);
        return (int) (documentDistance);
    }
}
/**solution class.
*/
public final class Solution {
    /**constructor.
    */
    private Solution() {

    }
    /**
     * main method.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try  {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        File files = new File(inp);
        Data obj1 = new Data();
        File[] fileList = files.listFiles();
        int length = fileList.length;
        int maxValue = 0;
        final int hundred = 100;
        String result = "";
        int[][] fileM = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i == j) {
                    fileM[i][j] = hundred;
                } else {
                    fileM[i][j] = obj1.similarity(
                        obj1.toText(fileList[i]), obj1.toText(fileList[j]));
                    if (maxValue < fileM[i][j]) {
                        maxValue = fileM[i][j];
                        result = "Maximum similarity is between "
                        + fileList[i].getName() + " and "
                        + fileList[j].getName();
                    }
                }
            }
        }
        System.out.print("      \t");
        for (int i = 0; i < length - 1; i++) {
            System.out.print("\t" + fileList[i].getName());
        }
        System.out.println("\t" + fileList[length - 1].getName());
        for (int i = 0; i < length; i++) {
            System.out.print(fileList[i].getName() + "\t");
            for (int j = 0; j < length; j++) {
                    System.out.print(fileM[i][j] + "\t\t");
            }
            System.out.println();
        }
     System.out.println(result);
    } catch (NoSuchElementException e) {
        System.out.println("empty directory");
    }
    }
}
