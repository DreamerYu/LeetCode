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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        bfs(queue, res);
        return res;
    }
    
    public void bfs(Queue<TreeNode> queue, List<Integer> res){
        int size = queue.size();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++){
            TreeNode ele = queue.poll();
            if(ele != null){
                queue.offer(ele.left);
                queue.offer(ele.right);
                max = Math.max(max, ele.val);
            }
        }
        if(queue.size() != 0){
            res.add(max);
            bfs(queue, res);
        }
    }
}