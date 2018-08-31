
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
		for(int i=0;i<=n;i++){
			String s=sc.nextLine();
			String res=binaryToDecimal(s);//Write binaryToDecimal function
			System.out.println(res);
		}
	}
	public static String binaryToDecimal(String s){
		double sum=0;
		for(int i= s.length()-1;i>=0;i--){
			if(s.charAt(i)=='1'){
                int j = s.indexOf(i);
                sum = sum + Math.pow(2,j);
            }
		}return Double.toString(sum);
	}

}
