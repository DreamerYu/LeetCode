class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int s1 = -1, s2 = -1;
        int mindis = Integer.MAX_VALUE;
        if(word1.equals(word2)){
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1)){
                    s2 = s1;
                    s1 = i;
                }
                if(s1 >= 0 && s2 >= 0){
                    mindis = Math.min(mindis, Math.abs(s1 - s2));
                }
            }
        }else{
            for(int i = 0; i < words.length; i++){
                if(words[i].equals(word1)){
                    s1 = i;
                }else if(words[i].equals(word2)){
                    s2 = i;
                }
                if(s1 >= 0 && s2 >= 0){
                    mindis = Math.min(mindis, Math.abs(s1 - s2));
                }
            }
        }
        
        return mindis;
        
    }
}