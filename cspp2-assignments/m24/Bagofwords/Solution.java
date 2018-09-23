import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.lang.Math.*;
import java.io.*;
class Doc {
    String t1;
    String t2;
    Doc() {
        t1 = "";
        t2 = "";
    }
    public static String DocToString(File f) {
        String fileToString = "";
        try {
            Scanner s = new Scanner(new FileReader(f));
            StringBuilder sb = new StringBuilder();
            while (s.hasNext()) {
                sb.append(s.next());
                sb.append(" ");
            }
            s.close();
            fileToString = sb.toString();
        } catch(FileNotFoundException e) {
            System.out.println("no file");
        }
        return fileToString;
    }
    public static Map removewords(String txt) {
        String w = "";
        Pattern p = Pattern.compile("[^0-9_.,]");
        Matcher match = p.matcher(txt);
        while(match.find()) {
            w += match.group();
        }
        w = w.toLowerCase();
        String[] words = w.split(" ");
        Map <String, Integer> map = new HashMap<>();
        for (int i = 0; i  < words.length; i++) {
            if(!map.containsKey(words[i])) {
                map.put(words[i], 1);
            } else {
                map.put(words[i],map.get(words[i]) + 1);
            }
        }
        return map;
    }
    public static int compare(String string1, String string2) {
        float n = 0;
        double d = 0;
        float fSum = 0;
        float sSum = 0;
        Map <String,Integer> firstMap = removewords(string1);
       Map <String,Integer> secondMap = removewords(string2);
       for (String inmapOne : firstMap.keySet()) {
           for (String inmapTwo : secondMap.keySet()) {
               if (inmapOne.equals(inmapTwo)) {
                   n += firstMap.get(inmapOne) * secondMap.get(inmapTwo);
               }
           }
       }
       for (String inmapOne : firstMap.keySet()) {
           fSum += Math.pow(firstMap.get(inmapOne),2) ;
       }
       for (String inmapTwo : secondMap.keySet()) {
           sSum += Math.pow(secondMap.get(inmapTwo),2);
       }
       d = Math.sqrt(fSum) * Math.sqrt(sSum);
       double output = (n / d) * 100;
       return  (int) ((output * 100D) / 100D) ;
    }
    
}
class Solution {
    Solution() {

    }
    public static void main(String[] args) {
        try {
        Doc d = new Doc();
        String path;
        Scanner scan = new Scanner(System.in);
        path = scan.nextLine();
        File folder = new File(path);
        File[] list = folder.listFiles();
        int length = list.length;
        int[][] matrix = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = Doc.compare(Doc.DocToString(list[i]),Doc.DocToString(list[j]));
            }
        }
        System.out.print("      \t");
        for (int i = 0; i < list.length - 1; i++) {
            System.out.print("\t" + list[i].getName());
        }
        System.out.println("\t" + list[length - 1].getName());
        for (int i = 0; i < length; i++) {
            System.out.print(list[i].getName() + "\t");
            for (int j = 0; j < length; j++) {
                System.out.print(matrix[i][j] + "        ");
            }
            System.out.println();
        }
    } catch (NoSuchElementException e) {
        System.out.println("empty directory");
    }
    
    }
}