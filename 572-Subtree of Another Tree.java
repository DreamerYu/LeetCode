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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null) return false;
        if(s.val == t.val && issame(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    public boolean issame(TreeNode a, TreeNode b){
        if(a == null && b == null) return true;
        else if(a == null || b == null) return false;
        else{
            return a.val == b.val && issame(a.left, b.left) && issame(a.right, b.right);
        }
    }
}