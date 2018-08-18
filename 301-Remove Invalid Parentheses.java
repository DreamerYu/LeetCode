class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if(s == null) return res;
        
        dfs(0, 0, s, "", res, 0);
        int max = 0;
        HashSet<String> set = new HashSet<>();
        for(String st : res){
            max = Math.max(max, st.length());
        }
        List<String> res1 = new ArrayList<>();
        for(String st : res){
            if(st.length() == max && !set.contains(st)) res1.add(st);
            set.add(st);
        }
        return res1;
    }
    
    public void dfs(int left, int right, String s, String str, List<String> res, int index){
        if(index == s.length()){
            if(left == right) res.add(str);
            return;
        }
        if(left < right) return;
        char ch = s.charAt(index);
        if(ch == '('){
            dfs(left + 1, right, s, str + '(', res, index + 1);
            dfs(left, right, s, str, res, index + 1);
        }else if(ch == ')'){
            dfs(left, right + 1, s, str + ')', res, index + 1);
            dfs(left, right, s, str, res, index + 1);
        }else{
            dfs(left, right, s, str + ch, res, index + 1);
        }
    }
}