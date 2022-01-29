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

class BinaryTreeMaximumPathSum {
    int maxSum = Integer.MIN_VALUE;

    public int maxGain(TreeNode node) {
        if(node == null) {
            return 0;
        }

        // max sum on the left and right sub-trees of node
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int priceNewPath = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, priceNewPath);

        return node.val + Math.max(leftGain, rightGain);
        
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }
}
