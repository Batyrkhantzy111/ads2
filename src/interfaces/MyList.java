package interfaces;

public interface MyList<T> extends Iterable<T> {
    // Adds an element to the end
    void add(T item);

    // Replaces the element at the index with the given element
    void set(int index, T item);

    // Inserts the given element at the index
    void add(int index, T item);

    // Adds an element to the beginning of the list
    void addFirst(T item);

    // Adds an element to the end of the list
    void addLast(T item);

    // Returns the element at the index
    T get(int index);

    // Returns the first element of the list
    T getFirst();

    // Returns the last element of the list
    T getLast();

    // Removes and returns the element at the index
    T remove(int index);

    // Removes and returns the first element of the list
    T removeFirst();

    // Removes and returns the last element of the list
    T removeLast();

    // Sorts the list
    void sort();
    void sort(java.util.Comparator<T> cmp);

    // Returns the index of the first occurrence of the object, or -1 if not found
    int indexOf(Object object);

    // Returns the index of the last occurrence of the object, or -1 if not found
    int lastIndexOf(Object object);

    // Checks if the object exists in the list
    boolean exists(Object object);

    // Returns an array containing all elements in the list
    Object[] toArray();

    // Clears the list
    void clear();

    // Returns the number of elements in the list
    int size();

}
