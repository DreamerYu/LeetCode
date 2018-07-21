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
    public TreeNode pruneTree(TreeNode root) {
        return containsone(root) ? root : null;
        
    }
    
    public boolean containsone(TreeNode root){
        if(root == null) return false;
        boolean a1 = containsone(root.left);
        boolean a2 = containsone(root.right);
        if(!a1) root.left = null;
        if(!a2) root.right = null;
        return root.val == 1 || a1 || a2;
    }
}