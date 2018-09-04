class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> s1 = new HashSet<>();
        HashSet<Integer> s2 = new HashSet<>();
        HashSet<Integer> visit = new HashSet<>();
        
        for(int k = 0; k < graph.length; k++){
            if(!visit.contains(k)){
                q.offer(k);
                s1.add(k);
                visit.add(k);
                boolean which = false;

                while(!q.isEmpty()){
                    int size = q.size();
                    for(int i = 0; i < size; i++){
                        int pp = q.poll();
                        for(int j = 0; j < graph[pp].length; j++){
                            if(which){
                                if(s2.contains(graph[pp][j])) return false;
                                s1.add(graph[pp][j]);
                            }else{
                                if(s1.contains(graph[pp][j])) return false;
                                s2.add(graph[pp][j]);
                            }
                            if(!visit.contains(graph[pp][j])){
                                q.offer(graph[pp][j]);
                                visit.add(graph[pp][j]);
                            }
                        }
                    }
                    which = !which;
                }
            }
        }
        
        return true;
    }
}