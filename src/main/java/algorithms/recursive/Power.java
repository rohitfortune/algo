package algorithms.recursive;

public class Power {
    public static void main(String[] args) {
        System.out.println(cal(2,8));
    }

    private static int cal(int base, int exp) {
        if (exp < 0){
            return -1;
        }
        if (exp == 0){
            return 1;
        }
        return base * cal(base, exp-1);
    }
}
