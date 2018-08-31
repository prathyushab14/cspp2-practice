import java.util.Scanner;
final class Solution {
    /*
	Do not modify the main function. 
	*/
	private Solution() { }
	/**
	* main function
	* @param args  The arguments
	**/
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String reverse = reverseString(s);	
		System.out.println(reverse);
		
	}
	//Write reverseString function
    public static String reverseString(String s) {
    	String k = "";
    	for (int i = s.length() - 1; i >= 0; i--) {
            k += s.charAt(i);
    	} return k;
    }
}
