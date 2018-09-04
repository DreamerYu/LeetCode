class Solution {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int re1 = 0, re2 = 0;
        for(int i : prices){
            re2 = Math.max(re2, hold2 + i);
            hold2 = Math.max(hold2, re1 - i);
            re1 = Math.max(re1, hold1 + i);
            hold1 = Math.max(hold1, -i);
        }
        return re2;
    }
}