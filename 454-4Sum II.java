class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < B.length; j++){
                map.put(A[i] + B[j], map.containsKey(A[i] + B[j]) ? map.get(A[i] + B[j]) + 1 : 1);
            }
        }
        
        int res = 0;
        for(int i = 0; i < C.length; i++){
            for(int j = 0; j < D.length; j++){
                res += map.containsKey(-(C[i] + D[j])) ? map.get(-(C[i] + D[j])) : 0;
            }
        }
            
        return res;
    }
}