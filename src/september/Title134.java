package src.september;

import java.util.Arrays;

public class Title134 {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(
                new int[] {2,3,4},
                new int[] {3,4,3}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int startStationIndex;
        for (int index = 0; index < gas.length; index++) {
            if (gas[index] < cost[index]) continue;
            startStationIndex = index;
            int current = gas[index];
            int willCost = cost[startStationIndex];
            while (current >= willCost) {
                startStationIndex = ++startStationIndex % gas.length;
                if (index == startStationIndex) return index;
                current -= willCost;
                current += gas[startStationIndex];
                willCost = cost[startStationIndex];
            }
        }
        return -1;
    }
}
