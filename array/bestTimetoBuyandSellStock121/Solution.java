package array.bestTimetoBuyandSellStock121;
/*
In this problem, we basically need to get the maximum profit. We can do this with a single traversal,
where we keep updating the minimum price so far. By doing this, we can calculate and track the maximum
profit as we go.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrices = Integer.MAX_VALUE;

        for(int price : prices){
            if(price < minPrices){
                minPrices = price;
            }
            int profit = price - minPrices;
            if(profit > maxProfit){
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
