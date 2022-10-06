package assignment2;

import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }

        ArrayList array = new ArrayList();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<TreeNode> tempQ = new LinkedList<TreeNode>();
        Stack<TreeNode> s = new Stack<TreeNode>();
        boolean flag = true;
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node != null){
                if(node.left != null){
                    q.add(node.left);
                    if(flag){
                        s.add(node.left);
                    }
                }
                if(node.right != null){
                    q.add(node.right);
                    if(flag){
                        s.add(node.right);
                    }
                }
                if(flag){
                    tempQ.add(node);
                }
            }else{
                if(!flag && !s.empty()){
                    ArrayList<Integer> tempArray = new ArrayList<Integer>();
                    while(!s.empty()){
                        Integer i = new Integer(s.pop().val);
                        tempArray.add(i);
                    }
                    array.add(tempArray);
                }
                if(flag && !tempQ.isEmpty()){
                    ArrayList<Integer> tempArray = new ArrayList<Integer>();
                    while(!tempQ.isEmpty()){
                        Integer i = new Integer(tempQ.remove().val);
                        tempArray.add(i);
                    }
                    array.add(tempArray);
                }
                if(q.size() == 0){
                    break;
                }
                q.add(null);
                flag = !flag;
            }
        }

        return array;
    }
}
