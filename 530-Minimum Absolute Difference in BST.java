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
    int res = Integer.MAX_VALUE;
    Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
        if(root == null) return res;
        
        getMinimumDifference(root.left);
        
        if(prev != null){
            res = Math.min(res, root.val - prev);
        }
        prev = root.val;
        
        getMinimumDifference(root.right);
        
        return res;
        
        
        
    }
    
}

//follow up
//What if it is not a BST? (Follow up of the problem) The idea is to put values in a TreeSet and then every time we can use O(lgN) time to lookup for the nearest values.