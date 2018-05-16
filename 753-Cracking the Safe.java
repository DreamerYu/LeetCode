class Solution {
    private StringBuilder ans = new StringBuilder();
    public String crackSafe(int n, int k) {
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n - 1; i++){
            sb.append("0");
        }
        dfs(set, k, sb.toString());
        // ans.append(sb.toString());
        return new String(ans);
    }
    
    public void dfs(HashSet set, int k, String str){
        for(int i = 0; i < k; i++){
            String sub = str + i;
            if(!set.contains(sub)){
                set.add(sub);
                dfs(set, k, sub.substring(1));
                ans.append(i);
            }
        }
    }
}

