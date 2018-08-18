/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val,Node _next) {
        val = _val;
        next = _next;
    }
};
*/
class Solution {
    public Node insert(Node head, int insertVal) {
        
        if(head == null){
            Node node = new Node(insertVal);
            node.next = node;
            return node;
        }
        Node first = head, sec = head.next;
        int time = 0;
        while(true){
            if(first.val < first.next.val){
                if(first.val <= insertVal && insertVal <= first.next.val){
                    first.next = new Node(insertVal, first.next);
                    break;
                }
            }else if (first.val > first.next.val) { 
                if (first.val <= insertVal || insertVal <= first.next.val) {
                    first.next = new Node(insertVal, first.next);
                    break;
                }
            // case 2: NO tipping point, all flat
            } else {
                if (first.next == head) {
                    first.next = new Node(insertVal, first.next);
                    break;
                }
            }
            // None of the above three cases met, go to next node
            first = first.next;
        }
        return head;
    }
}