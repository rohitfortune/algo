package algorithms.recursive;

import java.lang.annotation.Documented;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fib(8));
    }

    // Returns the number at nth index in fibonacci series
    public static int fib(int n) {
        if(n == 1 || n == 0){
            return n;
        }
        if(n < 0){
            return -1;
        }
        return fib(n-1) + fib(n-2);
        // TODO
    }
}
