class RandomizedCollection {
    HashMap<Integer, HashSet<Integer>> mapplace;
    ArrayList<Integer> list;
    java.util.Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        mapplace = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean contain = mapplace.containsKey(val);
	    if (!contain) mapplace.put(val, new HashSet<Integer>()); 
	    mapplace.get(val).add(list.size());        
        list.add(val);
        return !contain;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean contain = mapplace.containsKey(val);
        if(!contain) return false;
        int loc = mapplace.get(val).iterator().next();
        mapplace.get(val).remove(loc);
        if(loc < list.size() - 1){
            int lastone = list.get(list.size() - 1);
            list.set(loc, lastone);
            mapplace.get(lastone).remove(list.size() - 1);
            mapplace.get(lastone).add(loc);
        }
        if(mapplace.get(val).isEmpty()) mapplace.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */