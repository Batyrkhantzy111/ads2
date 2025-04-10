package implementations;

import interfaces.MyList;
import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
    private Object[] elements;   // array to store the elements
    private int size;            // current number of elements in the list
    private static final int DEFAULT_CAPACITY = 10; // default initial capacity

    // Default constructor with default capacity
    public MyArrayList() {elements = new Object[DEFAULT_CAPACITY];}

    // Constructor with specified initial capacity
    public MyArrayList(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("Initial capacity must be greater than 0");
        }
        elements = new Object[initialCapacity];
        size = 0;
    }

    private void ensureCapacity()
    {
        if (size == elements.length)
        {
            Object[] newElements = new Object[elements.length*2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }

    }

    //Checks if the provided index is within bounds for get, set, remove func
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
    }

    //Checks if the provided index is within bounds for add operation
    private void checkIndexForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for add");
        }
    }

    @Override
    public void add(T item) {
        ensureCapacity();
        elements[size++] = item;
    }

    @Override
    public void set(int index, T item) {
        checkIndex(index);
        elements[index] = item;
    }

    @Override
    public void add(int index, T item) {
        checkIndexForAdd(index);
        ensureCapacity();
        // Shift elements to the right manually
        for (int i = size - 1; i >= index; i--) {
            elements[i + 1] = elements[i];
        }
        elements[index] = item;
        size++;
    }

    @Override
    public void addFirst(T item) {
        add(0, item);
    }

    @Override
    public void addLast(T item) {
        add(item);
    }

    @Override
    public T get(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty!!!");
        }
        return (T) elements[0];
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty!!");
        }
        return (T) elements[size - 1];
    }

    @Override
    public T remove(int index) {
        checkIndex(index);
        T removedElem = (T) elements[index];
        // Shift elements to the left
        for (int i = index; i < size - 1; i++)
        {
            elements[i] = elements[i+1];
        }
        size--;
        return removedElem;
    }

    @Override
    public T removeFirst() {
        return remove(0);
    }

    @Override
    public T removeLast() {
        return remove(size - 1);
    }

    @Override
    public void sort() {
        sort((a, b) -> ((Comparable <T>) a).compareTo(b));
    }

    @Override
    public void sort(java.util.Comparator<T> cmp) {
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                T a = (T) elements[j];
                T b = (T) elements[j + 1];
                if (cmp.compare(a, b) > 0) {
                    T temp = a;
                    elements[j] = b;
                    elements[j+1] = temp;
                }
            }
        }
    }

    @Override
    public int indexOf(Object object)
    {
        if (object == null)
        {
            for (int i = 0; i < size; i++)
            {
                if (elements[i] == null)
                {
                    return i;
                }
            }
        }
        else
        {
            for (int i = 0; i < size; i++) {
                if (object.equals(elements[i]))
                {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object)
    {
        if (object == null)
        {
            for (int i = size - 1; i >= 0; i--)
            {
                if (elements[i] == null)
                {
                    return i;
                }
            }
        }
        else
        {
            for (int i = size - 1; i >= 0; i--)
            {
                if (object.equals(elements[i]))
                {
                    return i;
                }
            }
        }
        return -1;
    }


    @Override
    public boolean exists(Object object) {
        int index = indexOf(object);
        return index != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        System.arraycopy(elements, 0, result, 0, size);
        return result;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int cursor = 0; // Current index

            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public T next() {
                return (T) elements[cursor++];
            }
        };
    }
}