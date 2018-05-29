class Solution {
    int sum = 0;
    public int countArrangement(int N) {
        HashSet<Integer> set = new HashSet<>();
        
        help(1, N, set);
        return sum;
    }
    
    public void help(int index, int N, HashSet<Integer> set){
        if(index == N + 1){
            sum++;
            return;
        }
        for(int i = 1; i <= N; i++){
            if(!set.contains(i)){
                if(i % index == 0 || index % i == 0){
                    set.add(i);
                    help(index + 1, N, set);
                    set.remove(i);
                }
            } 
        }
    }
}