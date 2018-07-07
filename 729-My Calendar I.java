class MyCalendar {
    //treemap
    TreeMap<Integer, Integer> calendar;

    MyCalendar() {
        calendar = new TreeMap();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start),
                next = calendar.ceilingKey(start);
        if ((prev == null || calendar.get(prev) <= start) &&
                (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }
    
    //brute force
//     private List<int[]> calendar;
//     public MyCalendar() {
//         calendar = new ArrayList<>();
//     }
    
//     public boolean book(int start, int end) {
//         for(int[] ele : calendar){
//             if (ele[0] < end && start < ele[1]) return false;//!!
//         }
//         calendar.add(new int[]{start, end});
//         return true;
//     }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */