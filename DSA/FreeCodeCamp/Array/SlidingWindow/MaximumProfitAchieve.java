package FreeCodeCamp.Array.SlidingWindow;

public class MaximumProfitAchieve {
    public static int maximumProfit(int[] price){
        int buy=price[0],sell=0,profit=0;
        for(int i=0;i<price.length;i++){
            int n=price[i];
            buy=Math.min(buy,n);
            sell=n-buy;
            profit=Math.max(profit,sell);
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] price={7,1,5,3,6,4,9};
        System.out.println(maximumProfit(price));
    }
}
