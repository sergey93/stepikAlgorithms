package lec04;

public class QueueElement implements Comparable {
    private String letter;
    private int priority;

    QueueElement(String letter, int priority) {
        this.letter = letter;
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }

    public String getLetter() {
        return this.letter;
    }

    public int compareTo(Object o) {
        QueueElement obj = (QueueElement)o;
        return obj == null ? 1 : Integer.compare(this.priority, obj.priority);
    }
}

