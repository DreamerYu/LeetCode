class Solution {
    public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
        PriorityQueue<int[]> pqcap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        PriorityQueue<int[]> pqpro = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for(int i = 0; i < Profits.length; i++){
            pqcap.add(new int[]{Capital[i], Profits[i]});
        }
        
        for(int i = 0; i < k; i++){
            while(!pqcap.isEmpty() && pqcap.peek()[0] <= W){
                pqpro.add(pqcap.poll());
            }
            if(pqpro.isEmpty()) break;
            W += pqpro.poll()[1];
        }
        return W;
        
    }
}