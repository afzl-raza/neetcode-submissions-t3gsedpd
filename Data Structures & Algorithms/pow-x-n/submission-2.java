class Solution {
    public double myPow(double x, long n) {
        if(n==0) return 1;
        if(n==1) return x;
        long N = n;
        if(n<0){
            N = -n;  
        }
        double ans=0;
        if(n%2==0){
            double half = myPow(x,N/2);
            ans = (half*half);
            }
        else{
            double half = myPow(x,N/2);
            ans = (x*half*half);
        }
        return (n>=0)?ans:1/ans;
    }
}
