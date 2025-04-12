package data_structures;

import implementations.MyArrayList;

public class MyMinHeap<T extends Comparable<T>> {
    private final MyArrayList<T> heap;

    // Default constructor
    public MyMinHeap() {
        heap = new MyArrayList<>();
    }

    // Inserting a new item
    public void insert(T item) {
        heap.add(item);
        traverseUp(heap.size() - 1);
    }

    // Traverse up the element at the given index
    private void traverseUp(int index) {
        while (index > 0 && heap.get(index).compareTo(heap.get(parentOf(index))) < 0) {
            swap(index, parentOf(index));
            index = parentOf(index);
        }
    }

    // Heapify the element at the index to maintain heap order
    private void heapify(int index) {
        int left= leftChildOf(index);
        int right= rightChildOf(index);
        int smallest= index;

        if (left < heap.size() && heap.get(left).compareTo(heap.get(smallest)) < 0) {
            smallest = left;
        }

        if (right < heap.size() && heap.get(right).compareTo(heap.get(smallest)) < 0) {
            smallest = right;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    // Extracts and returns the root element
    public T extractMin() {
        if (empty()) {
            throw new IllegalStateException("Heap is empty!");
        }
        T min = heap.get(0);
        T last = heap.remove(heap.size() - 1);
        if (!empty()) {
            heap.set(0, last);
            heapify(0);
        }
        return min;
    }

    // Helper for extractMin function
    public T extract_min() {
        return extractMin();
    }

    public boolean empty() {
        return heap.size() == 0;
    }

    // Returns the root element
    public T getMin() {
        if (empty()) {
            throw new IllegalStateException("Heap is empty!");
        }
        return heap.get(0);
    }

    // Returns the index of the left child for the index
    private int leftChildOf(int index) {
        return 2*index+1;
    }

    // Returns the index of the right child for the index
    private int rightChildOf(int index) {
        return 2*index+2;
    }

    // Returns the index of the parent for the index
    private int parentOf(int index) {
        return (index-1)/2;
    }

    private void swap(int i, int j) {
        T temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}