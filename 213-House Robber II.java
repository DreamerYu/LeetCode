class Solution {
    public int rob(int[] nums) {
        // if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }
    
    public int rob(int[] nums, int start, int end){
        int include = 0, exclude = 0;
        for(int j = start; j <= end; j++){
            int i = include, e= exclude;
            include  = e + nums[j];
            exclude = Math.max(i, e);
        }
        return Math.max(include, exclude);
    }
}