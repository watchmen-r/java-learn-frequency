package CodeCracking.chapter002;

public class Q003 {
    class Node {
        int data = 0;
        Node next;
    }

    public boolean deleteNode(Node n) {
        if (n == null || n.next == null) {
            return false;
        }
        Node nextNode = n.next;
        n.data = nextNode.data;
        n.next = nextNode.next;
        return true;
    }
}
