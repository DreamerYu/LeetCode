class Solution {
    public String reorganizeString(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            int count = map.getOrDefault(ch, 0) + 1;
            if (count > (s.length() + 1) / 2) return "";
            map.put(ch, count);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        for(char ch : map.keySet()){
            pq.add(new int[]{ch, map.get(ch)});
        }
        
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int[] first = pq.poll();
            if(sb.length() == 0 || first[0] != sb.charAt(sb.length() - 1)){
                sb.append((char) first[0]);
                if (--first[1] > 0) {
                    pq.add(first);
                }
            }else{
                int[] second = pq.poll();
                sb.append((char) second[0]);
                if (--second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
            }
        }
        return sb.toString();
    }
}