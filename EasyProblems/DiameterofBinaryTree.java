public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    int ans;
    int dfs(TreeNode currentNode) {
        if(currentNode == null) return 0;

        int left = dfs(currentNode.left);
        int right = dfs(currentNode.right);

        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
}