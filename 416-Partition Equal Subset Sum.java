class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }
        if(sum % 2 == 1) return false;
        sum = sum / 2;
        Arrays.sort(nums);
        return backtracking(sum, nums.length - 1, nums);
    }
    
    public boolean backtracking(int sum, int index, int[] nums){
        if(index < 0) return false;
        if(sum == nums[index]) return true;
        if(sum < nums[index]) return false;
        return backtracking(sum - nums[index], index - 1, nums) || backtracking(sum, index - 1, nums);
    }
}