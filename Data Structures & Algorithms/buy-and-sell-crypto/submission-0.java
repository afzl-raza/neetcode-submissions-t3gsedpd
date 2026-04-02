class Solution {
    public int maxProfit(int[] prices) {
        int min_price_so_far = prices[0];
        int max_profit = 0;
        for (int price:prices){
            min_price_so_far = Math.min(min_price_so_far,price);
            int curr_profit = price-min_price_so_far;
            max_profit = Math.max(curr_profit,max_profit);
        }
        return max_profit;

        
    }
}
