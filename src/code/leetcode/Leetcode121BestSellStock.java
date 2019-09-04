package code.leetcode;

public class Leetcode121BestSellStock {

    public  int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minProfit = prices[0];
        for(int i= 0; i< prices.length; i++) {
            if (minProfit > prices[i]) {
                minProfit = prices[i];
            }
            if (prices[i] - minProfit > maxProfit) {
                maxProfit = prices[i] - minProfit;
                }
            }
        return maxProfit;
    }
    public  static void main(String[] args) {
        System.out.println(new Leetcode121BestSellStock().maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
