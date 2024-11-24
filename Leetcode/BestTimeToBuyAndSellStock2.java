package Leetcode;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i < prices.length -1; i++){
            if(prices[i + 1] > prices[i])
                maxProfit += (prices[i + 1] - prices[i]);
        }

        return maxProfit;
    }
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock2 obj = new BestTimeToBuyAndSellStock2();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(obj.maxProfit(prices));
    }
}
