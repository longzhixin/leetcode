package code.leetcode;

public class Leetcode746MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int[] profits = new int[cost.length];
        profits[0] = cost[0];
        profits[1] = cost[1];

        for(int i = 2; i < cost.length; i ++) {
            profits[i] = Math.min(profits[i-1]+cost[i], profits[i-2]+cost[i]);
        }
        return Math.min(profits[cost.length-1], profits[cost.length-2]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        int oneStair = cost[0];
        int twoStair =cost[1];

        for(int i = 2; i < cost.length; i ++) {
           int profits = cost[i] + Math.min(oneStair, twoStair);
           oneStair = twoStair;
           twoStair = profits;

        }
        return Math.min(oneStair, twoStair);
    }
    public static void main(String[] args) {
        int result = new Leetcode746MinCostClimbingStairs().minCostClimbingStairs2(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
        System.out.println(result);
        int result2 = new Leetcode746MinCostClimbingStairs().minCostClimbingStairs2(new int[]{10,15,20});
        System.out.println(result2);
      }
}
