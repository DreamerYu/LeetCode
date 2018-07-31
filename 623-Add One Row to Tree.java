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
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(d == 1){
            TreeNode n = new TreeNode(v);
            n.left = root;
            return n;
        }
        queue.offer(root);

        while(d != 2){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            d--;
        }

        int size = queue.size();
        for(int i = 0; i < size; i++){
            TreeNode now = queue.poll();
            TreeNode nodel = new TreeNode(v), noder = new TreeNode(v);
            nodel.left = now.left;
            noder.right = now.right;
            now.left = nodel;
            now.right = noder;
        }
        return root;

    }
}