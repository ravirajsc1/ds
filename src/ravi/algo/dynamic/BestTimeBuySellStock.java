package ravi.algo.dynamic;
/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
Constraints:
1 <= prices.length <= 105
0 <= prices[i] <= 104
 */
public class BestTimeBuySellStock {

    public static void main(String[] args) {
        int[] stockPrice= new int[]{7,1,5,3,6,4};
        int[] stockPric2= new int[]{7,6,4,3,1};
        BestTimeBuySellStock bestTimeBuySellStock=new BestTimeBuySellStock();
        System.out.println("Caluclate Profit "+bestTimeBuySellStock.calculateMaxProfit(stockPrice));
        System.out.println("Caluclate Profit "+bestTimeBuySellStock.calculateMaxProfit(stockPric2));
        System.out.println("Caluclate Profit Dynamic "+bestTimeBuySellStock.calculateMaxProfitDynamic(stockPrice));
        System.out.println("Caluclate Profit Dynamic "+bestTimeBuySellStock.calculateMaxProfitDynamic(stockPric2));
    }

    public int calculateMaxProfit(int[] stockPrice) {
        int profit=0;
        for(int i=0;i<stockPrice.length;i++){
            for(int j=i+1;j<stockPrice.length;j++){
                int tempProfit=stockPrice[j]-stockPrice[i];
                if(profit<tempProfit){
                    profit=tempProfit;

                }
            }
        }

        return profit;
    }

    public int calculateMaxProfitDynamic(int[] stockPrice) {
        int profit=0;
        int min=stockPrice[0];

        for(int i=1;i<stockPrice.length;i++){
            if(stockPrice[i]<min){
                min=stockPrice[i];
            }else{
                profit=Math.max(profit,stockPrice[i]-min);
            }
        }

        return profit;
    }

}
