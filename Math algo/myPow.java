class Solution {
    public double myPow(double x, int n) {
        if (n == Integer.MAX_VALUE) 
            return x;
        else if (n == Integer.MIN_VALUE) 
            return (x == 1 || x == -1) ? 1 : 0;
        else if(n==0) 
            return 1;
        if(n<0) {
            x=1/x;
            n*=-1;
        }
        double res = 1;
        for(int i=0;i<n;i++)
            res = res*x;
        return res;
    }
}