class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, r = 0;
        int max = 0;
        
        while(r < prices.length){
            if(prices[l] < prices[r]){
                max = Math.max(prices[r] - prices[l], max);
            }else{
                l = r;
            }
            r++;
        }

        return max;
    }
}
/*
Pseudocode:
l = 0, r = 1
int max
while (l < r){
    if(prices[l] < prices[r]){
        max = Math.max(max, prices[r] - prices[l])
    }else{
        l = r;
    }
    r++;
}
*/