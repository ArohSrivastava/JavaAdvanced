package Algorithms;

import java.util.ArrayList;
import java.util.Collections;

// PROGRAM TO FIND THE SECOND SMALLEST AND THE SECOND LARGEST NUMBERS IN A LIST

/* Among many approaches, I found this approach the best one, so, as per the Greedy Algorithm, writing the best one here- */
public class GreedyAlgorithm {
	public static void main(String args[])
	{	
		ArrayList<Integer> list1 =  new ArrayList<Integer>(); // List for storing input
		ArrayList<Integer> list2 =  new ArrayList<Integer>(); // List for storing output
		list1.add(9);
		list1.add(4);
		list1.add(5);
		list1.add(4);
		list1.add(3);
		list1.add(8);
		list1.add(1);
		
		Collections.sort(list1);
		int a = list1.get(1); //Getting the second smallest number in the list
		list2.add(a);
		a = list1.get(list1.size() - 2); //Getting the second largest number in the list
		list2.add(a);
		
		System.out.println(list2.get(0));
		System.out.println(list2.get(1));
		
	}
}


// ALGORITHM TO FIND 2 ARRAYS OF DIFFERENT LENGTH, COPY THE ELEMENTS OF THE ARRAY OF SMALLER LENGTH TO THE ARRAY OF 
// BIGGER LENGTH, SO THAT SIZE OF THE DESTINATION ARRAY IS THE SUM OF BOTH THE ARRAYS ENSURING THAT THERE ARE NO DUPLICATES.
/*
APPROACH 1-
START
Step 1: Input array 1 and know the length of this array (say n1)
Step 2: Input array 2 and know the length of this array (say n2)
Step 3: Find for each element (except null) in the second array whether the element is present in the first array and 
		in the remaining second array also.
			IF-the element is present
			 THEN- replace the value where ever found by null.
Step 4: Count the number of non-null values in the first array.
Step 5: Count the number of non-null values in the second array.
Step 6: Add both counts that we got from Steps 5 and 6
Step 7: Make a new array of length of the count of we got from step 6.
Step 8: Put all the non-null values from 1st array in the new array and then thereafter, put all the non- null values 
		from the second array in the remaining  part of the new array.
Step 9: Print the new array.
STOP
APPROACH 2-
START
Step 1: Input array 1 and know the length of this array (say n1)
Step 2: Input array 2 and know the length of this array (say n2)
Step 3: Declare a Set and insert all the elements from array 1 and array 2.
Step 4: Have the size of the set
Step 5: Create a new array of size of the number we got from the previous step
Step 6: Insert all the elements from the set to the new array
Step 7: Print the new array
STOP
APPROACH 3-
START
Step 1: Input array 1 and know the length of this array (say n1)
Step 2: Input array 2 and know the length of this array (say n2)
Step 3: Add both the lengths
Step 4: Create an array (say array 3) of length of the number we got from Step 3.
Step 5: Put all te values of 1st and 2nd array in the new array
Step 6: Remove the duplicates and replace the duplicate values by null
Step 7: Count the number of non-null values of array 3
Step 8: Create a new array 4 of the  length of the number we got from step 7
Step 9: Take all the non-null elements from array 3 and put array 4
Step 10: Print array 4.
STOP
CONCLUSION-
Finding approach 2 as the best one as it has the least number of operations
*/