class Solution {
    public int missingNumber(int[] nums) {
        
        
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
        
        //bit
        // int missing = nums.length;
        // for (int i = 0; i < nums.length; i++) {
        //     missing ^= i ^ nums[i];
        // }
        // return missing;
        
    }
}