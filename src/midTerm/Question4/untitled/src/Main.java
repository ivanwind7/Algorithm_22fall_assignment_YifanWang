public class Main {
    public static void main(String[] args) {
        // O(n)
        LinkList list = new LinkList();
        list.head = new Node(0);
        list.head.next = new Node(2);
        list.head.next.next = new Node(5);
        list.head.next.next.next = new Node(6);
        list.insert(1);
        list.insert(7);
        display(list.head);
    }

    private static void display(Node node){
        Node cur = node;
        while(cur!=null){
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}