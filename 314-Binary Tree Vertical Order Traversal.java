/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    class Node{
        TreeNode node;
        int colum;
        Node(TreeNode node, int c){
            this.node = node;
            this.colum = c;
        }
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        q.offer(new Node(root, 0));
        int min = 0, max = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                Node n = q.poll();
                if(map.containsKey(n.colum)){
                    map.get(n.colum).add(n.node.val);
                }else{
                    map.put(n.colum, new ArrayList<>());
                    map.get(n.colum).add(n.node.val);
                }
                if(n.node.left != null){
                    q.offer(new Node(n.node.left, n.colum - 1));
                    min = Math.min(min, n.colum - 1);
                }
                if(n.node.right != null){
                    q.offer(new Node(n.node.right, n.colum + 1));
                    max = Math.max(max, n.colum + 1);
                }
            }
        }
        for(int i = min; i <= max; i++) res.add(map.get(i));
        return res;
    }
}