package lec02;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int m = in.nextInt();
        System.out.println(divideByModule(n, m));
    }

    public static int divideByModule(long n, int m) {
        int[] f = new int[6 * m + 1];
        f[0] = 0;
        f[1] = 1;
        int period = 0;

        for(int i = 2; i <= 6 * m && (long)i <= n; ++i) {
            f[i] = (f[i - 2] + f[i - 1]) % m;
            if (i > 2 && f[0] == f[i - 1] && f[1] == f[i]) {
                period = i - 1;
                break;
            }
        }

        long index = n;
        if ((long)period < n) {
            index = n % (long)period;
        }

        return f[(int)index];
    }
}
