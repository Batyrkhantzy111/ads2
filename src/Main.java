import implementations.MyArrayList;
import implementations.MyLinkedList;
import data_structures.MyMinHeap;
import data_structures.Queue;
import data_structures.Stack;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        testMyArrayListAndMyLinkedList();
        testMyMinHeap();
        testQueue();
        testStack();
    }

    // Testing MyArrayList and MyLinkedList
    private static void testMyArrayListAndMyLinkedList() {
        System.out.println("=== Testing MyArrayList ===");
        MyArrayList<Integer> integers = new MyArrayList<>();

        // Test MyArrayList: add and set methods
        integers.add(2);
        integers.add(6);
        integers.add(20);
        integers.add(1, 222);
        System.out.println("MyArrayList after additions: " + Arrays.toString(integers.toArray()));

        integers.set(2, 25);
        System.out.println("MyArrayList after setting index 2 to 25: " + Arrays.toString(integers.toArray()));

        System.out.println("////////////////");
        System.out.println("\n");
        System.out.println("=== Testing MyLinkedList ===");

        // Test MyLinkedList: add and remove methods
        MyLinkedList<Integer> checkLinked = new MyLinkedList<>();
        checkLinked.add(30);
        checkLinked.add(32);
        checkLinked.add(33);
        checkLinked.add(31);
        checkLinked.add(321);
        System.out.println("MyLinkedList after additions: " + Arrays.toString(checkLinked.toArray()));

        checkLinked.remove(2);
        System.out.println("MyLinkedList after removing element at index 2: " + Arrays.toString(checkLinked.toArray()));
        System.out.println(Arrays.toString(checkLinked.toArray()));
        System.out.println("\n");
        System.out.println("/////////////////////////////////////////");
    }

    // Testing MyMinHeap methods
    private static void testMyMinHeap() {
        System.out.println("=== Testing MyMinHeap ===");
        MyMinHeap<Integer> heap = new MyMinHeap<>();

        // Insert elements into the heap
        heap.insert(10);
        heap.insert(5);
        heap.insert(20);
        heap.insert(3);
        heap.insert(17);

        System.out.println("Heap minimum after inserts: " + heap.getMin());
        System.out.println("Extract min (should be 3): " + heap.extractMin());
        System.out.println("New heap minimum (should be 5): " + heap.getMin());

        System.out.println("Extracting remaining elements from the heap:");
        while (!heap.empty()) {
            System.out.print(heap.extractMin() + " ");
        }
        System.out.println("\n");
        System.out.println("/////////////////////////////////////////");
    }

    // Testing Queue methods
    private static void testQueue() {
        System.out.println("=== Testing Queue ===");
        Queue<Integer> queue = new Queue<>();

        // Enqueue elements
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        System.out.println("Queue peek (first element): " + queue.peek());
        System.out.println("Queue size: " + queue.size());

        System.out.println("Dequeue all elements:");
        while (!queue.empty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println("\n");
        System.out.println("/////////////////////////////////////////");
    }

    // Testing Stack methods
    private static void testStack() {
        System.out.println("=== Testing Stack ===");
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(100);
        stack.push(200);
        stack.push(300);
        stack.push(400);
        System.out.println("Stack peek (top element): " + stack.peek());
        System.out.println("Stack size: " + stack.size());

        System.out.println("Popping all elements from the stack:");
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
