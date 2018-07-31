class Solution {
    public int lenLongestFibSubseq(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for(int a : A) set.add(a);
        int res = 0;
        for(int i = 0; i < A.length; i++){
            for(int j = i + 1; j < A.length; j++){
                int a = A[i], b = A[j], l = 2;
                while(set.contains(a + b)){
                    b = a + b;
                    a = b - a;
                    l++;
                }
                res = Math.max(res, l);
            }
        }
        return res == 2? 0 : res;
    }
}