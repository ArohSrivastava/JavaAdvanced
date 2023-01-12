package Algorithms;

//PROGRAM TO FIND A GIVEN STRING IS PALINDROME OR NOT

/*
*	ALGORITHM:
*	=========
*		START
*		Step 1: Input the String and know the length of this array (say n1)
*		Step 2: Reverse the String by taking each character from the last going to the first using loops and store it in a new string
*		Step 3: Compare both strings that we got from step 1 and 2 (using s1.equals(s2) method.
*		Step 4: IF-the result of step 3 is true
*					THEN- PRINT "String is palindrome"
*				ELSE
*					PRINT "String is not palindrome"
*		STOP
*/

public class DynamicProgrammingAlgorithm {
	
	public static void main(String args[]) {
		
		String s = "MALAYALAM";
		StringBuffer buffer = new StringBuffer(s);
		
		buffer.reverse();
		String rs = buffer.toString();
		
		if (s.equals(rs)) /*We need the given string to be dependent upon another data i.e the reversed string
							to check the palindrome condition*/
			System.out.println("String is palindrome");
		else
			System.out.println("String is not palindrome");
	}
}