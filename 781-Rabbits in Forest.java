class Solution {
    public int numRabbits(int[] answers) {
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int answer : answers){
            map.put(answer,map.getOrDefault(answer,0)+1);
        }
        for(Integer n : map.keySet()){
            int group = map.get(n)/(n+1);
            res += map.get(n)%(n+1) != 0 ? (group+1)*(n+1) : group*(n+1);
        }
        return res;
    }
}