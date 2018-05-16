class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if(nums == null || nums.length < 2) return false;
        for(int i = 0; i < nums.length - 1; i++){
            int sum = 0;
            for(int j = i; j < nums.length; j++){
                sum += nums[j];
                if(k != 0){
                    if(sum % k == 0 && j >= i + 1) return true;
                }else{
                    if(sum == 0 && j >= i + 1) return true;
                }
            }
        }
        return false;
        
    }
}