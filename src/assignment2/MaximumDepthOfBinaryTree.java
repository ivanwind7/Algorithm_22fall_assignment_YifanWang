package assignment2;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return depth(root);
    }

    private int depth(TreeNode node){
        if(node == null){
            return 0;
        }
        return 1 + Math.max(depth(node.left), depth(node.right));
    }
}
