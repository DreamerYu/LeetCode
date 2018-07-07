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
    int maxv = 0;
    public int maxPathSum(TreeNode root) {
        maxv = Integer.MIN_VALUE;
        help(root);
        return maxv;
        
    }
    
    public int help(TreeNode root){
        if(root == null) return 0;
        int left = Math.max(0, help(root.left));
        int right = Math.max(0, help(root.right));
        maxv = Math.max(maxv, left + right + root.val);
        return Math.max(left, right) + root.val;
    }
}