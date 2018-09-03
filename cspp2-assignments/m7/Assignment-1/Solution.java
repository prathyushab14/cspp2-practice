import java.util.*;
class InputValidator
{
	String a;
	InputValidator(String input) {
		a = input;
	}
	 boolean validateData() {
		int length = a.length();
		if (length >= 6) {
			return true;
		} else {
			return false;
		}

	}
}
final class Solution
{
	public static void main(String args[])
    {
    	Scanner s=new Scanner(System.in);
    	String input=s.next();
    	InputValidator i=new InputValidator(input);    	
    	System.out.println(i.validateData());

    }

}
