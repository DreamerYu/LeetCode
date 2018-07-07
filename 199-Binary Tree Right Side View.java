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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0; i < len; i++){
                TreeNode node = queue.poll();
                if(i == 0) res.add(node.val);
                if(node.right != null) queue.add(node.right);
                if(node.left != null) queue.add(node.left);
            }
        }
        return res;
    }
}