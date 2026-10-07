class Solution {
    // O(n^2)
    public int canCompleteCircuitBruteForce(int[] gas, int[] cost) {
        int n = gas.length;

        for (int i = 0; i < n; i++) {        // try each starting station
            int reserve = 0;
            int idx = i;                      // current station
            boolean ok = true;
            
            // using while is more confusing I guess, just make sure
            // it visits all n station, that's when it goes back
            for (int step = 0; step < n; step++) {   // visit n stations
                reserve += gas[idx] - cost[idx];
                if (reserve < 0) {
                    ok = false;
                    break;
                }
                // math wisdom
                idx = (idx + 1) % n;          // wrap around the circle
            }

            if (ok) {
                return i;
            }
        }
        return -1;
    }

    // O(n)
    public int canCompleteCircuitGreedyMethod(int[] gas, int[] cost) {
        int total = 0;   // net gas over the whole circle
        int tank = 0;    // gas since the current candidate start
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            if (tank < 0) {          // can't reach station i+1 from start
                start = i + 1;       // so try starting after i
                tank = 0;
            }
        }
        return total < 0 ? -1 : start;
    }
}