class Solution {
    public int findNumberOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] len = new int[nums.length];
        int[] count = new int[nums.length];
        Arrays.fill(count, 1);
        
        for(int i = 0; i < nums.length; i++){
            int index = 0;
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(len[j] >= len[i]){
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }else if(len[i] == len[j] + 1){
                        count[i] += count[j];
                    }
                }
            }
        }
        
        int longest = 0;
        for(int i = 0; i < nums.length; i++){
            longest = Math.max(longest, len[i]);
        }
        
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            if(longest == len[i]) ans += count[i];
        }
        return ans;
    }
}