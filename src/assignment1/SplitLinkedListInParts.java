package assignment1;

public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode head, int k) {
        int length = 0;
        ListNode cur = head, nextCur = head;
        ListNode[] array = new ListNode[k];
        while(cur != null){
            length++;
            cur = cur.next;
        }
        cur = head;

        if(k >= length){
            int count = 0;
            while(true){
                if(cur == null){
                    break;
                }
                nextCur = cur.next;
                cur.next = null;
                array[count] = cur;
                cur = nextCur;
                count++;
            }
        }else{
            int count = 0, groupNum = 0;
            int groupPlus = length % k;
            if(groupPlus == 0){
                groupNum = length / k;
            }else{
                groupNum = length / k + 1;
            }
            for(int i = 0; i < groupPlus; i++){
                for(int j = 0; j < groupNum - 1; j++){
                    cur = cur.next;
                }
                nextCur = cur.next;
                cur.next = null;
                array[count] = head;
                head = nextCur;
                cur = nextCur;
                count++;
            }

            int remainNum = length - groupNum * groupPlus;
            groupNum = length / k;
            while(remainNum != 0){
                for(int j = 0; j < groupNum - 1; j++){
                    cur = cur.next;
                }
                nextCur = cur.next;
                cur.next = null;
                array[count] = head;
                head = nextCur;
                cur = nextCur;
                count++;
                remainNum = remainNum - groupNum;
            }
        }
        return array;
    }
}
