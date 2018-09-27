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
    TreeNode pre = null;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode head = new TreeNode(0);
        pre = head;
        inorder(root);
        return head.right;
    }
    
    public void inorder(TreeNode root){
        if(root == null) return;
        
        inorder(root.left);
        
        pre.right = root;
        pre = pre.right;
        pre.left = null;
        
        inorder(root.right);
        
    }
}