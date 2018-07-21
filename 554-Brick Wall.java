class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall == null || wall.size() == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(List<Integer> list : wall){
            int length = 0;
            for(int i = 0; i < list.size() - 1; i++){
                length += list.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                max = Math.max(max, map.getOrDefault(length, 0));
            }
        }
        return wall.size() - max;
    }
}