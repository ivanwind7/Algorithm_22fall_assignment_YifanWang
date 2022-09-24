package assignment1;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null){
            if(cur.val == val){
                if(pre == null){
                    head = head.next;
                    cur = head;
                }else{
                    cur = cur.next;
                    pre.next = cur;
                }
            }else{
                pre = cur;
                cur = cur.next;
            }
        }
        return head;
    }
}
