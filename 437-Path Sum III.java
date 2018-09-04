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
    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        return help(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        
    }
    
    public int help(TreeNode root, int sum){
        if(root == null) return 0;
        return ((sum == root.val) ? 1 : 0) + help(root.left, sum - root.val) + help(root.right, sum - root.val);
    }
    
}