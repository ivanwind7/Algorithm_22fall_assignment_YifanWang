package assignment2;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }

        return isSym(root.left, root.right);
    }

    private boolean isSym(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }
        if(left.val != right.val){
            return false;
        }
        return isSym(left.left, right.right) && isSym(left.right, right.left);
    }
}
