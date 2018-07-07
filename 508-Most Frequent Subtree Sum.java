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
    HashMap<Integer, Integer> map = new HashMap<>();
    public int[] findFrequentTreeSum(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        int maxcount = Integer.MIN_VALUE;
        help(root);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            maxcount = Math.max(maxcount, entry.getValue());
        }
        
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(maxcount == entry.getValue()) res.add(entry.getKey());
            
        }
        
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        
        return result;
    }
    
    public int help(TreeNode root){
        if(root == null) return 0;
        int left = help(root.left);
        int right = help(root.right);
        map.put(left + right + root.val, map.getOrDefault(left + right + root.val, 0) + 1);
        return left + right + root.val;
    }
}