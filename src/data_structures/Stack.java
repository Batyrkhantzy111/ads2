package data_structures;

import implementations.MyArrayList;

public class Stack <T>{
    private final MyArrayList<T> stack;

    public Stack(){ stack = new MyArrayList<>(); }
    public boolean empty(){ return stack.size()==0;}
    public int size(){return stack.size();}
    public T peek()
    {
        if (empty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return stack.get(stack.size()-1);
    }
    public T push (T item) {stack.add(item); return item;}
    public T pop() {
        if (empty()) {
            throw new IllegalStateException("Stack is empty!");
        }
        return stack.remove(stack.size()-1);
    }
}
