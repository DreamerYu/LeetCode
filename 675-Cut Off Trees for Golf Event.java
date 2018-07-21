class Solution {
    
    static int[][] dir = {{0,1}, {0, -1}, {1, 0}, {-1, 0}};
    public int cutOffTree(List<List<Integer>> forest){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        if(forest == null || forest.size() == 0) return -1;
        int r = forest.size(), c = forest.get(0).size();
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(forest.get(i).get(j) > 1){
                    queue.offer(new int[]{i, j, forest.get(i).get(j)});
                }
            }
            
        }
        
        int[] start = new int[2];
        int sum = 0;
        while(!queue.isEmpty()){
            int[] end = queue.poll();
            int step = bfs(forest, start, end, r, c);
            
            if(step < 0) return -1;
            sum += step;
            start[0] = end[0];
            start[1] = end[1];
        }
        return sum;
    }
    
    
    private int bfs(List<List<Integer>> forest, int[] start, int[] tree, int m, int n) {
        int step = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == tree[0] && curr[1] == tree[1]) return step;

                for (int[] d : dir) {
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n 
                        || forest.get(nr).get(nc) == 0 || visited[nr][nc]) continue;
                    queue.add(new int[] {nr, nc});
                    visited[nr][nc] = true;
                }
            }
            step++;
        }

        return -1;
    }
}