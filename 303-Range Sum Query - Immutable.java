class NumArray {
    
    
    
    //cache optimize
    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
    
    //brute force
//     private int[] data;

//     public NumArray(int[] nums) {
//         data = nums;
//     }

//     public int sumRange(int i, int j) {
//         int sum = 0;
//         for (int k = i; k <= j; k++) {
//             sum += data[k];
//         }
//         return sum;
//     }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */