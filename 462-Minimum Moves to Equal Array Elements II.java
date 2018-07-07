class Solution {
    public int minMoves2(int[] nums) {
        // int sum = 0, median = quickselect(nums, nums.length / 2 + 1, 0, nums.length - 1);
        int sum = 0, median = quickSelect2(nums, 0, nums.length - 1, nums.length / 2 + 1);
        for (int i = 0;i < nums.length; i++) sum += Math.abs(nums[i] - median);
        return sum;
    }
    
    public int quickselect(int[] nums, int k, int start, int end){
        int i = start, j = end, pivot = nums[(start + end) / 2];
        while(i <= j){
            while(nums[i] < pivot) i++;
            while(nums[j] > pivot) j--;
            if(i >= j) break;
            swap(nums, i++, j--);
        }
        if(i - start + 1 > k) return quickselect(nums, k, start, i - 1);
        if(i - start + 1 == k && i == j) return nums[i];
        return quickselect(nums, k - j + start - 1, j + 1, end);
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
        public int quickSelect2(int[] nums, int left, int right, int k) {
        if (left > right) {
            return 0;
        }
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= nums[left]) {
                j --;
            }
            while (i < j && nums[i] <= nums[left]) {
                i ++;
            }
            swap(nums, i, j);
        }
        swap(nums, left, i);
        if(k == i - left + 1) {
            return nums[i];
        }
        else if(k < i - left + 1) {
            return quickSelect2(nums, left, i - 1, k);
        }
        else {
            return quickSelect2(nums, i + 1, right, k - (i - left + 1));
        }
    }
}