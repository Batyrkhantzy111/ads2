import implementations.MyArrayList;
import implementations.MyLinkedList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MyArrayList<Integer> forcheck = new MyArrayList<>();

        forcheck.add(2);
        forcheck.add(6);
        forcheck.add(20);
        forcheck.add(1, 222);
        System.out.println(Arrays.toString(forcheck.toArray()));

        forcheck.set(2, 25);
        System.out.println(Arrays.toString(forcheck.toArray()));

        System.out.println("////////////////");
        System.out.println("now check linked list");
        System.out.println("/////////////");

        MyLinkedList<Integer> checkLinked = new MyLinkedList<>();
        checkLinked.add(30);
        checkLinked.add(32);
        checkLinked.add(33);
        checkLinked.add(31);
        checkLinked.add(321);
        System.out.println(Arrays.toString(checkLinked.toArray()));
        checkLinked.remove(2);
        System.out.println(Arrays.toString(checkLinked.toArray()));
        checkLinked.sort();
        System.out.println(Arrays.toString(checkLinked.toArray()));
    }
}
