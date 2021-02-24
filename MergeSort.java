// Module 7; Merge Sort example
public class MergeSort 
{
	
	private static void PrintArray(int[] array)
	{
		// Displaying the array
		for(int i: array)
		{
			System.out.print(i + " ");
		}
		// Clean Output
		System.out.println("");
	}
	
	private static int[] MergeSortMethod(int[] array)
	{
		// Stopping recursion to display array 
		if (array.length <= 1)
		{
			return array;
		}
		
		// Defining the middle of the entire array
		int midpoint = array.length / 2;
		
		// Defining the left and right side split of the array from the midpoint
		int[] leftArray = new int[midpoint];
		int[] rightArray;
		
		// If our array does not divide evenly
		if (array.length % 2 == 0)
		{
			rightArray = new int[midpoint];
		}
		
		else 
		{
			rightArray = new int[midpoint + 1];
		}
		
		// Populating the arrays
		for (int i = 0; i < midpoint; i++)
		{
			leftArray[i] = array[i];
		}
		
		for (int j = 0; j < rightArray.length; j++)
		{
			rightArray[j] = array[midpoint + j];
		}
		
		// Declaring our resulting array after sorting
		int[] resultArray = new int[array.length];
		
		// Recursion to sort the Left and Right arrays
		leftArray = MergeSortMethod(leftArray);
		rightArray = MergeSortMethod(rightArray);
		
		resultArray = MergeArrays(leftArray, rightArray);
		
		return resultArray;
		
	}
	
	private static int[] MergeArrays(int[] leftArray, int[] rightArray) 
	{
		// Merging together the sorting arrays
		int[] newResultArray = new int[leftArray.length + rightArray.length];
		
		// Declaring pointer variables to merge sort our left and right arrays
		int leftPointer, rightPointer, resultPointer;
		leftPointer = rightPointer = resultPointer = 0;
		
		// While we have arrays we can sort (arrays that contain enough elements)
		while (leftPointer < leftArray.length || rightPointer < rightArray.length)
		{
			
			if (leftPointer < leftArray.length && rightPointer < rightArray.length)
			{
				if (leftArray[leftPointer] < rightArray[rightPointer])
				{
					newResultArray[resultPointer++] = leftArray[leftPointer++];
				}
				else
				{
					newResultArray[resultPointer++] = rightArray[rightPointer++];
				}
			}
			
			else if(leftPointer < leftArray.length)
			{
				newResultArray[resultPointer++] = leftArray[leftPointer++];
			}
			
			else if(rightPointer < rightArray.length)
			{
				newResultArray[resultPointer++] = rightArray[rightPointer++];
			}
		}
		
		return newResultArray;
	}
	
	public static void main(String[] args)
	{
		// Declaring an array to sort
		int[] mergeArray = {5, 4, 3, 2, 1};
		
		// Printing the array before merging
		System.out.println("The inital array is: ");
		PrintArray(mergeArray);
		
		mergeArray = MergeSortMethod(mergeArray);
		System.out.println("The sorted array is: ");
		PrintArray(mergeArray);
	}
}
