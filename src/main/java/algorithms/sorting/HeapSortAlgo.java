package algorithms.sorting;

import algorithms.heap.MyBinaryHeap;

public class HeapSortAlgo {

	public static void main(String[] args) {
		int[] arr = {235, 10, 0, 345, 345, 866, 523, 144, 40}; 
		
		printArray(arr);
		
		//creating object of min heap
		MyBinaryHeap<Integer> heap = new MyBinaryHeap<>();
		
		//storing arr into heap
		for(int i : arr) {
			heap.add(i);
		}
		//creating output array
		int[] result = new int[arr.length];
		
		//removing element from top of min heap and storing in output arrray
		for(int i=0; i<arr.length; i++) {
			result[i] = heap.removeAt(0);
		}
		
		printArray(result);
		
		//sorting original array using max heap
		heapSort(arr,arr.length);
		
		printArray(arr);
	}
	
	private static void heapSort(int[] arr, int n) {
		
		for(int i= Math.max(0, (n/2)-1) ; i>=0 ; i--) {
			heapify(arr, n, i);
		}
		
		for(int i=n-1; i>=0 ; i--) {
			swap(arr, 0, i);
			heapify(arr, i, 0);
		}
	}
	
	private static void heapify(int[] arr, int n, int i) {
		
		int largest = i;
		int left = (2*i)+1;
		int right = (2*i)+2;
		
		if(left<n && arr[left]> arr[largest])
			largest = left;
		if(right<n && arr[right]> arr[largest])
			largest = right;
		if(largest!=i) {
			swap(arr, largest,i);
			heapify(arr, n, largest);
		}
	}

	private static void swap(int[] arr, int largest, int i) {
		
		int temp = arr[largest];
		arr[largest] = arr[i];
		arr[i] = temp;
	}

	static void printArray(int[] arr) 
	{ 
		for (int i = 0; i < arr.length; i++) 
		{ 
			System.out.print(arr[i] + " "); 
		} 
		System.out.println(""); 
	} 

}
