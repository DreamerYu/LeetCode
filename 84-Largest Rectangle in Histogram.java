class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0) return 0;
        int[] highleft = new int[heights.length];
        int[] highright = new int[heights.length];
        highright[heights.length - 1] = heights.length;
        highleft[0] = -1;
        
        for(int i = 1; i < heights.length; i++){
            int p = i - 1;
            while(p >= 0 && heights[p] >= heights[i]){
                p = highleft[p];
            }
            highleft[i] = p;
        }
        
        for(int i = heights.length - 2; i >= 0; i--){
            int p = i + 1;
            while(p < heights.length && heights[p] >= heights[i]){
                p = highright[p];
            }
            highright[i] = p;
        }
        int maxarea = 0;
        for(int i = 0; i < heights.length; i++){
            maxarea = Math.max(maxarea, heights[i] * (highright[i] - highleft[i] - 1));
        }
        return maxarea;
    }
}