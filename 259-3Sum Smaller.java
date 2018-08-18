class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            int start = i + 1, end = nums.length - 1;
            while(start < end){
                int sum = nums[i] + nums[start] + nums[end];
                if(sum < target){
                    count += end - start;
                    start++;
                }else{
                    end--;
                }
            }
        }
        return count;
    }
}