class Solution {
    public String solveEquation(String equation) {
        int index = 0;
        for(int i = 0; i < equation.length(); i++){
            if(equation.charAt(i) == '='){
                index = i;
                break;
            }
        }
        StringBuilder str = new StringBuilder(equation.substring(0, index));
        for(int i = index + 1; i < equation.length(); i++){
            if(i == index + 1 && (Character.isDigit(equation.charAt(index + 1)) || equation.charAt(i) == 'x')){
                str.append("-");
                str.append(equation.charAt(i));
            }else if(equation.charAt(i) == '+'){
                str.append("-");
            }else if(equation.charAt(i) == '-'){
                str.append("+");
            }else str.append(equation.charAt(i));
        }
        int xnum = 0, sum = 0, num = 0;
        int f = 1;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                num = num * 10 + (int)(ch - '0');
                continue;
            }else if(ch == 'x'){
                if(i == 0 || !Character.isDigit(str.charAt(i - 1))){
                    num = 1;
                }
                xnum += f * num;
                num = 0;
                f = 1;
                continue;
            }
            sum += f * num;
            if(ch == '+'){
                f = 1;
                num = 0;
            }else if(ch == '-'){
                f = -1;
                num = 0;
            }
            

        }
        if(str.charAt(str.length() - 1) != 'x'){
            sum += f * num;
        }
        sum = -sum;
        if(xnum == 0 && sum == 0){
            return "Infinite solutions";
        }else if(sum == 0){
            return "x=0";
        }else if(xnum == 0){
            return "No solution";
        }else return "x=" + sum / xnum;
    }
}