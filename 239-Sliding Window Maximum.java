class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return new int[k];
        
        int[] n = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int inx = 0;
        int[] a = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            while(!deque.isEmpty() && deque.peek() < i - k + 1){
                deque.poll();
            }
            
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if(i >= k - 1){
                n[inx++] = nums[deque.peek()];
            }
        }
        return n;
    }
}