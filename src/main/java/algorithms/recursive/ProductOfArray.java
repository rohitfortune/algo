package algorithms.recursive;

public class ProductOfArray {
    public static void main(String[] args) {
        System.out.println(productofArray(new int[]{1, 2, 3, 4, 5}, 5));
    }
    public static int productofArray(int A[], int N)
    {
        //   TODO
        if(N == 1){
            return A[N-1];
        }
        return A[N-1] * productofArray(A, N-1);
    }
}
