class Solution {
    
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int start = 0, end = nums[nums.length - 1] - nums[0];
        while(start < end){
            int mid = (start + end) / 2;
            int left = 0, count = 0;
            for(int right = 0; right < nums.length; right++){
                while(nums[right] - nums[left] > mid) left++;
                count += right - left;
            }
            if(count >= k){
                end = mid;
            }else{
                start = mid + 1;
            }
        }
        return start;
    }
}