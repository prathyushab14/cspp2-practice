import java.util.Scanner;
import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
/**
*class doc.
*/
class Doc {
    /** constructor.
    */
    Doc() {
    }
    /**
    *text to string.
    *@param fl File
    *@return string.
    */
    public static String toText(final File fl) {
        String str = "";
        try {
            Scanner sc = new Scanner(new FileReader(fl));
            StringBuilder tx = new StringBuilder();
            while (sc.hasNext()) {
                tx.append(sc.next());
                tx.append(" ");
            }
            sc.close();
            str = tx.toString();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
        }
        return str;
    }
    /**
     * remove characters.
     *
     * @param      tx  The text
     *
     * @return map
     * freq of words.
     */
    public Map remove(final String tx) {
        tx.toLowerCase();
        tx.replaceAll("[0-9_]", "");
        String[] words = tx.split(" ");
        Map<String, Integer> map = new HashMap<>();
        for (String e : words) {
         if (e.length() > 0) {
            if (!(map.containsKey(e))) {
                map.put(e, 1);
            } else {
                map.put(e, map.get(e) + 1);
            }
        }
    }
        return map;
    }
    /**
     *document distance.
     *@param text1 first file
     *@param text2 second file
     *@return document distance
     */

    public int similarity(final String text1, final String text2) {
        double n = 0;
        double d = 1;
        double sum1 = 0;
        double sum2 = 0;
        final int hun = 100;
        Map<String, Integer> map1 = remove(text1);
        Map<String, Integer> map2 = remove(text2);
        for (String ele: map1.keySet()) {
            for (String item: map2.keySet()) {
                if (ele.equals(item)) {
                    n += map1.get(ele) * map2.get(item);
                }
            }
        }

        for (String word: map1.keySet()) {
            sum1 += map1.get(word) * map1.get(word);
        }
        for (String word: map2.keySet()) {
            sum2 += map2.get(word) * map2.get(word);
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
        File fls = new File(inp);
        Doc obj1 = new Doc();
        File[] file = fls.listFiles();
        int len = file.length;
        int max = 0;
        final int hundred = 100;
        String res = "";
        int[][] fileM = new int[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    fileM[i][j] = hundred;
                } else {
                    fileM[i][j] = obj1.similarity(
                        obj1.toText(file[i]), obj1.toText(file[j]));
                    if (max < fileM[i][j]) {
                        max = fileM[i][j];
                        res = "Maximum similarity is between "
                        + file[i].getName() + " and "
                        + file[j].getName();
                    }
                }
            }
        }
        System.out.print("      \t");
        for (int i = 0; i < len - 1; i++) {
            System.out.print("\t" + file[i].getName());
        }
        System.out.println("\t" + file[len - 1].getName());
        for (int i = 0; i < len; i++) {
            System.out.print(file[i].getName() + "\t");
            for (int j = 0; j < len; j++) {
                    System.out.print(fileM[i][j] + "\t\t");
            }
            System.out.println();
        }
     System.out.println(res);
    } catch (NoSuchElementException e) {
        System.out.println("empty directory");
    }
    }
}