package assignment4;

import java.util.*;

public class BinarySearchTreeIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BinarySearchTreeIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAll(TreeNode node) {
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }
}
