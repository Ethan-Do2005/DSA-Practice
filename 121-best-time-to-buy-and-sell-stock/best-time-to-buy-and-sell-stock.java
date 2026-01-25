class Solution {
    public int maxProfit(int[] prices) {
        int sell = 0;
        int buy = 0;
        int maxProfit = 0;

        while(sell < prices.length){
            if(prices[buy] > prices[sell]){
                buy = sell;
            }
            maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            sell++;
        }

        return maxProfit;
    }
}
/*
Using two pointer
sell > buy => buy index is always small or equal to sell
*/