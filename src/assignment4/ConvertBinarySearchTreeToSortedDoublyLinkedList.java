package assignment4;

import java.util.*;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {
    public Node treeToDoublyList(Node root) {
        if(root == null){
            return null;
        }

        Queue<Node> q = new LinkedList<>();
        helper(root, q);
        Node head = q.remove();
        Node pre = head;
        Node nodeNow = head;
        while(!q.isEmpty()){
            nodeNow = q.remove();
            pre.right = nodeNow;
            nodeNow.left = pre;
            pre = nodeNow;
        }
        head.left = nodeNow;
        nodeNow.right = head;
        return head;
    }

    private void helper(Node node, Queue<Node> q){
        if(node == null){
            return;
        }
        helper(node.left, q);
        q.add(node);
        helper(node.right, q);
    }
}
