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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = new TreeNode(Integer.MIN_VALUE);
    
    //morris traversal O(1)space
    public void recoverTree(TreeNode root){
        while(root != null){
            TreeNode node = root.left;
            if(node != null){
                while(node.right != null && node.right != root){
                    node = node.right;
                }
                if(node.right == null){
                    node.right = root;
                    root = root.left;
                    continue;
                }else node.right = null;
            }
            
            if(root.val < prev.val){
                if(first == null){
                    first = prev;
                }
                if(first != null) second = root;
            }
            prev = root;
            root = root.right;
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    
    //solution2 O(n)space
//     public void recoverTree2(TreeNode root) {
//         traversal(root);
//         int temp = first.val;
//         first.val = second.val;
//         second.val = temp;
//     }
    
//     public void traversal(TreeNode root){
//         if(root == null) return;
        
//         traversal(root.left);
//         if(first == null && prev.val >= root.val){
//             first = prev;
//         }
//         if(first != null && prev.val  >= root.val){
//             second = root;
//         }
//         prev = root;
            
//         traversal(root.right);
//     }
}