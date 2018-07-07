class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int myDist = Math.abs(target[0] - 0) + Math.abs(target[1] - 0);
        int ghostDist = Integer.MAX_VALUE;
        for (int[] ghost : ghosts) {
            ghostDist = Math.abs(target[0] - ghost[0]) + Math.abs(target[1] - ghost[1]);
            if (ghostDist <= myDist) {
                return false;
            }
        }
        return true;
        
    }
}