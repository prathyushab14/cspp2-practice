import java.io.*;
import java.util.*;
class BagofWords {
	BagofWords() {
    }
	Map<String, Integer> map = new HashMap<String,Integer>();
	Map<String, Integer> map1 = new HashMap<String, Integer>();
	public void addWords(String[] list) {
		for (String s : list) {
			if (map.containsKey(s)){
				int count = map.get(s);
                map.put(s, count+1);
            } else {
                map.put(s, 1);
            }
		}
		// for(String i: map.keySet()) {
		// 	System.out.println(i +" "+map.get(i));
		// }
		// ArrayList<Integer> val = new ArrayList();
		// for (String i : map.keySet()) {
		// 		val.add(map.get(i)); 
		// 	}
		// System.out.println(val);
		// getEuclediannorm(val);
    }
    public void addWord(String[] l) {
        for (String s : l) {
			if (map1.containsKey(s)){
				int count = map1.get(s);
                map1.put(s, count+1);
            } else {
                map1.put(s, 1);
            }
		}
    }

    public void dist() {
    	double n = 0;
    	double d1 = 0;
    	double d2 = 0;
    	double res = 0;
    	for (String i : map.keySet()) { 
    		if (map1.containsKey(i)) {
    			n += map.get(i) * map1.get(i);
    		}
    	}
    	for (String i : map.keySet()) {
    	    d1 += Math.pow(map.get(i), 2);
    	}
    	for (String i : map1.keySet()) {
    		d2 = Math.pow(map1.get(i), 2);
    	}
    	double d = (Math.sqrt(d1) * Math.sqrt(d2));
    	res = (n / d) * 100;
    	System.out.println(res);
    }
}
class Solution {
	public static void main(String[] args) throws Exception {
		BagofWords bg = new BagofWords();
		try {
			File file = new File("Test");
		    File[] f = file.listFiles();
		    for (int i = 0; i < f.length; i++) {
			    for (int j = 0; j < f.length; j++) {
				    Scanner s = new Scanner(f[i]);
				    String l = s.nextLine().replaceAll("[^A-Za-z0-9]","");
				    String[] fl = l.toLowerCase().split(" ");
				    bg.addWords(fl);

				    Scanner sc = new Scanner(f[j]);
				    String li = sc.nextLine().replaceAll("[^A-Za-z0-9]","");
				    String[] sl = li.toLowerCase().split(" ");
				    bg.addWord(sl);
		        }
		        bg.dist();
			}
		}
		catch (Exception e) {
			System.out.println(e);
		}

	}
}