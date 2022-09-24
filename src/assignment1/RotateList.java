package assignment1;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null){
            return null;
        }
        if(k == 0 || head.next == null){
            return head;
        }

        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }

        int count = length - (k % length);
        if(count == 0 || count == length){
            return head;
        }
        cur = head;
        for(int i = 0; i < count - 1; i++){
            cur = cur.next;
        }
        ListNode firstTail = cur;
        cur = cur.next;
        firstTail.next = null;

        ListNode secondTail = cur;
        while(secondTail.next != null){
            secondTail = secondTail.next;
        }

        secondTail.next = head;
        head = cur;
        return head;
    }
}
