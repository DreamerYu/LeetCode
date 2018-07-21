public class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int cap;
    int min = -1;
    public LFUCache(int capacity) {
        cap = capacity;
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        lists.put(1, new LinkedHashSet<>());
    }
    
    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        int count = counts.get(key);
        counts.put(key, count+1);
        lists.get(count).remove(key);
        if(count==min && lists.get(count).size()==0)
            min++;
        if(!lists.containsKey(count+1))
            lists.put(count+1, new LinkedHashSet<>());
        lists.get(count+1).add(key);
        return vals.get(key);
    }
    
    public void put(int key, int value) {
        if(cap<=0)
            return;
        if(vals.containsKey(key)) {
            vals.put(key, value);
            get(key);
            return;
        } 
        if(vals.size() >= cap) {
            int evit = lists.get(min).iterator().next();
            lists.get(min).remove(evit);
            vals.remove(evit);
        }
        vals.put(key, value);
        counts.put(key, 1);
        min = 1;
        lists.get(1).add(key);
    }
}
    
    //O(n)»áTLE
//     class Node{
//         int key;
//         int value;
//         int times;
//         Node pre;
//         Node next;
//         public Node(int key, int value){
//             this.key = key;
//             this.value = value;
//             times = 0;
//         }
//     }
    
//     HashMap<Integer, Node> map;
//     int capacity;
//     Node head, tail;

//     public LFUCache(int capacity) {
//         map = new HashMap<>();
//         this.capacity = capacity;
//         head = null;
//         tail = null;
//     }
    
//     public int get(int key) {
//         Node node = map.get(key);
//         if(node == null){
//             return -1;
//         }else{
//             node.times++;
//             map.put(key, node);
//             if(node != tail){
//                 if(node == head){
//                     head = head.next;
//                     head.pre = null;
//                 }else{
//                     node.pre.next = node.next;
//                     node.next.pre = node.pre;
//                 }
//                 Node point = head;
//                 if(point.times <= node.times) {
//                     while(point.next != null && point.next.times <= node.times) point = point.next;
//                     if(point.next == null){
//                         tail.next = node;
//                         node.pre = tail;
//                         node.next = null;
//                         tail = node;
//                     }else{
//                         node.next = point.next;
//                         node.pre = point;
//                         point.next = node;
//                     }
//                 }else{
//                     node.next = head;
//                     head.pre = node;
//                     node.pre = null;
//                     head = node;
//                 }
                
//             }
//         }
//         return node.value;
        
//     }
    
//     public void put(int key, int value) {
//         Node node = map.get(key);
//         if(node == null){
//             Node newNode = new Node(key, value);
//             if(capacity == 0){
//                 if(map.size() == 0) return;
//                 if(map.size() == 1){
//                     Node temp = head;
//                     head = head.next;
//                     map.remove(temp.key);
//                     capacity++;
//                     head = null;
//                     tail = null;
//                 }else{
//                     Node temp = head;
//                     head = head.next;
//                     map.remove(temp.key);
//                     capacity++;
//                     head.pre = null;
//                 }
//             }
//             if(head == null && tail == null){
//                 head = newNode;
//                 tail = newNode;
//             }else{
//                 if(head.times != 0){
//                     newNode.next = head;
//                     head.pre = newNode;
//                     head = newNode;
//                     head.pre = null;
//                 }else if(tail.times != 0){
//                     Node point = head;
//                     while(point.next.times <= 0) point = point.next;
//                     point.next.pre = newNode;
//                     newNode.next = point.next;
//                     newNode.pre = point;
//                     point.next = newNode;
//                 }else{
//                     tail.next = newNode;
//                     newNode.pre = tail;
//                     newNode.next = null;
//                     tail = newNode;
//                 }
//             }
//             map.put(key, newNode);
//             capacity--;
//         }else{
//             node.value = value;
//             node.times++;
//             map.put(key, node);
//             if(node != tail){
//                 if(node == head){
//                     head = head.next;
//                     head.pre = null;
//                 }else{
//                     node.pre.next = node.next;
//                     node.next.pre = node.pre;
//                 }
//                 Node point = head;
//                 if(point.times <= node.times) while(point.next != null && point.next.times <= node.times) point = point.next;
//                 if(point == tail){
//                     tail.next = node;
//                     node.pre = tail;
//                     node.next = null;
//                     tail = node;
//                 }else{
//                     point.next.pre = node;
//                     node.next = point.next;
//                     point.next = node;
//                     node.pre = point;
//                 }
//             }
//         }
//     }
// }

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */