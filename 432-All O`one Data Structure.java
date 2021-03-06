class AllOne {
    HashMap<String, Integer> map;
    HashMap<Integer, List<String>> vals;
    String maxKey;
    String minKey;
    int max;
    int min;

    /** Initialize your data structure here. */
    public AllOne() {
        map = new HashMap<>();
        vals = new HashMap<>();
        maxKey = "";
        minKey = "";
        max = 0;
        min = 0;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
        int val = map.get(key);
        if(vals.get(val) == null) vals.put(val, new ArrayList<>());
        vals.get(val).add(key);
        if(vals.containsKey(val - 1)){
            vals.get(val - 1).remove(key);
            if(vals.get(val - 1).size() == 0) vals.remove(val - 1);
        }
        if(map.get(key) > max){
            max = map.get(key);
            maxKey = key;
        }
        if(map.get(key) - 1 == min){
            if(vals.get(min) == null || vals.get(min).size() == 0){
                min++;
                minKey = key;
            }
            else minKey = vals.get(min).get(0);
        }
        if(map.get(key) == 1){
            min = 1;
            minKey = key;
        }
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if(map.containsKey(key)){
            if(map.get(key) == 1){
                map.remove(key);
                vals.get(1).remove(key);
                if(vals.get(1).size() > 0){
                    min = 1;
                    minKey = vals.get(1).get(0);
                    if(max == 1) maxKey = minKey;
                }else{
                    vals.remove(1);
                    if(map.size() > 0){
                        int tempMin = Integer.MAX_VALUE;
                        for(int e : vals.keySet()){
                            if(vals.get(e).size() > 0)
                                tempMin = Math.min(tempMin, e);
                        }
                        min = tempMin;
                        minKey = vals.get(min).get(0);
                    }else{
                        min = 0;
                        max = 0;
                    }
                }
            }else{
                map.put(key, map.get(key) - 1);
                int val = map.get(key);
                vals.get(val + 1).remove(key);
                if(vals.get(val + 1).size() == 0) vals.remove(val + 1);
                if(vals.get(val) == null) vals.put(val, new ArrayList<>());
                vals.get(val).add(key);
                if(val + 1 == max){
                    if(vals.get(max) == null || vals.get(max).size() == 0) max--;
                    else maxKey = vals.get(max).get(0);
                }
                if(val + 1 == min){
                    min--;
                    minKey = key;
                }
            }
        }
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
        if(map.size() == 0) return "";
        return maxKey;
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
        if(map.size() == 0) return "";
        return minKey;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */