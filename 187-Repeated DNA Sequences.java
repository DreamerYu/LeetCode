class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i = 0; i < s.length() - 9; i++){
            if(map.containsKey(s.substring(i, i + 10))){
                if(map.get(s.substring(i, i + 10)) == 1) res.add(s.substring(i, i + 10));
                map.put(s.substring(i, i + 10), map.get(s.substring(i, i + 10)) + 1);
            }else{
                map.put(s.substring(i, i + 10), 1);
            }
        }
        return res;
        
    }
}