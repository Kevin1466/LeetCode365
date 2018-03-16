package LeetCoding.march.eighth;

/**
 * https://leetcode.com/problems/min-cost-climbing-stairs/description/
 * @author rgk
 *
 */
public class MinCostClimbingStairs {

	public static void main(String[] args) {
		System.out.println(minCostClimbingStairs(new int[] {10,15,20}));
		System.out.println(minCostClimbingStairs(new int[] {1,100,1,1,1,100,1,1,100,1}));
	}
    
	public static int minCostClimbingStairs(int[] cost) {
		/*int f1 = 0, f2 = 0;
		for (int i = cost.length - 1; i>=0; i--) {
			int f0 = cost[i] + Math.min(f1, f2);
			f2 = f1;
			f1 = f0;
		}
        return Math.min(f1, f2);*/
        
        for(int i=2;i<=cost.length-1;i++){
            cost[i]=cost[i]+Math.min(cost[i-1],cost[i-2]);
        }

        return Math.min(cost[cost.length-1],cost[cost.length-2]);

    }
}
