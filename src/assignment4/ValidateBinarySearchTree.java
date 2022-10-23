package assignment4;

import java.util.*;

public class ValidateBinarySearchTree {
    public boolean isValidBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        for(int i = 0; i < list.size() - 1; i++){
            if(list.get(i) >= list.get(i + 1)){
                return false;
            }
        }
        return true;
    }

    private void helper(TreeNode node, List<Integer> list){
        if(node == null){
            return;
        }
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
    }
}
