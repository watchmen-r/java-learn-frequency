import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BinaryTreeZigzag {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<List<Integer>>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<List<Integer>> answer = new ArrayList<>();
        int level = 0;

        while(!queue.isEmpty()) {  
            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for(int i = 0; i < n; i++) {

                if(level % 2 == 0) {
                    TreeNode node = queue.getLast();
                    queue.removeLast();
                    if(node.left != null) {
                        queue.addFirst(node.left);
                    }
                    if(node.right != null) {
                        queue.addFirst(node.right);
                    }
                    list.add(node.val);
                } else {
                    TreeNode node = queue.getFirst();
                    queue.removeFirst();
                    if(node.right != null) {
                        queue.addLast(node.right);
                    }
                    if(node.left != null) {
                        queue.addLast(node.left);
                    }
                    list.add(node.val);
                }

            }
            answer.add(list);
            level++;
        }
        return answer;
    }
}