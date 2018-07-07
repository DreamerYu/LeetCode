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
            root.right = deleteNode(root.right, root.val);//Ϊ�β���ֱ��minnode = null�� ��Ϊminnode��һ��������ֻ�ܽ����������Ϊnull�����ڴ�ռ仹û�䣬��Ȼ��root������
        }
        return root;
    }
    
    public TreeNode findmin(TreeNode root){
        while(root.left != null) root = root.left;
        return root;
    }
}