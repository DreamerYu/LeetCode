//follow up
// class ZigzagIteratorK {
	
// 	Queue<Iterator<Integer>> q;
	
// 	public ZigzagIterator(List<List<Integer>> lists) {
// 		q = new LinkedList<Iterator<Integer>>();
// 		for (int i = 0; i < lists.size(); i++) {
// 			Iterator<Integer> it = lists.get(i).iterator();
// 			q.offer(it);
// 		}
// 	}
	
// 	public int next() {
// 		Iterator<Integer> it = q.poll();
// 		int tmp = it.next();
// 		q.offer(it);
// 		return tmp;
// 	}
	
// 	public boolean hasNext() {
// 		while (!q.isEmpty()) {
// 			if (q.peek().hasNext()) return true;
// 			else q.poll();
// 		}
// 		return false;
// 	}
// }


public class ZigzagIterator {
    private Queue<Integer> q;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        q = new LinkedList<>();
        for(int i = 0; i < Math.max(v1.size(), v2.size()); i++){
            if(i < v1.size()) q.offer(v1.get(i));
            if(i < v2.size()) q.offer(v2.get(i));
        }
    }

    public int next() {
        return q.poll();
    }

    public boolean hasNext() {
        return q.size() != 0;
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */