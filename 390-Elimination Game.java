class Solution {
    public int lastRemaining(int n) {
        boolean left = true;
        int remain = n, head = 1, step = 1;
        
        while(remain > 1){
            if(left || remain % 2 == 1){
                head = head + step;
            }
            remain = remain / 2;
            step = step * 2;
            left = !left;
        }
        return head;
    }
}