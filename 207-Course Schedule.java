class Solution {
    public boolean canFinish(int numcourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numcourses];
        int[] degree = new int[numcourses];
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < numcourses; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        
        for(int i = 0; i < numcourses; i++){
            if(degree[i] == 0){
                count++;
                queue.offer(i);
            }
        }
        
        while(!queue.isEmpty()){
            int point = queue.poll();
            for(int p : graph[point]){
                degree[p]--;
                if(degree[p] == 0){
                    queue.offer(p);
                    count++;
                }
            }
        }
        return count == numcourses;
    }
}