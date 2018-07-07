class MyCalendarTwo {
    //treemap
    private TreeMap<Integer, Integer> map;
    public MyCalendarTwo(){
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end){
        map.put(start, map.getOrDefault(start, 0) + 1);
        map.put(end, map.getOrDefault(end, 0) - 1);
        int count = 0;
        for(int value : map.values()){
            count += value;
            if(count >= 3){
                map.put(start, map.get(start) - 1);
                map.put(end, map.get(end) + 1);
                return false;
            }
        }
        return true;
    }
    
//     //brute force
//     List<int[]> calendar;
//     List<int[]> overlap;

//     public MyCalendarTwo() {
//         calendar = new ArrayList<>();
//         overlap = new ArrayList<>();
//     }
    
//     public boolean book(int start, int end) {
//         for(int[] ch : overlap){
//             if(ch[0] < end && ch[1] > start) return false;
//         }
//         for(int[] ch : calendar){
//             if(ch[0] < end && ch[1] > start)
//                 overlap.add(new int[]{Math.max(start, ch[0]), Math.min(end, ch[1])});
//         }
//         calendar.add(new int[]{start, end});
//         return true;
//     }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */