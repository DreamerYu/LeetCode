class Solution {
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0) return 0;
        int sum = 0, max = 0;
        for(int i = 0; i < nums.length; i++){
            max = Math.max(max, nums[i]);
            sum += nums[i];
        }
        int start = max, end = sum;
        if(m == 1) return sum;
        
        while(start < end){
            int mid = start + (end - start) / 2;
            if(valid(mid, nums, m)){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start;
    }
    
    public boolean valid(int target, int[] nums, int m){
        int total = 0, count = 0;
        for(int i = 0; i < nums.length; i++){
            total += nums[i];
            if(total > target){
                total = nums[i];
                count++;
                if(count >= m) return true;
            }
        }
        return false;
    }
}