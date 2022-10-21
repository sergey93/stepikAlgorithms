package lec04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GreedyAlgorithms {
    public GreedyAlgorithms() {
    }

    public List<Double> pointsCover(double[] s) {
        List<Double> res = new ArrayList();
        Arrays.sort(s);
        int i = 0;

        while(i < s.length) {
            double l;
            for(l = s[i]; s[i] < l + 1.0 && i < s.length; ++i) {
            }

            res.add(l);
        }

        return res;
    }

    public List<int[]> actSel(int[][] s) {
        List<int[]> res = new ArrayList();
        this.sort(s, 0, s.length - 1);
        int[] last = null;

        for(int i = 0; i < s.length; ++i) {
            if (last == null || last[1] < s[i][0]) {
                last = s[i];
                res.add(last);
            }
        }

        return res;
    }

    public List<Integer> ex_1(int[][] s) {
        List<Integer> res = new ArrayList();
        this.sort(s, 0, s.length - 1);
        int last = -1;

        for(int i = 0; i < s.length; ++i) {
            if (last < s[i][0]) {
                last = s[i][1];
                res.add(last);
            }
        }

        return res;
    }

    public double ex_2(double[][] s, double capacity) {
        double res = 0.0;
        Arrays.sort(s, Comparator.comparingDouble((a) -> {
            return a[2];
        }));

        for(int i = s.length - 1; i >= 0 && capacity > 0.0; --i) {
            double p = 1.0;
            if (s[i][1] > capacity) {
                p = capacity / s[i][1];
            }

            capacity -= s[i][1] * p;
            res += s[i][0] * p;
        }

        return res;
    }

    public void sort(int[][] array, int low, int high) {
        if (array.length != 0) {
            if (low < high) {
                int middle = low + (high - low) / 2;
                int opora = array[middle][1];
                int i = low;
                int j = high;

                while(i <= j) {
                    while(array[i][1] < opora) {
                        ++i;
                    }

                    while(array[j][1] > opora) {
                        --j;
                    }

                    if (i <= j) {
                        int[] temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                        ++i;
                        --j;
                    }
                }

                if (low < j) {
                    this.sort(array, low, j);
                }

                if (high > i) {
                    this.sort(array, i, high);
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        double w = in.nextDouble();
        double[][] s = new double[n][];

        for(int i = 0; i < n; ++i) {
            s[i] = new double[3];
            s[i][0] = (double)in.nextInt();
            s[i][1] = (double)in.nextInt();
            s[i][2] = s[i][0] / s[i][1];
        }

        double res = (new GreedyAlgorithms()).ex_2(s, w);
        System.out.println(res);
    }
}

