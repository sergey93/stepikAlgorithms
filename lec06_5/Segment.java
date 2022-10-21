package lec06_5;

public class Segment implements Comparable<Segment> {
    private int a;
    private int b;

    public Segment(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return this.a;
    }

    public int getB() {
        return this.b;
    }

    public int compareTo(Segment o) {
        if (this.a < o.getA()) {
            return -1;
        } else if (this.a > o.getA()) {
            return 1;
        } else if (this.b < o.getB()) {
            return -1;
        } else {
            return this.b > o.getB() ? 1 : 0;
        }
    }
}

