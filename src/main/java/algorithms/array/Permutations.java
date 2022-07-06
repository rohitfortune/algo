package algorithms.array;

public class Permutations {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 7, 8};
        int[] arr2 = {1, 8, 3, 4, 5, 7, 2};
        boolean isPermutation = isPermutation(arr1, arr2);
        System.out.println(isPermutation);
    }

    private static boolean isPermutation(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length){
            return false;
        }
        int sum1=0, sum2=0, product1=1, product2=1;
        for (int i=0; i<arr1.length; i++){
            sum1 += arr1[i];
            sum2 += arr2[i];
            product1 *= arr1[i];
            product2 *= arr2[i];
        }
        if (sum1 == sum2 && product1 == product2){
            return true;
        }
        return false;
    }
}
