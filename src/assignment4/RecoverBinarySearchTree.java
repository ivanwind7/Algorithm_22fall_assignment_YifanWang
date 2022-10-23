package assignment4;

public class RecoverBinarySearchTree {
    TreeNode firstElement = null;
    TreeNode secondElement = null;
    TreeNode prevElement = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        helper(root);
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;
    }

    private void helper(TreeNode node){
        if(node == null){
            return;
        }

        helper(node.left);

        if(firstElement == null && prevElement.val > node.val){
            firstElement = prevElement;
        }
        if(firstElement != null && prevElement.val > node.val){
            secondElement = node;
        }

        prevElement = node;
        helper(node.right);
    }
}
