import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String,Integer>();
		String f = "To be or not to be";
		String s = "Doubt truth to be a liar";
		String[] fl = f.toLowerCase().split(" ");
		String[] sl = s.toLowerCase().split(" ");
		for (int i = 0; i < fl.length; i++) {
			if (map.containsKey(fl[i])) {
				int count = map.get(fl[i]);
                map.put(fl[i], count+1);
            } else {
                map.put(fl[i], 1);
            }
		}
		for(String i: map.keySet()) {
			System.out.println(i +" "+map.get(i));
		}
		
	}
}