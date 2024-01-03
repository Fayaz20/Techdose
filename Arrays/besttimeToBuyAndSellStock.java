class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE;
        int op=0;
        int pt=0;
        for(int i=0;i<prices.length;i++)
        {
            if(prices[i]<min){
                min=prices[i];
            }
            pt=prices[i]-min;
            if(op<pt)
            {
                op=pt;
            }
        }
        return op;
        
    }
}
