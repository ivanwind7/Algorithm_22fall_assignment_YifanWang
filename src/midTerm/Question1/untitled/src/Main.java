package midTerm.Question1.untitled.src;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        // O(n)
        BinTree<Integer> tree = getTree();
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(tree.root);
        queue.add(null);
        Stack<Node<Integer>> stack = new Stack<>();
        stack.push(null);
        while(true){
            Node<Integer> tempNode = queue.remove();
            if(tempNode == null){
                while(stack.peek() != null){
                    Node<Integer> node = stack.pop();
                    node.nextLeft = stack.peek();
                }
                if(queue.isEmpty()) break;
                queue.add(null);
            }else{
                stack.push(tempNode);
                if(tempNode.left != null) queue.add(tempNode.left);
                if(tempNode.right != null) queue.add(tempNode.right);
            }
        }
        traverse(tree.root);
    }

    private static void traverse(Node<Integer> node){
        if(node == null) return;
        traverse(node.left);
        if(node.nextLeft == null) System.out.println("Node: " + node.data + ", next left: null");
        else System.out.println("Node: " + node.data + ", next left: " + node.nextLeft.data);
        traverse(node.right);
    }

    private static BinTree<Integer> getTree(){
        BinTree<Integer> tree = new BinTree<>();

        tree.root = new Node<>(1);

        tree.root.left = new Node<>(2);
        tree.root.right = new Node<>(3);

        tree.root.left.left = new Node<>(4);
        tree.root.left.right = new Node<>(5);
        tree.root.right.left = new Node<>(6);
        tree.root.right.right = new Node<>(7);


        tree.root.left.left.left = new Node<>(8);
        tree.root.left.right.left = new Node<>(9);
        tree.root.right.left.right = new Node<>(10);
        tree.root.right.right.right = new Node<>(11);


        return tree;
    }
}