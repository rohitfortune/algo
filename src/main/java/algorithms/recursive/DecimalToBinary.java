package algorithms.recursive;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(deciToBinary(10));
    }

    private static int deciToBinary(int n) {
        if (n == 0){return 0;}
        return n%2 + 10 * deciToBinary(n/2);
    }
}
