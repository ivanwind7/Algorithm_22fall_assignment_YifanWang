package midTerm.Question2.Question2.src;

public class Main {
    public static void main(String[] args) {
        // O(n)
        BinTree<Integer> tree = getTree();
        tree.root.parent = tree.root;
        helper(tree.root);
        traverse(tree.root);
    }

    private static void helper(Node<Integer> node){
        if(node == null) return;
        helper(node.left);
        if(node.left != null) node.left.parent = node;
        if(node.right != null) node.right.parent = node;
        helper(node.right);
    }

    private static void traverse(Node<Integer> node){
        if(node == null) return;
        traverse(node.left);
        System.out.println("Node: " + node.data + ", next left: " + node.parent.data);
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

        return tree;
    }
}