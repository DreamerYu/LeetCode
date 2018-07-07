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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        
        if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            TreeNode minnode = findmin(root.right);
            root.val = minnode.val;
            root.right = deleteNode(root.right, root.val);//为何不能直接minnode = null？ 因为minnode是一个变量，只能将这个引用置为null，其内存空间还没变，仍然和root所连接
        }
        return root;
    }
    
    public TreeNode findmin(TreeNode root){
        while(root.left != null) root = root.left;
        return root;
    }
}