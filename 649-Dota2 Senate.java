class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> q1 = new LinkedList<>(), q2 = new LinkedList<>();
        for(int i = 0; i < senate.length(); i++){
            if(senate.charAt(i) == 'R') q1.add(i);
            else q2.add(i);
        }
        
        while(!q1.isEmpty() && !q2.isEmpty()){
            int rindex = q1.poll(), dindex = q2.poll();
            if(rindex < dindex) q1.add(rindex + senate.length());
            else q2.add(dindex + senate.length());
        }
        return q1.size() > q2.size() ? "Radiant" : "Dire";
    }
}
