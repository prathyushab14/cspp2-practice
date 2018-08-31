
// Given an String, Write a java method that returns the decimal value for the given binary string.


import java.util.Scanner;
import java.lang.Math;
public class Solution
{/*
	Do not modify this main function.
	*/
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		sc.nextLine();
		for(int i=0;i<n;i++){
			String s=sc.nextLine();
			String res=binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static String binaryToDecimal(String s){
		int sum=0;
		int j = s.length()-1;
		for(int i=0;i<s.length();i++){
			int v = Character.getNumericValue(s.charAt(i));
			// if(v == 1){
                sum = sum + (int)Math.pow(2,j)*v;
            // }
                j--;
		}return Integer.toString(sum);
	}

}
