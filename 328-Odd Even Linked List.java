/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        int num = 1;
        ListNode cur = head, next = head.next, h2 = head.next, pre = head;
        while(next != null){
            num++;
            head.next = head.next.next;
            pre = head;
            head = next;
            next = next.next;
        }
        if(num % 2 == 0){
            pre.next = h2;
        }else{
            head.next = h2;
        }
        return cur;
    }
}