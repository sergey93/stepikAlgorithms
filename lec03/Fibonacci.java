package lec03;

import java.math.BigInteger;

public class Fibonacci {
    private int fibNaive(int n) {
        return n < 2 ? n : this.fibNaive(n - 1) + this.fibNaive(n - 2);
    }

    public BigInteger fib(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        for(int i = 2; i <= n; ++i) {
            BigInteger c = a.add(b);
            a = b;
            b = c;
        }

        return b;
    }

    private void run(int n) {
        System.out.println("" + n + ": " + this.fibNaive(n));
    }

    private void runFast(int n) {
        System.out.println("" + n + ": " + this.fib(n));
    }

    public static void main(String[] args) {
        for(int i = 1; i <= 50; ++i) {
            System.out.println("slow:");
            long startTime = System.currentTimeMillis();
            (new Fibonacci()).run(i);
            long finishTime = System.currentTimeMillis();
            System.out.println(finishTime - startTime + " ms");
            System.out.println("fast:");
            startTime = System.currentTimeMillis();
            (new Fibonacci()).runFast(i);
            finishTime = System.currentTimeMillis();
            System.out.println(finishTime - startTime + " ms");
        }

    }
}
