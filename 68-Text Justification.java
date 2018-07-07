class Solution {
    public List<String> fullJustify(String[] words, int maxwidth) {
        List<String> res = new ArrayList<>();
        int index = 0;
        
        while(index < words.length){
            int count = words[index].length();
            int last = index + 1;
            while(last < words.length){
                if(count + words[last].length() + 1 > maxwidth) break;
                count += words[last].length() + 1;
                last++;
            }
            StringBuilder st = new StringBuilder();
            int sp = last - index - 1;
            if(last == words.length || last - index - 1 == 0){
                for(int i = index; i < last; i++){
                    st.append(words[i] + " ");
                }
                st.deleteCharAt(st.length() - 1);
                for(int i = st.length(); i < maxwidth; i++){
                    st.append(" ");
                }
            }else{
                int spaces = (maxwidth - count) / sp;
                int increase = (maxwidth - count) % sp;
                for(int i = index; i < last; i++){
                    st.append(words[i]);
                    if (i < last - 1) {
                        for (int j = 0; j <= (spaces + ((i - index) < increase ? 1 : 0)); j++) {
                            st.append(" ");
                        }
                    }
                }
            }
            res.add(st.toString());
            index = last;
        }
        return res;
    }
}