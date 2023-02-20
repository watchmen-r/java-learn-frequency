package CodeCracking.chapter002;

import java.util.HashSet;

public class Q001 {
    class LinkedListNode {
        int data = 0;
        LinkedListNode next;
    }

    public void deleteDuplicateNode(LinkedListNode n) {
        HashSet<Integer> set = new HashSet<>();
        LinkedListNode previous = null;
        while(n != null) {
            if (set.contains(n.data)) {
                previous.next = n.next;
            } else {
                previous = n;
                set.add(n.data);
            }
            n = n.next;
        }
    }
}
