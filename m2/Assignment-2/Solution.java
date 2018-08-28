/** roots of quadratic equation. ***/
import java.util.Scanner;
import java.lang.Math;

final class Solution {
	/*
	Do not modify this main function.
	*/
	private Solution() {
	/**
		@param args finding roots**/
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		rootsOfQuadraticEquation(a, b, c);
	}
	/*
	Need to write the rootsOfQuadraticEquation function.
	*/
	public static void rootsOfQuadraticEquation(int a, int b, int c) {
		/** quadratic roots. **/
		double r1;
		double r2;
		final int t = 4;
		r1 = (-b + Math.sqrt((b * b) - (t * a * c))) / (2 * a);
		r2 = (-b - Math.sqrt((b * b) - (t * a * c))) / (2 * a);
		System.out.println(r1 + " " + r2);
	}
}