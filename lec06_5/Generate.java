package lec06_5;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

public class Generate {
    private final int bound = 1000;
    private final int sizeN = 10;
    private final int sizeM = 10;

    public Generate() {
    }

    public static void main(String[] args) throws FileNotFoundException {
        (new Generate()).run();
    }

    public void run() throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter("input.txt");
        Random r = new Random();
        int n = r.nextInt(10) + 1;
        int m = r.nextInt(10) + 1;
        printWriter.println("" + n + " " + m);

        int i;
        for(i = 0; i < n; ++i) {
            int a = r.nextInt(1000);
            int b = r.nextInt(1000);
            if (a <= b) {
                printWriter.println("" + a + " " + b);
            } else {
                printWriter.println("" + b + " " + a);
            }
        }

        for(i = 0; i < m; ++i) {
            printWriter.print(r.nextInt(1000) + " ");
        }

        printWriter.close();
    }
}

