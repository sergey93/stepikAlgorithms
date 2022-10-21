package lec04_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class PriorityQueue {
    public PriorityQueue() {
    }

    public static void main(String[] args) {
        (new PriorityQueue()).test();
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        MaxHeap heap = new MaxHeap();

        for(int i = 0; i < n; ++i) {
            String[] command = in.nextLine().split(" ");
            if (command[0].equalsIgnoreCase("insert")) {
                int x = Integer.parseInt(command[1]);
                heap.insert(x);
            } else {
                System.out.println(heap.extractMax());
            }
        }

    }

    public void test() {
        Random r = new Random();
        int maxN = 10;

        String[] commands;
        ArrayList res2;
        ArrayList res1;
        MaxHeap heap;
        int i;
        do {
            int n = r.nextInt(maxN) + 1;
            res1 = new ArrayList();
            res2 = new ArrayList();
            heap = new MaxHeap();
            List<Integer> queue = new ArrayList();
            commands = new String[n];

            int c;
            for(i = 0; i < n; ++i) {
                c = r.nextInt(2);
                commands[i] = "ExtractMax";
                if (c == 1) {
                    commands[i] = "Insert " + r.nextInt(1000000001);
                }
            }

            String[] var17 = commands;
            c = commands.length;

            for(int var11 = 0; var11 < c; ++var11) {
                String s = var17[var11];
                String[] command = s.split(" ");
                if (command[0].equalsIgnoreCase("insert")) {
                    int x = Integer.parseInt(command[1]);
                    heap.insert(x);
                    this.insert(queue, x);
                } else {
                    res1.add(this.extractMax(queue));
                    res2.add(heap.extractMax());
                }
            }
        } while(res2.equals(res1));

        heap = new MaxHeap();
        String[] var15 = commands;
        int var16 = commands.length;

        for(i = 0; i < var16; ++i) {
            String s = var15[i];
            String[] command = s.split(" ");
            if (command[0].equalsIgnoreCase("insert")) {
                int x = Integer.parseInt(command[1]);
                heap.insert(x);
            } else {
                heap.extractMax();
            }
        }

    }

    private int extractMax(List<Integer> queue) {
        int max = -1;
        int maxIndex = -1;

        for(int i = 0; i < queue.size(); ++i) {
            if (max < (Integer)queue.get(i)) {
                max = (Integer)queue.get(i);
                maxIndex = i;
            }
        }

        if (maxIndex >= 0) {
            queue.remove(maxIndex);
        }

        return max;
    }

    private void insert(List<Integer> queue, int x) {
        queue.add(x);
    }
}

