class Solution {
    public int[] findOrder(int numcourses, int[][] prerequisites) {
        
        int[] res = new int[numcourses];
        List<Integer>[] graph = new ArrayList[numcourses];
        int[] degree = new int[numcourses];
        int count = 0, inx = 0;
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i = 0; i < numcourses; i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            degree[prerequisites[i][0]]++;
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        for(int i = 0; i < numcourses; i++){
            if(degree[i] == 0){
                count++;
                queue.offer(i);
                res[inx++] = i;
            }
        }
        
        while(!queue.isEmpty()){
            int point = queue.poll();
            for(int p : graph[point]){
                degree[p]--;
                if(degree[p] == 0){
                    queue.offer(p);
                    count++;
                    res[inx++] = p;
                }
            }
        }
        if(count == numcourses){
            return res;
        }else return new int[0];
        
    }
}