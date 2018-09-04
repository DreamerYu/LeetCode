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
    double dif = Double.MAX_VALUE;
    int res = 0;
    public int closestValue(TreeNode root, double target) {
        if(Math.abs(root.val - target) <= dif){
            res = root.val;
            dif = Math.abs(root.val - target);
        }
        
        if(root.val > target){
            if(root.left != null) closestValue(root.left, target);
        }else if(root.val < target){
            if(root.right != null) closestValue(root.right, target);
            
        }else return root.val;
        return res;
    }
}