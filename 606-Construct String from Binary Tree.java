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
    public String tree2str(TreeNode t) {
        if(t == null) return "";
        String p1 = "", p2 = "";
        String str;
        str = tree2str(t.left);
        if(str != ""){
            p1 = "(" + str + ")";
        }
        str = tree2str(t.right);
        if(str != ""){
            p2 = "(" + str + ")";
        }
        if(p1 == "" && p2 != "") p1 = "()";
        return "" + t.val + p1 + p2;
    }
}