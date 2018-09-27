class FreqStack {
    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> lists;
    int maxfreq;

    public FreqStack() {
        freq = new HashMap<>();
        lists = new HashMap<>();
        maxfreq = 0;
    }
    
    public void push(int x) {
        int f = freq.getOrDefault(x, 0) + 1;
        freq.put(x, f);
        if(f > maxfreq){
            maxfreq++;
            lists.put(f, new Stack<>());
        }
        lists.get(f).push(x);
        
        
    }
    
    public int pop() {
        int num = lists.get(maxfreq).pop();
        int f = freq.get(num) - 1;
        if(f == 0) freq.remove(num);
        else freq.put(num, f);
        if(lists.get(maxfreq).size() == 0){
            lists.remove(maxfreq);
            maxfreq--;
        }
        return num;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */