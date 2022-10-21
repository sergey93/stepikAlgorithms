package lec06_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private int count = 0;
    private Map<Integer, List<Integer>> inversions = new HashMap();

    public Main() {
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        (new Main()).run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    public void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int[] a = new int[n];

        for(int i = 0; i < n; ++i) {
            a[i] = in.nextInt();
        }

        this.iterativeMergeSort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("_______");
        int c = 0;

        for(int i = 0; i < n; ++i) {
            List<Integer> s = new ArrayList();

            for(int j = i + 1; j < n; ++j) {
                if (a[i] > a[j]) {
                    ++c;
                    s.add(a[j]);
                }
            }

            System.out.println(a[i] + ": " + s);
        }

        System.out.println("_______");
        Iterator var9 = this.inversions.entrySet().iterator();

        while(var9.hasNext()) {
            Map.Entry<Integer, List<Integer>> integerListEntry = (Map.Entry)var9.next();
            PrintStream var10000 = System.out;
            Object var10001 = integerListEntry.getKey();
            var10000.println("" + var10001 + ": " + integerListEntry.getValue());
        }

        System.out.println("" + c + ": " + this.count);
    }
    public int[] recursiveMergeSort(int[] a, int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            a = this.merge(this.recursiveMergeSort(a, l, m), this.recursiveMergeSort(a, m + 1, r));
        }
        return a;
    }

    public int[] iterativeMergeSort(int[] a) {
        Deque<int[]> q = new ArrayDeque();
        int[] var3 = a;
        int var4 = a.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            int elem = var3[var5];
            q.addLast(new int[]{elem});
        }

        while(q.size() > 1) {
            int[] left = (int[])q.pop();
            int[] right = (int[])q.pop();
            q.addLast(this.merge(left, right));
        }

        return q.pop();
    }

    public int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int p_a = 0;
        int p_b = 0;
        int c = 0;

        for(int i = 0; i < res.length; ++i) {
            int value;
            if (p_a == a.length) {
                value = b[p_b++];
            } else if (p_b == b.length) {
                value = a[p_a++];
            } else if (a[p_a] <= b[p_b]) {
                value = a[p_a++];
            } else {
                for(int j = p_a; j < a.length && a[j] > b[p_b]; ++j) {
                    List<Integer> newValue;
                    if (this.inversions.containsKey(a[j])) {
                        newValue = this.inversions.get(a[j]);
                    } else {
                        newValue = new ArrayList();
                    }

                    newValue.add(b[p_b]);
                    this.inversions.put(a[j], newValue);
                }

                value = b[p_b++];
                c += a.length - p_a;
            }

            res[i] = value;
        }

        this.count += c;
        PrintStream var10000 = System.out;
        String var12 = Arrays.toString(a);
        var10000.println(var12 + " + " + Arrays.toString(b) + ": " + c);
        System.out.println(Arrays.toString(res));
        return res;
    }
}

