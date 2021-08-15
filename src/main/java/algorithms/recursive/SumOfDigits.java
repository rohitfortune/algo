package algorithms.recursive;

public class SumOfDigits {
    public static void main(String[] args) {
        System.out.println(calculate(523));
    }

    private static int calculate(int i) {
        if (i<=0){
            return 0;
        }
        return i%10 + calculate(i/10);
    }
}
