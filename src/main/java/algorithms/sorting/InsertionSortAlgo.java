package algorithms.sorting;

import java.util.Arrays;

public class InsertionSortAlgo {
	public static void main(String args[]) {
		// unsorted integer array
		int[] unsorted = { 32, 23, 45, 87, 92, 31, 19 };
		System.out.println("integer array before sorting : " + Arrays.toString(unsorted));
		insertionSort(unsorted);
		System.out.println("integer array after sorting : " + Arrays.toString(unsorted));
	}

	/*
	 * Sort given integer array using Insertion sort algorithm. only good for
	 * small arrays.
	 */
	public static void insertionSort(int[] unsorted) {
		for (int i = 1; i < unsorted.length; i++) {

			int current = unsorted[i];
			int j = i;
			// create right place by moving elements
			while (j > 0 && unsorted[j - 1] > current) {
				// move
				unsorted[j] = unsorted[j - 1];
				j--;
			}
			// found the right place, insert now
			unsorted[j] = current;
		}
	}
}
