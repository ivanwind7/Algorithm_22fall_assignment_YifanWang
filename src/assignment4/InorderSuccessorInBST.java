package assignment4;

import java.util.*;

public class InorderSuccessorInBST {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        List<TreeNode> list = new ArrayList();
        inorder(root, list);
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) == p){
                return list.get(i + 1);
            }
        }
        return null;
    }

    private void inorder(TreeNode node, List<TreeNode> list){
        if(node != null){
            inorder(node.left, list);
            list.add(node);
            inorder(node.right, list);
        }
    }
}
