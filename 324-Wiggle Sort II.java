class Solution {
    public void wiggleSort(int[] nums) {
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        Arrays.sort(tmp);
        int s1 = (nums.length - 1) / 2, s2 = nums.length - 1;
        for(int i = 0; i < nums.length; i++){
            nums[i] = i % 2 == 0? tmp[s1--] : tmp[s2--];
        }
    }
}