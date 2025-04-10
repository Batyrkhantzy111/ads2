package data_structures;

import implementations.MyArrayList;

public class Stack <T>{
    private final MyArrayList<T> stack;
    private int size;

    public Stack(){ stack = new MyArrayList<>(); }
    public boolean empty(){ return size==0;}
    public int size(){return size;}
    public T peek(){return stack.get(size-1);}
    public T push (T item) {stack.add(item); return item;}
    public T pop() {return stack.remove(size-1);}
}
