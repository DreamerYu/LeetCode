class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int start = matrix[0][0], end = matrix[matrix.length - 1][matrix.length - 1];
        
        while(start < end){
            int mid = (start + end) / 2;
            int count = 0;
            for(int i = 0; i < matrix.length; i++){
                int j = 0;
                while(j < matrix.length && matrix[i][j] <= mid) j++;
                count += j;
            }
            
            if(count >= k){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
    
    
    //priorityqueue
    public int kthSmallest2(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Turple> queue = new PriorityQueue<>();
        for(int i = 0; i < n; i++) queue.offer(new Turple(0, i, matrix[0][i]));
        for(int i = 0; i < k - 1; i++){
            Turple temp = queue.poll();
            if(temp.x == n - 1) continue;
            queue.offer(new Turple(temp.x + 1, temp.y, matrix[temp.x + 1][temp.y]));
        }
        return queue.poll().val;
    }
    
    class Turple implements Comparable<Turple>{
        int x, y, val;
        public Turple(int x, int y, int val){
            this.x = x;
            this.y = y;
            this.val = val;
        }
        
        @Override
        public int compareTo(Turple that){
            return this.val - that.val;
        }
        
    }
}