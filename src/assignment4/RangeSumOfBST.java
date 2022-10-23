package assignment4;

public class RangeSumOfBST {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        return helper(root, low, high);
    }

    private int helper(TreeNode node, int low, int high){
        if(node == null){
            return 0;
        }

        if(node.val < low){
            return rangeSumBST(node.right, low, high);
        }else if(node.val > high){
            return rangeSumBST(node.left, low, high);
        }else{
            sum += node.val;
            rangeSumBST(node.left, low, high);
            rangeSumBST(node.right, low, high);
            return sum;
        }
    }
}
