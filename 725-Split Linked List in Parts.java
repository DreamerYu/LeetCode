/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        int n = 0;
        ListNode cur = root;
        while(cur != null){
            n++;
            cur = cur.next;
        }
        ListNode[] res = new ListNode[k];
        int remainder = n % k, quotient = n / k;
        
        for(int i = 0; i < k; i++){
            cur = root;
            if(remainder == 0){
                for(int j = 0; j < quotient - 1; j++){
                    cur = cur.next;
                }
            }else{
                for(int j = 0; j < quotient; j++){
                    cur = cur.next;
                }
                remainder--;
            }
            res[i] = root;
            
            if(cur != null){
                root = cur.next;
                cur.next = null;
            }else root = null;
        }
        return res;
    }
}