import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

class CopyListRandomPoiter {
    Map<Node, Node> visitedMap = new HashMap<Node, Node>();
    public Node copyRandomList(Node head) {
        
        if(head == null) {
            return null;
        }

        if(visitedMap.containsKey(head)) {
            return visitedMap.get(head);
        }

        Node node = new Node(head.val, null, null);

        visitedMap.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }
}