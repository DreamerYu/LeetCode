class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int sum = nums[0];
        for(int i = 1; i < nums.length; i++){
            sum ^= nums[i];
        }
        return sum;
        
    }
}