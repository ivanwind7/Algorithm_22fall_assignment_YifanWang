package assignment1;

public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        int val1 = 0, length = 0;
        ListNode cur = head;
        ListNode node1 = null;
        while(cur != null){
            length++;
            if(length == k){
                val1 = cur.val;
                node1 = cur;
            }
            cur = cur.next;
        }
        cur = head;
        for(int i = 0; i < length - k; i++){
            cur = cur.next;
        }
        node1.val = cur.val;
        cur.val = val1;
        return head;
    }
}
