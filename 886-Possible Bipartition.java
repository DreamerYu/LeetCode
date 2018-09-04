class Solution {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[][] graph = new int[N][N];
        for(int[] e : dislikes){
            graph[e[0] - 1][e[1] - 1] = 1;
            graph[e[1] - 1][e[0] - 1] = 1;
        }
        
        int[] group = new int[N];
        for(int i = 0; i < group.length; i++){
            if(group[i] == 0 && !dfs(graph, group, i, 1)) return false;
        }
        return true;
    }
    
    public boolean dfs(int[][] graph, int[] group, int index, int g){
        group[index] = g;
        for(int i = 0; i < graph.length; i++){
            if(graph[index][i] == 1){
                if(group[i] == g) return false;
                else if(group[i] == 0 && !dfs(graph, group, i, -g)){
                    return false;
                }
            }
        }
        return true;
    }
}