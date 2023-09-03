package CodeCracking.chapter004;

public class Q002 {
    class Graph {
        public Node[] nodes;
    }

    class Node {
        public String name;
        public Node nodeLeft;
        public Node nodeRight;
    }

    public Node createBst(int[] array) {
        return generateBst(array, 0, array.length - 1);
    }

    private Node generateBst(int[] array, int left, int right) {
        if (left > right) {
            return null;
        }

        int half = (left + right) / 2;
        Node node = new Node();

        node.nodeLeft = generateBst(array, left, half - 1);
        node.nodeRight = generateBst(array, half + 1, right);
        return node;
    }
}
