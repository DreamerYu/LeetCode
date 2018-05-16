class Solution {
    public int jump(int[] nums) {
        int curmax = 0, nextmax = 0, step = 0, i = 0;
        if(nums == null || nums.length < 2) return 0;
        while(curmax - i + 1 > 0){
            step++;
            
            for(; i <= curmax; i++){
                nextmax = Math.max(nextmax, nums[i] + i);
                // if(nextmax >= nums.length - 1) return step;
            }
            curmax = nextmax;
            if(nextmax >= nums.length - 1) return step;
        }
        return 0;
    }
}
