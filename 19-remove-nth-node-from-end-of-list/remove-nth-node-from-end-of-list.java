/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;
        ListNode right = head;

        while(n > 0){
            right = right.next;
            n--;
        }

        while(right != null){
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return dummy.next;

    }
}
/*
Step 1: Determine by counting down n until 0 
Step 2: Identify the previous node of the deleted node we want to skip
    + Skip the deleted node by using .next
Step 3: return the linkedlist without that deleted node


Dry run example
[1,2,3,4,5] n = 2 

Step 1
dummy/left: 0->1->2->3->4->5->null
right: 1->2->3->4->5->null
        
right = 1
2>0
=> right = 2 : n = 1
1 > 0 
=> right = 3 : n = 0

Step 2:
left --   right
0 = 1     3 =  4
1 = 2     4 = 5



*/