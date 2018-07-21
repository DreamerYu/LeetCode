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
    HashMap<String, Integer> map;
    List<TreeNode> res;
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        res = new ArrayList<>();
        collect(root);
        return res;
    }
    
    public String collect(TreeNode root){
        if(root == null) return "#";
        String str = root.val + "," + collect(root.left) + "," + collect(root.right);
        map.put(str, map.getOrDefault(str, 0) + 1);
        if(map.get(str) == 2){
            res.add(root);
        }
        return str;
    }
}