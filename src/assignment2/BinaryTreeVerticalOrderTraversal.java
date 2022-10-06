package assignment2;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    public static int positionMin = 0, positionMax = 0;
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if(root == null){
            return new ArrayList();
        }

        List<List<Integer>> array = new ArrayList<>();
        int positionNow = 0;
        helper(root, array, positionNow);

        return array;
    }

    private void helper(TreeNode node, List<List<Integer>> array, int positionNow){
        if(node == null){
            return;
        }

        Integer i = node.val;
        if(positionNow < positionMin){
            positionMin--;
            List<Integer> tempArray = new ArrayList<>();
            tempArray.add(i);
            array.add(0, tempArray);
        }else if(positionNow > positionMax){
            positionMax++;
            List<Integer> tempArray = new ArrayList<>();
            tempArray.add(i);
            array.add(tempArray);
        }else{
            if(array.isEmpty()){
                ArrayList<Integer> tempArray = new ArrayList<>();
                tempArray.add(i);
                array.add(tempArray);
            }else{
                array.get(positionNow - positionMin).add(i);
            }
        }

        helper(node.left, array, positionNow - 1);
        helper(node.right, array, positionNow + 1);
    }
}
