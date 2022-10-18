package assignment2;

public class LowestCommonAncestorOfABinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode[] res = new TreeNode[1];
        helper(root, res, p, q);
        return res[0];
    }

    private boolean helper(TreeNode node, TreeNode[] res, TreeNode p, TreeNode q){
        if(node == null){
            return false;
        }
        boolean b1 = helper(node.left, res, p, q);
        boolean b2 = helper(node.right, res, p, q);
        if((b1 && b2) || ((b1 || b2) && (node == p || node == q))){
            res[0] = node;
            return true;
        }else if(node == p || node == q || b1 || b2){
            return true;
        }else{
            return false;
        }
    }
}
