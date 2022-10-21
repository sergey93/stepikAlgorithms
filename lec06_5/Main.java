package lec06_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws FileNotFoundException {
        (new Main()).test();
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        Segment[] segments = new Segment[n];

        for(int i = 0; i < n; ++i) {
            segments[i] = new Segment(in.nextInt(), in.nextInt());
        }

        int[] numbers = new int[m];
        Map<Integer, Integer> numberOfOccurrences = new HashMap();

        for(int i = 0; i < m; ++i) {
            numbers[i] = in.nextInt();
            if (!numberOfOccurrences.containsKey(numbers[i])) {
                numberOfOccurrences.put(numbers[i], 0);
            }
        }

        int[] a_numbers = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(segments);
        Arrays.sort(numbers);
        int i = 0;
        int j = 0;

        int point;
        while(i < segments.length && j < numbers.length) {
            for(point = numbers[j]; i < segments.length && segments[i].getB() < point; ++i) {
            }

            int count;
            for(count = (Integer)numberOfOccurrences.get(point); i < segments.length && segments[i].getA() <= point && segments[i].getB() >= point; ++count) {
                ++i;
            }

            numberOfOccurrences.put(point, count);

            while(j < numbers.length && point == numbers[j]) {
                ++j;
            }
        }

        for(point = 0; point < a_numbers.length; ++point) {
            PrintStream var10000 = System.out;
            Object var10001 = numberOfOccurrences.get(a_numbers[point]);
            var10000.print("" + var10001 + " ");
        }

    }

    public void test() throws FileNotFoundException {
        new Generate();

        int[] res2;
        int[] res1;
        do {
            Scanner in = new Scanner(new File("input.txt"));
            int n = in.nextInt();
            int m = in.nextInt();
            Segment[] segments = new Segment[n];

            for(int i = 0; i < n; ++i) {
                segments[i] = new Segment(in.nextInt(), in.nextInt());
            }

            int[] numbers = new int[m];

            for(int i = 0; i < m; ++i) {
                numbers[i] = in.nextInt();
            }

            res1 = this.fastAlgo(Arrays.copyOf(numbers, numbers.length), segments);
            res2 = this.naiveAlgo(Arrays.copyOf(numbers, numbers.length), segments);
            System.out.println("------------------------------");
            System.out.println("naive: " + Arrays.toString(res2));
            System.out.println("fast: " + Arrays.toString(res1));
            System.out.println("------------------------------");
        } while(Arrays.equals(res1, res2));

    }

    private int[] fastAlgo(int[] numbers, Segment[] segments) {
        int[] a_numbers = Arrays.copyOf(numbers, numbers.length);
        Arrays.sort(segments);
        Arrays.sort(numbers);
        Map<Integer, Integer> numberOfOccurrences = new HashMap();

        int i;
        for(i = 0; i < numbers.length; ++i) {
            if (!numberOfOccurrences.containsKey(numbers[i])) {
                numberOfOccurrences.put(numbers[i], 0);
            }
        }

        i = 0;
        int j = 0;

        int point;
        while(i < segments.length && j < numbers.length) {
            for(point = numbers[j]; i < segments.length && segments[i].getB() < point; ++i) {
            }

            int count;
            for(count = (Integer)numberOfOccurrences.get(point); i < segments.length && segments[i].getA() <= point && segments[i].getB() >= point; ++count) {
                ++i;
            }

            numberOfOccurrences.put(point, count);

            while(j < numbers.length && point == numbers[j]) {
                ++j;
            }
        }

        for(point = 0; point < a_numbers.length; ++point) {
            a_numbers[point] = (Integer)numberOfOccurrences.get(a_numbers[point]);
        }

        return a_numbers;
    }

    private int[] naiveAlgo(int[] numbers, Segment[] segments) {
        Arrays.sort(segments);

        for(int i = 0; i < numbers.length; ++i) {
            int count = 0;
            Segment[] var5 = segments;
            int var6 = segments.length;

            for(int var7 = 0; var7 < var6; ++var7) {
                Segment segment = var5[var7];
                if (numbers[i] >= segment.getA() && numbers[i] <= segment.getB()) {
                    ++count;
                }
            }

            numbers[i] = count;
        }

        return numbers;
    }
}
