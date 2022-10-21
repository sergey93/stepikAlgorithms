package lec06_1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Generate {
    public Generate() {
    }

    public static void main(String[] args) throws FileNotFoundException {
        (new Generate()).run();
    }

    private void run() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("input.txt");
        Random r = new Random();
        int n = r.nextInt(100001) + 1;
        printWriter.print("" + n + " ");

        int k;
        for(k = 0; k < n; ++k) {
            printWriter.print(r.nextInt(1000001) + " ");
        }

        k = r.nextInt(100001) + 1;
        printWriter.println("" + k + " ");

        for(int i = 0; i < k; ++i) {
            printWriter.print(r.nextInt(1000001) + " ");
        }

        printWriter.close();
    }
}