class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int result = 0;

        while(sell < prices.length){
            if(prices[sell] < prices[buy]){
                buy = sell;
            }

            result = Math.max(result, prices[sell] - prices[buy]);
            sell++;
        }

        return result;
    }
}
/*

O(n) time complexity and O(1) space complexity
[7,1,5,3,6,4]
0 <= 6

7 <= 7 
i++ => i = 1 ; j = 1




output: 5 
price 1 on day 2 and get the price 6 on day 5 and get subtract : 6 - 1 = 5 

Contain negative numbers
Yes
[] 1 to 10^5 

2 approach
Approach A: brute force

Approach B: 2 pointers
int buy and sell
sell > buy 

[7,1,5,3,6,4]
sell = 1;
buy = 0;

prices[sell]= 1
prices[buy] = 7
1 < 7 




*/