package algorithms.array;

public class MissingArray {
    public static void main(String[] args) {
        int[] arry = {1,2,3,4,5,6,7,8,9,11};
        printMissingArray(arry);
    }

    private static void printMissingArray(int[] arry) {
        int sum1=0, sum2=0;
        for (int i :arry) {
            sum1 += i;
        }
        sum2 = 11*(11+1)/2; //n(n+1)/2
        System.out.println("missing number: "+ (sum2-sum1));
    }
}
