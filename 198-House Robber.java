class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            dp[i] = i > 1 ? Math.max(dp[i - 1], dp[i - 2] + nums[i]) : Math.max(dp[0], nums[1]);
        }
        return dp[nums.length - 1];
    }
}