class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids == null || asteroids.length == 0) return null;
        Stack<Integer> stack = new Stack<>();
        stack.push(asteroids[asteroids.length - 1]);
        int i = asteroids.length - 2;
        while(i >= 0){
            if(stack.isEmpty() || (stack.peek() > 0 && asteroids[i] < 0) || samesign(stack.peek(), asteroids[i])){
                stack.push(asteroids[i--]);
            }
            else{
                while(!stack.isEmpty() && i >= 0 && stack.peek() < 0 && asteroids[i] > 0){
                    if(Math.abs(stack.peek()) == Math.abs(asteroids[i])){
                        stack.pop();
                        i--;
                    }else if(Math.abs(stack.peek()) < Math.abs(asteroids[i])){
                        stack.pop();
                    }else i--;
                }
            }
        }
        int[] res = new int[stack.size()];
        i = 0;
        while(!stack.isEmpty()) res[i++] = stack.pop();
        return res;
    }
    public boolean samesign(int a, int b){
        if((a > 0 && b < 0) || (a < 0 && b > 0)) return false;
        else return true;
    }
    
}