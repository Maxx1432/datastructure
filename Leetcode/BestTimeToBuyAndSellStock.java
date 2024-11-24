package Leetcode;
public class BestTimeToBuyAndSellStock {
    private int maxProfit(int[] prices) {
        int max = 0;
        int min = prices[0];
        for (int price : prices) {
            min = (price < min) ? price : min;
            max = (max > price - min) ? max : price - min;
        }
        return max;
    }
    public static void main(String[] args) {
        BestTimeToBuyAndSellStock obj = new BestTimeToBuyAndSellStock();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(obj.maxProfit(prices));
    }
}
