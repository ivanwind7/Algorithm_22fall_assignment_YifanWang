package assignment1;

public class InsertIntoASortedCircularLinkedList {
    public ListNode insert(ListNode head, int insertVal) {
        if(head == null){
            ListNode newNode = new ListNode(insertVal);
            head = newNode;
            newNode.next = head;
            return head;
        }

        ListNode start = head;
        ListNode cur = head.next;
        ListNode min = head;
        while(cur != start){
            if(cur.val < min.val){
                min = cur;
            }
            cur = cur.next;
        }

        cur = min;
        boolean flag = true;
        ListNode max = null;
        do{
            if(cur.next == min){
                max = cur;
            }
            if(cur.val <= insertVal && insertVal <= cur.next.val){
                ListNode newNode = new ListNode(insertVal, cur.next);
                cur.next = newNode;
                flag = false;
                break;
            }else{
                cur = cur.next;
            }
        }while(cur != min);

        if(flag){
            ListNode newNode = new ListNode(insertVal, min);
            max.next = newNode;
        }

        return head;
    }
}
