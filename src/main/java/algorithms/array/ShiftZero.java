package algorithms.array;

import java.util.Arrays;

public class ShiftZero {

    public static void main(String[] args) {
        int[] arr = {0,1,0,0,3,0,12};
        int[] res = shiftArrN(arr);
        System.out.print(Arrays.toString(res));
    }

    private static int[] shiftArr(int[] arr) {

        int N=0;
        int i=0;
        int len = arr.length;
        while (i < len || N < len){
            if(i< len){
                if(arr[i] != 0) {
                    arr[N++] = arr[i++];
                }else {
                    i++;
                }


            }else if(N < len){
                arr[N++] =0;
            }
        }

        return arr;

    }

    private static int[] shiftArrN(int[] arr) {

        int index=0;
        int len = arr.length;
        //0, 1, 0, 3, 12
        for (int i=0; i<len; i++){

            if (arr[i] != 0 ){

                int temp = arr[i];
                arr[i]=0;
                arr[index++] = temp;

            }
        }
        return arr;
    }
}
