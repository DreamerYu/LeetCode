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
    int maxlen = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        help(root);
        return maxlen;
    }
    
    public int help(TreeNode root){
        if(root == null) return 0;
        int left = help(root.left);
        int right = help(root.right);
        int lleft = 0, rright = 0;
        if(root.left != null && root.val == root.left.val){
            lleft = left + 1;
        }
        if(root.right != null && root.val == root.right.val){
            rright = right + 1;
        }
        maxlen = Math.max(maxlen, lleft + rright);
        return Math.max(lleft, rright);
    }
}