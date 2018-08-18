class Solution {
    class pair{
        int x, y;
        public pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int shortestDistance(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited;
        int[][] distance = new int[m][n];
        int[][] reach = new int[m][n];
        Queue<pair> q = new LinkedList<>();
        int onenum = 0;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    onenum++;
                    q.offer(new pair(i, j));
                    visited = new boolean[m][n];
                    int count = 0;
                    while(!q.isEmpty()){
                        int size = q.size();
                        count++;
                        for(int k = 0; k < size; k++){
                            pair p = q.poll();
                            for(int[] d : dir){
                                int newx = p.x + d[0], newy = p.y + d[1];
                                if(newx >= 0 && newx < m && newy >= 0 && newy < n && grid[newx][newy] == 0 && !visited[newx][newy]){
                                    visited[newx][newy] = true;
                                    distance[newx][newy] += count;
                                    reach[newx][newy]++;
                                    q.offer(new pair(newx, newy));
                                }

                            }
                        }
                        
                            
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 && reach[i][j] == onenum) min = Math.min(min, distance[i][j]);
            }
        }
        if(min == 0 || min == Integer.MAX_VALUE) return -1;
        return min;
        
    }
}