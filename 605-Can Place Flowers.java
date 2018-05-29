class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed == null || flowerbed.length == 0) return false;
        for(int i = 0; i < flowerbed.length && n > 0; i++){
            if(flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)){
                n--;
                flowerbed[i] = 1;
            }
        }
        return n == 0;
    }
}