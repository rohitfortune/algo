package algorithms.recursive;

import java.util.Arrays;

public class SomeRecursive {

    public static void main(String[] args) {
        OddFunction odd = new OddFunction();
        System.out.println(someRecursive(new int[]{6, 2, 4}, odd));
        System.out.println(someRecursive(new int[]{6, 3, 4}, odd));
    }

    public static boolean someRecursive(int[] arr, OddFunction odd) {
        if(arr == null || arr.length < 1){
            return false;
        }
        if(arr.length == 1){
            return odd.run(arr[0]);
        }

        return odd.run(arr[0]) || someRecursive(Arrays.copyOfRange(arr, 1, arr.length), odd);
    }
}

class OddFunction {
    boolean run(int num) {
        if (num % 2 == 0) {
            return false; }
        else {
            return true;
        }
    }
}