package assignment2;

import java.util.*;

public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        HashSet<TreeNode> set = new HashSet<>();
        List<List<Integer>> list = new ArrayList<>();
        while(true){
            List<Integer> tempList = new ArrayList<>();
            helper(list, set, tempList, root);
            list.add(tempList);
            if(tempList.size() == 1 && tempList.get(0) == root.val){
                break;
            }
        }
        return list;
    }

    private void helper(List<List<Integer>> list, HashSet<TreeNode> set, List<Integer> tempList, TreeNode node){
        if((node.left == null && node.right == null) ||
                (set.contains(node.left) && set.contains(node.right)) ||
                (set.contains(node.left) && node.right == null) ||
                (set.contains(node.right) && node.left == null)){
            tempList.add(node.val);
            set.add(node);
            return;
        }
        if(node.left != null && !set.contains(node.left)){
            helper(list, set, tempList, node.left);
        }
        if(node.right != null && !set.contains(node.right)){
            helper(list, set, tempList, node.right);
        }
    }
}
