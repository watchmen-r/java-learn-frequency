package CodeCracking.chapter002;

public class Q002 {
    class Node {
        int data = 0;
        Node next;
    }

    public int searchK(Node n) {
        int k = 5;
        Node firstPointer = n;
        Node secondPointer = n;

        int count = 0;
        while(firstPointer != null) {
            count++;
            firstPointer = firstPointer.next;
        }

        for (int i = 0; i < count - k; i++) {
            secondPointer = secondPointer.next;
        }
        return secondPointer.data;
    }
}
