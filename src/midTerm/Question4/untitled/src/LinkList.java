package midTerm.Question4.untitled.src;

public class LinkList  {

    public Node head;

    public int length = 0;

    public LinkList() {
        head = null;
    }

    public void insert(Integer data){
        Node cur = head;
        boolean inserted = false;
        while(cur.next != null){
            if(cur.data <= data && data < cur.next.data){
                Node node = new Node(data);
                node.next = cur.next;
                cur.next = node;
                inserted = true;
                break;
            }
            cur = cur.next;
        }
        if(!inserted){
            Node node = new Node(data);
            cur.next = node;
        }
    }
}
