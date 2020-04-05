/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
*/

class Solution {
    public int maxProfit(int[] prices) {
        if (null == prices || 0 == prices.length) {
            return 0;
        }
        
        int i = 0;
        int maxProfit = 0;
        int length = prices.length;
        
        while (i < length - 1) {
            while (i < length - 1 && prices[i] >= prices[i+1]) {
                i++;
            }
            
            int valley = prices[i];
            
            while (i < length - 1 && prices[i] <= prices[i+1]) {
                i++;
            }
            
            int peek = prices[i];
            
            maxProfit += peek - valley;
        }
        
        return maxProfit;
    }
}