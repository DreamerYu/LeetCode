class Solution {
    public int subarrayBitwiseORs(int[] A) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        
        for(int a : A){
            HashSet<Integer> set2 = new HashSet<>();
            for(int x : set){
                set2.add(x | a);
            }
            set2.add(a);
            res.addAll(set2);
            set = set2;
            
        }
        return res.size();
    }
}