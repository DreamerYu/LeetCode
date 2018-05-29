class Solution {
    //understand the meaning of "\\s+"
    public String replaceWords(List<String> dict, String sentence) {
        HashSet<String> set = new HashSet<>();
        for(String word : dict) set.add(word);
        StringBuilder ans = new StringBuilder();
        for(String word : sentence.split("\\s+")){
            String prefix = "";
            for(int i = 0; i <= word.length(); i++){
                prefix = word.substring(0, i);
                if(set.contains(prefix)) break;
            }
            if(ans.length() > 0) ans.append(" ");
            ans.append(prefix);
        }
        return ans.toString();
    }
}