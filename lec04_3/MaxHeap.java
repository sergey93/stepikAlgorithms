package lec04_3;

import java.util.ArrayList;
import java.util.List;

class MaxHeap {
    private List<Integer> elements;
    MaxHeap() {
        elements = new ArrayList<>();
    }
    public void insert(int value) {
        elements.add(value);
        int index = elements.size();
        siftUp(index);
    }

    private void siftUp(int index) {
        int value = elements.get(index - 1);
        int parentIndex = (index == 1) ? 1 : index / 2;
        while (value > elements.get(parentIndex - 1)) {
            elements.set(index - 1, elements.get(parentIndex - 1));
            elements.set(parentIndex - 1, value);
            index = parentIndex;
            parentIndex = (index == 1) ? 1 : index / 2;
        }
    }

    public int extractMax() {
        int max = elements.get(0);
        int value = elements.get(elements.size() - 1);
        elements.set(0, value);
        elements.remove(elements.size() - 1);
        if (!elements.isEmpty())
            siftDown(1);
        return max;
    }

    private void siftDown(int index) {
        int value = elements.get(index - 1);
        int lch = 2 * index;
        int rch = 2 * index + 1;
        int l = elements.size();
        while (lch <= l && value < elements.get(lch - 1)
                || rch <= l && value < elements.get(rch - 1)) {
            int k = lch;
            if (rch <= l && elements.get(rch - 1) >= elements.get(lch - 1)) {
                k = rch;
            }
            elements.set(index - 1, elements.get(k - 1));
            elements.set(k - 1, value);
            index = k;
            lch = index * 2;
            rch = index * 2 + 1;
        }
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }
}