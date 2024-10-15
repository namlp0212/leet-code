package top_150_interview;

public class N_Complete_Circuit {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int totalTank = 0;
        int currTank = 0;
        int startStation = 0;

        for (int i = 0; i < len; i++) {
            totalTank += gas[i] - cost[i];
            currTank += gas[i] - cost[i];

            if (currTank < 0) {
                startStation = i + 1;
                currTank = 0;
            }
        }

        return totalTank >= 0 ? startStation : -1;
    }

    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
}
