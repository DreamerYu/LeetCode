class Solution {
    private int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, S);
        return res;
    }
    
    public void dfs(int[] nums, int index, int sum){
        if(index == nums.length && sum == 0){
            res++;
            return;
        }else if(index < nums.length){
            dfs(nums, index + 1, sum - nums[index]);
            dfs(nums, index + 1, sum + nums[index]);
        }
        
        
        
    }
}