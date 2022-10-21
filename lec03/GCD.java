package lec03;

import java.math.BigInteger;

public class GCD {
    public GCD() {
    }

    public BigInteger euclidGCD(BigInteger a, BigInteger b) {
        while(true) {
            System.out.println("" + a + "   " + b);
            if (a.equals(BigInteger.ZERO)) {
                return b;
            }

            if (b.equals(BigInteger.ZERO)) {
                return a;
            }

            if (a.compareTo(b) >= 0) {
                a = a.mod(b);
            } else {
                b = b.mod(a);
            }
        }
    }

    private void run(BigInteger a, BigInteger b) {
        System.out.println(this.euclidGCD(a, b));
    }

    public static void main(String[] args) {
        BigInteger a = new BigInteger("123432122412431312432344377885448478545131745634564563422445657656218");
        BigInteger b = new BigInteger("99854565429124399932344377885448478545136677987987989708790663431444");
        long startTime = System.currentTimeMillis();
        (new GCD()).run(a, b);
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }
}

