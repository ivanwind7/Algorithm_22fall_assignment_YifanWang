package assignment2;

import java.util.*;

public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }

        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        q.add(null);
        TreeNode preNode = null;
        ArrayList array = new ArrayList();

        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node != null){
                preNode = node;
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }
            }else{
                array.add(preNode.val);
                if(q.size() == 0){
                    break;
                }
                q.add(null);
            }
        }
        return array;
    }
}
