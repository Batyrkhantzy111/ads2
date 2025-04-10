package implementations;

public class MyMinHeap <T extends Comparable<T>>  {
    private final MyArrayList<T> heap;

    // Default constructor
    public MyMinHeap(){ heap = new MyArrayList<>(); };
}
