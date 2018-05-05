class Solution {
    public int triangleNumber(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
                while (k < nums.length && nums[i] + nums[j] > nums[k])
                    k++;
                count += k - j - 1;
            }
        }
        return count;
    }
    
    public int triangleNumber2(int[] nums) {
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 2; i++){
            // if(i > 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < nums.length - 1; j++){
                // if(j > i + 1 && nums[j] == nums[j - 1]) continue;
                for(int k = j + 1; k < nums.length; k++){
                    // if(k > j + 1 && nums[k] == nums[k - 1]) continue;
                    if(nums[i] + nums[j] > nums[k]) count++;
                }
            }
        }
        return count;
    }
}