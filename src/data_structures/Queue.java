package data_structures;

import implementations.MyLinkedList;

public class Queue <T> {
    private final MyLinkedList<T> queue;

    public Queue(){queue= new MyLinkedList<>();}
    public boolean empty(){return queue.size()==0;}
    public int size(){return queue.size();}
    public T peek() {return queue.getFirst();}
    public T enqueue (T item) {queue.addLast(item); return item;}
    public T dequeue() {
        if (empty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return queue.removeFirst();
    }
}

