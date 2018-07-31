class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int len = 1, m = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i - 1]){
                len++;
                m = Math.max(m, len);
            }else{
                len = 1;
            }
        }
        return m;
        
    }
}