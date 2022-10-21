package lec06_1;

import java.io.PrintStream;
import java.util.Scanner;

public class BinarySearch {
    public BinarySearch() {
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];

        int k;
        for(k = 0; k < n; ++k) {
            a[k] = in.nextInt();
        }

        k = in.nextInt();
        int[] b = new int[k];

        int i;
        for(i = 0; i < k; ++i) {
            b[i] = in.nextInt();
        }

        in.close();

        for(i = 0; i < k; ++i) {
            PrintStream var10000 = System.out;
            int var10001 = search(a, b[i]);
            var10000.print("" + var10001 + " ");
        }

    }

    static int search(int[] a, int element) {
        int l = 0;
        int r = a.length - 1;

        int m;
        do {
            if (l > r) {
                return -1;
            }

            m = l + (r - l) / 2;
            if (element < a[m]) {
                r = m - 1;
            }

            if (element > a[m]) {
                l = m + 1;
            }
        } while(element != a[m]);

        return m + 1;
    }
}