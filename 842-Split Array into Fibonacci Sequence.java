class Solution {
    public List<Integer> splitIntoFibonacci(String S) {
        List<Integer> res = new ArrayList<>();
        if(help(S, res, 0)) return res;
        else return new ArrayList<>();
    }
    
    public boolean help(String s, List<Integer> res, int index){
        if(index == s.length() && res.size() >= 3) return true;
        for(int i = index + 1; i <= s.length(); i++){
            String str = s.substring(index, i);
            if(str.charAt(0) == '0' && str.length() > 1) break;
            
            long num = Long.parseLong(s.substring(index, i));
            if (num > Integer.MAX_VALUE) {
                break;
            }
            int size = res.size();
            // early termination
            if (size >= 2 && num > res.get(size-1) + res.get(size-2)) {
                break;
            }
            if (size <= 1 || num == res.get(size-1) + res.get(size-2)) {
                res.add((int)num);
                // branch pruning. if one branch has found fib seq, return true to upper call
                if (help(s, res, i)) {
                    return true;
                }
                res.remove(res.size()-1);
            }
        }
        return false;
    }
}