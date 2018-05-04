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
    public int rob(TreeNode root) {
        if(root == null) return 0;
        return Math.max(rob(root.left, false) + rob(root.right, false), rob(root.left, true) + rob(root.right, true) + root.val);
    }
    
    public int rob(TreeNode root, boolean include){
        if(root == null) return 0;
        if(include){
            return rob(root.left, false) + rob(root.right, false);
        }else{
            return Math.max(rob(root.left, false) + rob(root.right, false), rob(root.left, true) + rob(root.right, true) + root.val);
        }
    }
}