class Solution {
    
    char[] changes = {'A', 'C', 'G', 'T'};
    
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i < bank.length; i++) set.add(bank[i]);
        int cur = 1, index = 0;
        
        queue.offer(start);
        
        while(!queue.isEmpty()){
            cur--;
            String st = queue.poll();
            for(int i = 0; i < st.length(); i++){
                StringBuilder builder = new StringBuilder(st);
                for(int j = 0; j < 4; j++){
                    builder.setCharAt(i, changes[j]);
                    String word = builder.toString();
                    if(set.contains(word)){
                        if(word.equals(end)) return index + 1;
                        queue.offer(word);
                        set.remove(word);
                    }
                }
            }
            if(cur == 0){
                index++;
                cur = queue.size();
            }
        }
        return -1;
    }
}