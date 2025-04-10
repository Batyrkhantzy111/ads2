package data_structures;

import implementations.MyLinkedList;

public class Queue <T> {
    private final MyLinkedList<T> queue;
    private int size;

    public Queue(){queue= new MyLinkedList<>();}
    public boolean empty(){return size==0;}
    public int size(){return size;}
    public T peek() {return queue.getFirst();}
    public T enqueue (T item) {queue.addLast(item); return item;}
    public T dequeue() {return queue.removeFirst();}
}

