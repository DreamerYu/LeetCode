class Solution {
public int calculate(String s) {
        Stack<String> stack = new Stack<>();
        s = s.replaceAll(" ", "").replaceAll("-2147483648", "+2147483647+1");
        Converter converter = new Converter();
        String postfix = converter.convert(s);
        for (String token : postfix.split(",")) {
            if (!isOperator(token)) {
                stack.push(token);
            } else {
                int i2 = Integer.valueOf(stack.pop());
                int i1 = Integer.valueOf(stack.pop());
                stack.push(String.valueOf(evaluate(i1, token, i2)));
            }
        }
        return Integer.valueOf(stack.pop());
    }

    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int evaluate(int i1, String op, int i2) {
        int ans = 0;
        switch (op) {
            case "+":
                ans = i1 + i2;
                break;
            case "-":
                ans = i1 - i2;
                break;
            case "*":
                ans = i1 * i2;
                break;
            case "/":
                ans = (int) Math.floor((double) i1 / i2);
                break;
        }
        return ans;
    }

    private static class Converter {
        private final Map<Character, Integer> operators;

        private Converter() {
            operators = new HashMap<>();
            operators.put('+', 1);
            operators.put('-', 1);
            operators.put('*', 2);
            operators.put('/', 2);
        }

        private String convert(String s) {
            Stack<Character> stack = new Stack<>();
            int index = 0;
            StringBuilder res = new StringBuilder();
            while (index < s.length()) {
                int current = index;
                while (current < s.length() && Character.isDigit(s.charAt(current))) {
                    current++;
                }
                if (index != current) {
                    res.append(s.substring(index, current)).append(",");
                } else {
                    char operator = s.charAt(current);
                    if (operator == '(') {
                        stack.push(operator);
                    } else if (operator == ')') {
                        while (!stack.isEmpty() && stack.peek() != '(') {
                            res.append(stack.pop()).append(",");
                        }
                        stack.pop();
                    } else {
                        while (!stack.isEmpty() && operators.containsKey(stack.peek()) && operators.get(stack.peek()) >= operators.get(operator)) {
                            res.append(stack.pop()).append(",");
                        }
                        stack.push(operator);
                    }
                    current++;
                }
                index = current;
            }
            while (!stack.isEmpty()) {
                res.append(stack.pop()).append(",");
            }
            return res.toString();
        }
    }
}