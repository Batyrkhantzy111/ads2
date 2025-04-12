package implementations;

import interfaces.MyList;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {

        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {this.data = data;}
    }

    private MyNode head;  // Reference to the first node
    private MyNode tail;  // Reference to the last node
    private int size;     // Number of elements in the list

    // Default constructor
    public MyLinkedList() {
    }

    // Get the node at index
    private MyNode getNode(int index)
    {
        if (index < 0 || index >= size)
        {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds");
        }
        MyNode current;
        if (index < size / 2)
        {
            current = head;
            for (int i = 0; i < index; i++)
            {
                current = current.next;
            }
        } else
        {
            current = tail;
            for (int i = size - 1; i > index; i--)
            {
                current = current.prev;
            }
        }
        return current;
    }

    @Override
    public void add(T item) {
        addLast(item);
    }

    @Override
    public void set(int index, T item) {
        MyNode node = getNode(index);
        node.data = item;
    }

    @Override
    public void add(int index, T item)
    {
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for add");
        }
        if (index == 0) {
            addFirst(item);
        } else if (index == size)
        {
            addLast(item);
            // 2,  3   ,4,5,6
        } else
        {
            MyNode current = getNode(index);
            MyNode newNode = new MyNode(item);
            MyNode prevNode = current.prev;
            newNode.next = current;
            newNode.prev = prevNode;
            prevNode.next = newNode;
            current.prev = newNode;
            size++;
        }
    }

    @Override
    public void addFirst(T item) {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else
        {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    @Override
    public void addLast(T item)
    {
        MyNode newNode = new MyNode(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else
        {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }


    @Override
    public T get(int index) {
        return getNode(index).data;
    }

    @Override
    public T getFirst() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty!");
        }
        return head.data;
    }

    @Override
    public T getLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("List is empty!!");
        }
        return tail.data;
    }

    @Override
    public T remove(int index) {
        MyNode node = getNode(index);
        T removedData = node.data;
        MyNode prevNode = node.prev;
        MyNode nextNode = node.next;

        if (prevNode != null) {
            prevNode.next = nextNode;
        }
        else
        {
            head = nextNode;
        }
        if (nextNode != null) {
            nextNode.prev = prevNode;
        }
        else
        {
            tail = prevNode;
        }
        size--;
        return removedData;
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
    public void sort(java.util.Comparator<T> cmp) {
        if (size < 2) return;

        for (int i = 0; i < size - 1; i++) {
            MyNode current = head;
            for (int j = 0; j < size - i - 1; j++) {
                if (cmp.compare(current.data, current.next.data) > 0) {
                    // Swap values
                    T temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                }
                current = current.next;
            }
        }
    }

    @Override
    public int indexOf(Object object) {
        int index = 0;
        for (T data : this) {
            if ((object == null && data == null) || (object != null && object.equals(data))) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object object) {
        int index = size - 1;
        MyNode current = tail;
        while (current != null) {
            if ((object == null && current.data == null) || (object != null && object.equals(current.data))) {
                return index;
            }
            current = current.prev;
            index--;
        }
        return -1;
    }


    @Override
    public boolean exists(Object object) {
        return indexOf(object) != -1;
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[size];
        int i = 0;
        for (T data : this) {
            arr[i++] = data;
        }
        return arr;
    }

    @Override
    public void clear() {
        MyNode current = head;
        while (current != null) {
            MyNode next = current.next;
            current.data = null;
            current.next = null;
            current.prev = null;
            current = next;
        }
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private MyNode current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }
}
