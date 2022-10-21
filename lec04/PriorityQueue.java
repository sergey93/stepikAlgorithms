package lec04;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue {
    private List<QueueElement> elements = new ArrayList();

    PriorityQueue() {
    }

    public void insert(String letter, int priority) {
        QueueElement value = new QueueElement(letter, priority);
        this.elements.add(value);
    }

    public QueueElement extractMin() {
        QueueElement min = null;
        int minIndex = -1;

        for(int i = 0; i < this.elements.size(); ++i) {
            QueueElement element = (QueueElement)this.elements.get(i);
            if (min == null || element.compareTo(min) < 0) {
                min = element;
                minIndex = i;
            }
        }

        if (minIndex >= 0) {
            this.elements.remove(minIndex);
        }

        return min;
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }
}

