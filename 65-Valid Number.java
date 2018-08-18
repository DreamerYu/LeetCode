class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        
        boolean point = false, number = false, e = false, afterenum = false, afterpointnum = false;
        
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9'){
                number = true;
                afterenum = true;
                afterpointnum = true;
            }else if(s.charAt(i) == 'e'){
                if(e || !number) return false;
                e = true;
                afterenum = false;
            }else if(s.charAt(i) == '.'){
                if(point || e) return false;
                point = true;
                afterpointnum = true;
            }else if(s.charAt(i) == '-' || s.charAt(i) == '+'){
                if(i != 0 && s.charAt(i - 1) != 'e') return false;
            }else return false;
        }
        return number && afterenum && afterpointnum;
    }
}