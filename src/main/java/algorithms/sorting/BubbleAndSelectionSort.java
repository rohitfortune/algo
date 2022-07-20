package algorithms.sorting;

import java.util.Arrays;

public class BubbleAndSelectionSort {
    public static void main(String[] args) {
        int[] intArr1 = {47, 85, 10, 45, 16, 34, 67, 80, 34, 4, 0, 99};

        System.out.println("Original array- " + Arrays.toString(intArr1));
        bubbleSort(intArr1);
        System.out.println("Sorted array after bubble sort- " + Arrays.toString(intArr1));

        int[] intArr2 = {47, 85, 10, 45, 16, 34, 67, 80, 34, 4, 0, 99};
        selectionSort(intArr2);
        System.out.println("Sorted array after bubble sort- " + Arrays.toString(intArr2));
    }

    private static void bubbleSort(int[] intArr) {
        for (int i=0; i<intArr.length-1; i++){
            for (int j=0; j<intArr.length-i-1; j++){
                if (intArr[j]>intArr[j+1]){
                    int temp = intArr[j+1];
                    intArr[j+1] = intArr[j];
                    intArr[j] = temp;
                }
            }
        }
    }

    private static void selectionSort(int[] intArr) {
        for (int i=0; i<intArr.length-1; i++){
            int minIndex=i;
            for (int j=i+1; j<intArr.length; j++){
                if (intArr[j]<intArr[minIndex])
                   minIndex = j;
            }
            if (minIndex != i){
                int temp = intArr[minIndex];
                intArr[minIndex] = intArr[i];
                intArr[i] = temp;
            }
        }
    }

}
