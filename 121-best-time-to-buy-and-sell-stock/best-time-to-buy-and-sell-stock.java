class Solution {
    public int maxProfit(int[] prices) {
        int i = 0; 
        int j = 1;
        int max = 0;

      while(j < prices.length){
        if(prices[j] < prices[i]){
            i=j;
            continue;
        }
        
        max = Math.max(max, prices[j] - prices[i]);
        j++;
      }  

      return max;
    }
}
/*
sell > buy
j > i 
*/