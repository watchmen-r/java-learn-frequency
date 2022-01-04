
class TreeNode {
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


class DiameterBinaryTree {
    int diameter;
    int dfs(TreeNode node) {
        if(node == null) return 0;

        int leftPath = dfs(node.left);
        int rightPath = dfs(node.right);

        // ここの発想が難しい、、
        diameter = Math.max(diameter, leftPath + rightPath);

        return Math.max(leftPath, rightPath) + 1;
    }
    int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);
        return diameter;
    }
}