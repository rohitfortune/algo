package com.example.sorting;

import java.util.Arrays;

public class RedixSortAlgo {

	public static void main(String[] args) {
		int[] arr = {-235, -10, 0, -345, 866, 523, -144, 40}; 
		printArray(arr); 
		redixSort(arr); 
		printArray(arr); 
	}
	
	private static void redixSort(int[] arr) {
		int min = Arrays.stream(arr).min().getAsInt();				
		int max = Arrays.stream(arr).max().getAsInt();
		
		for(int pos=1; ((max-min)/pos)>0; pos= pos*10) {
			countSort(arr, min, pos);
		}
	}
	
	private static void countSort(int[] arr, int min, int pos) {
		int[] count = new int[10];
		Arrays.fill(count, 0);
		
		for(int i=0;i<arr.length;i++) {
			++count[ ((arr[i]-min)/pos) %10]; 
		}
		
		for(int i=1;i<10;i++) {
			count[i] += count[i-1];
		}
		
		int[] b = new int[arr.length];
		for(int i=arr.length-1; i>=0; i--) {
			b[--count[ ((arr[i]-min)/pos) %10]] = arr[i];
		}
		
		for(int i=0; i<arr.length; i++)
			arr[i]=b[i];
		
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
