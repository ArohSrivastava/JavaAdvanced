package Algorithms;

//PROGRAM TO SEARCH A NUMBER IN AN ARRAY USING BINARY SEARCH TECHNIQUE

/*
*	ALGORITHM:
*		START
*		Step 0: PREREQUISITE- Assuming that the elements in the array are present in sorted manner.
*		Step 1: Begin with the mid element of the whole array as a search key.
*		Step 2: IF the value of the search key is equal to the item 
*					THEN return an index of the search key.
*				ELSE IF the value of the search key is less than the item in the middle of the interval
*					THEN narrow the interval to the lower half.
*				ELSE
*					THEN narrow it to the upper half.
*		Step 3: Repeatedly check from the second point until the value is found or the interval is empty.
*		STOP
*/

public class DivideAndConquerAlgorithm {
	int binarySearch(int array[], int x, int low, int high) {

		while (low <= high) // Repeat until the pointers low and high meet each other
		{
			int mid = low + (high - low) / 2; // This marks the essence of Divide and Conquer technique

			if (array[mid] == x)
				return mid;

			if (array[mid] < x)
				low = mid + 1;

			else
				high = mid - 1;
		}
		return -1;
	}

	public static void main(String args[]) {
		DivideAndConquerAlgorithm ob = new DivideAndConquerAlgorithm();
		int array[] = { 3, 4, 5, 6, 7, 8, 9 }; //the elements in the array are present in sorted manner, its a pre-reuisite in Binary search
		int n = array.length;
		int x = 4;
		int result = ob.binarySearch(array, x, 0, n - 1);
		if (result == -1)
			System.out.println("Not found");
		else
			System.out.println("Element found at index " + result);
	}
}