package lec05_6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class GreedyKnapsack {
    public GreedyKnapsack() {
    }

    private void run() throws FileNotFoundException {
        Scanner in = new Scanner(new File("input.txt"));
        int n = in.nextInt();
        int w = in.nextInt();
        Item[] items = new Item[n];

        for(int i = 0; i < n; ++i) {
            items[i] = new Item(in.nextInt(), in.nextInt());
        }

        Arrays.sort(items);
        double result = 0.0;
        Item[] var7 = items;
        int var8 = items.length;

        for(int var9 = 0; var9 < var8; ++var9) {
            Item item = var7[var9];
            if (item.weight > w) {
                result += (double)item.cost * (double)(w / item.weight);
                break;
            }

            w -= item.weight;
            result += (double)item.cost;
        }

        System.out.println(result);
    }

    public static void main(String[] args) throws FileNotFoundException {
        long startTime = System.currentTimeMillis();
        (new GreedyKnapsack()).run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime + " ms");
    }

    class Item implements Comparable<Item> {
        int cost;
        int weight;

        public Item(int cost, int weight) {
            this.cost = cost;
            this.weight = weight;
        }

        public String toString() {
            return "Item{cost=" + this.cost + ", weight=" + this.weight + "}";
        }

        public int compareTo(Item o) {
            long r1 = (long)(this.cost * o.weight);
            long r2 = (long)(this.weight * o.cost);
            return -Long.compare(r1, r2);
        }
    }
}
