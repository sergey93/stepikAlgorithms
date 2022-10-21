package lec06_4;

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
        int n = 7;
        printWriter.println(n);

        for(int i = 0; i < n; ++i) {
            printWriter.print(r.nextInt(10) + " ");
        }

        printWriter.close();
    }
}

