class Solution {
    // Integer.MAX_VALUE为 2的31次方减一 2 147 483 647 ，Integer.MIN_VALUE为 负2的31次方为 2 147 483 648Integer.max_value = 01111111 111111111111111111111111+1 = 10000000 00000000 00000000 00000000最高位是符号位为1，这个数是负数，负数的源码是补码取反+1，刚好等于Integer.min_value,即为10000000000000000000000000000000
    PriorityQueue<Integer> min = new PriorityQueue<>();    
    PriorityQueue<Integer> max = new PriorityQueue<Integer>(
        new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        });//!!!!!!!!!!!!!!!!!!!
    public double[] medianSlidingWindow(int[] nums, int k) {
        double[] res = new double[nums.length - k + 1];
        if(nums == null || nums.length == 0) return res;
        
        for(int i = 0; i <= nums.length; i++){
            if(i >= k){
        	    res[i - k] = getMedian();
                remove(nums[i - k]);
            }
            if (i < nums.length) {
        	    add(nums[i]);
            }
        }
        // res[nums.length - k] = getMedian();
        return res;
    }
    
    public void add(int n){
        if(n < getMedian()){
            max.offer(n);
        }else{
            min.offer(n);
        }
        
        if(max.size() > min.size()){
            min.offer(max.poll());
        }
        
        if (min.size() - max.size() > 1) {
            max.add(min.poll());
        }
    }
    
    public void remove(int n){
        if (n < getMedian()) {
            max.remove(n);
        }
        else {
            min.remove(n);
        }
        if (max.size() > min.size()) {
            min.add(max.poll());
        }
        if (min.size() - max.size() > 1) {
            max.add(min.poll());
        }
    }
    
    private double getMedian() {
        if (max.isEmpty() && min.isEmpty()) return 0;

        if (max.size() == min.size()) {
            return ((double)max.peek() + (double)min.peek()) / 2.0;
        }else {
            return (double)min.peek();
        }
    }
}