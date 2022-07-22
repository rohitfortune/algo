package algorithms.sorting;


/* Java program for Merge Sort */
public class MergeSortAlgo { 
	// Merges two subarrays of arr[]. 
	// First subarray is arr[l..m] 
	// Second subarray is arr[m+1..r] 
	void merge(int[] arr, int l, int m, int r){

		// Find sizes of two subarrays to be merged
		int n1 = m-l+2;
		int n2 = r-m+1;

		/* Create temp arrays */
		int[] arr1 = new int[n1];
		int[] arr2 = new int[n2];

		/*Copy data to temp arrays*/
		for (int i=0; i<n1-1; i++){
			arr1[i] = arr[l+i];
		}
		for (int i=0; i<n2-1; i++){
			arr2[i] = arr[m+1+i];
		}

		//Storing max value for optimizing during merging
		arr1[n1-1] = Integer.MAX_VALUE;
		arr2[n2-1] = Integer.MAX_VALUE;

		//Merging arrays
		int i=0,j=0;
		for (int k=l; k<=r; k++){
			if (arr1[i] < arr2[j]){
				arr[k] = arr1[i];
				i++;
			}
			else {
				arr[k] = arr2[j];
				j++;
			}
		}
	}


	// Main function that sorts arr[l..r] using 
	// merge() 
	void mergeSort(int arr[], int l, int r)
	{ 
		if (l < r) { 
			// Find the middle point 
			int m = (l + r) / 2; 

			// Sort first and second halves 
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			// Merge the sorted halves 
			merge(arr, l, m, r);
		} 
	} 

	/* A utility function to print array of size n */
	static void printArray(int arr[]) 
	{ 
		int n = arr.length; 
		for (int i = 0; i < n; ++i) 
			System.out.print(arr[i] + " "); 
		System.out.println(); 
	} 

	// Driver method 
	public static void main(String args[]) 
	{ 
		int arr[] = { 12, 11, 13, 5, 6, 7 }; 

		System.out.println("Given Array"); 
		printArray(arr); 

		MergeSortAlgo ob = new MergeSortAlgo(); 
		ob.mergeSort(arr, 0, arr.length - 1);

		System.out.println("\nSorted array"); 
		printArray(arr); 
	} 
} 