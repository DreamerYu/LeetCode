class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a, b) -> (a[1] - b[1]));
        int time = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        
        for(int i = 0; i < courses.length; i++){
            if(time + courses[i][0] <= courses[i][1]){
                q.offer(courses[i][0]);
                time += courses[i][0];
            }else if(!q.isEmpty() && courses[i][0] < q.peek()){
                time += courses[i][0] - q.poll();
                q.offer(courses[i][0]);
            }
        }
        return q.size();
    }
}