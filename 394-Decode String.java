class Solution {
    public String decodeString(String s) {
        Stack<String> resStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        int index = 0;
        String res = "";
        while(index < s.length()){
            if(Character.isDigit(s.charAt(index))){
                int count = 0;
                while(Character.isDigit(s.charAt(index))){
                    count = count * 10 + s.charAt(index) - '0';
                    index++;
                }
                countStack.push(count);
            }else if (s.charAt(index) == '[') {
                resStack.push(res);
                res = "";
                index++;
            }
            else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder (resStack.pop());
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                index++;
            }
            else {
                res += s.charAt(index++);
            }
        }
        return res;
    }
}