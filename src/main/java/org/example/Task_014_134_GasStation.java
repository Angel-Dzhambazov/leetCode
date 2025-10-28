package org.example;

public class Task_014_134_GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(canCompleteCircuitOn2(gas, cost) >= 0);
    }

    private static int canCompleteCircuitOn2(int[] gas, int[] cost) {
        int n = gas.length;

        for (int start = 0; start < n; start++) {
            int tank = 0;
            int traveled = 0; // number of stops

            // try to simulate starting from 'start'
            while (traveled < n) {
                int current = (start + traveled) % n;
                tank += gas[current] - cost[current];
                if (tank < 0) {
                    break; // failed, can't move further
                }
                traveled++;
            }

            if (traveled == n) {
                return start; // we made it all the way
            }
        }

        return -1; // no valid start
    }

    private static int canCompleteCircuitOn(int[] gas, int[] cost) {
        int totalTank = 0;
        int currenTank = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            int gasGain = gas[i] - cost[i];
            totalTank += gasGain;
            currenTank += gasGain;

            if (currenTank < 0) {
                start = i + 1;
                currenTank = 0;
            }

        }
        return totalTank >= 0 ? start : -1;
    }
}
