class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        car[] c = new car[position.length];
        for (int i = 0; i < position.length; ++i)
            c[i] = new car(position[i], (double) (target - position[i]) / speed[i]);
        Arrays.sort(c, (a, b) -> Integer.compare(a.position, b.position));

        int ans = 0, t = position.length;
        while (--t > 0) {
            if (c[t].time < c[t-1].time) ans++; //if cars[t] arrives sooner, it can't be caught
            else c[t-1] = c[t]; //else, cars[t-1] arrives at same time as cars[t]
        }

        return ans + (t == 0 ? 1 : 0); //lone car is fleet (if it exists)
    }
    
class car{
    int position;
    double time;
    car(int p, double t){
        position = p;
        time = t;
    }
}
}