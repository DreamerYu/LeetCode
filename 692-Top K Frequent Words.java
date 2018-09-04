class Solution {
    class st{
        String str;
        int times;
        
        st(String str, int times){
            this.str = str;
            this.times = times;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> res = new ArrayList<>();
        PriorityQueue<st> q = new PriorityQueue<>(new Comparator<st>(){
            public int compare(st s1, st s2){
                if(s1.times == s2.times){
                    return s1.str.compareTo(s2.str);
                }else if(s1.times == s2.times) return 0;
                else if(s1.times > s2.times) return -1;
                else return 1;
            }
        });
        
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < words.length; i++){
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        
        for(String key : map.keySet()){
            q.offer(new st(key, map.get(key)));
        }
        while(!q.isEmpty() && k > 0){
            k--;
            res.add(q.poll().str);
        }
        return res;
        
    }
}