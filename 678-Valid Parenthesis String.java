class Solution {
    public boolean checkValidString(String s) {
        return check(s, 0, 0);
    }
    
    public boolean check(String s, int start, int count){
        if(count < 0) return false;
        
        for(int i = start; i < s.length(); i++){
            if(s.charAt(i) == '('){
                count++;
            }else if(s.charAt(i) == ')'){
                count--;
            }else{
                return check(s, i + 1, count + 1) || check(s, i + 1, count) || check(s, i + 1, count - 1);
            }
            if(count < 0) return false;
        }
        return count == 0;
    }
}