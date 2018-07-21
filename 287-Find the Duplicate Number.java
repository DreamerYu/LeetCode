class Solution {
    public int findDuplicate(int[] nums) {
        int min = 0, max = nums.length;
        while(min <= max){
            int mid = (max + min) / 2;
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] <= mid){
                    count++;
                }
            }
            if(count > mid){
                max = mid - 1;
            }else{
                min = mid + 1;
            }
        }
        return min;
    }
    
    public int findDuplicat2e(int[] nums){
        int slow = 0, fast = 0;
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow != fast);
        int slow2 = 0;
        do{
            slow = nums[slow];
            slow2 = nums[slow2];
        }while(slow != slow2);
        return slow2;
    }
}