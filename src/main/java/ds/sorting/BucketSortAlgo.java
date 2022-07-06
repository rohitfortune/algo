package ds.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSortAlgo {

    public static void main(String[] args) {
        int[] intArr = {47, 85, 10, 45, 16, 34, 67, 80, 34, 4, 0, 99};
        
        System.out.println("Original array- " + Arrays.toString(intArr));
        bucketSort(intArr);
        System.out.println("Sorted array after bucket sort- " + Arrays.toString(intArr));
    }
    
    private static void bucketSort(int[] intArr){
    	int noOfBuckets =10;
        // Create bucket array
        List<Integer>[] buckets = new List[noOfBuckets];
        // Associate a list with each index 
        // in the bucket array         
        for(int i = 0; i < noOfBuckets; i++){
            buckets[i] = new LinkedList<>();
        }
        // Assign numbers from array to the proper bucket
        // by using hashing function
        for(int num : intArr){
            //System.out.println("hash- " + hash(num));
            buckets[hash(num)].add(num);
        }
        // sort buckets
        for(List<Integer> bucket : buckets){
            Collections.sort(bucket);
        }
        int i = 0;
        // Merge buckets to get sorted array
        for(List<Integer> bucket : buckets){
            for(int num : bucket){
                intArr[i++] = num;
            }
        }
    }
    
    // A very simple hash function
    private static int hash(int num){
        return num/10;
    }
}
