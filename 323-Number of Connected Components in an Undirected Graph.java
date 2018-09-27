class Solution {
    public int countComponents(int n, int[][] edges) {
        if(n < 1) return 0;
        
        HashSet<Integer> visited = new HashSet<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.put(i, new ArrayList<>());
        }
        
        for(int i = 0; i < edges.length; i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }
        
        int count = 0;
        for(int i = 0; i < n; i++){
            if(visited.add(i)){
                dfs(map, i, visited);
                count++;
            }
        }
        return count;
        
    }
    
    public void dfs(HashMap<Integer, List<Integer>> map, int i, HashSet<Integer> visited){
        for(int j : map.get(i)){
            if(visited.add(j)){
                dfs(map, j, visited);
            }
        }
    }
}