package CodeCracking.chapter004;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Q001 {
    class Graph {
        public Node[] nodes;
    }

    class Node {
        public String name;
        public Node[] children;
    }

    public boolean checkRoute(Graph g, Node node1, Node node2) {
        Queue<Node> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        queue.add(node1);
        set.add(node1.name);
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            if (currentNode == node2) {
                return true;
            }

            if (currentNode.children == null || currentNode.children.length == 0) {
                continue;
            }

            for (Node child: node1.children) {
                if (!set.contains(child.name)) {
                    queue.add(child);
                    set.add(child.name);
                }
                
            }
        }
        return false;
    }
}
