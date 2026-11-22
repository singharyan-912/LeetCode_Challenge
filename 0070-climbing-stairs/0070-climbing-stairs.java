class Solution {
    int solve(int n,int []dp,int i){
        if(i>=n) return 1;
       if(dp[i]!=-1) return dp[i];
       int one=solve(n,dp,i+1);
       int two=0;
       if(i<=n-2){
        two=solve(n,dp,i+2);
       }
       return dp[i]= one+ two;
    }
    public int climbStairs(int n) {
        int []dp=new int[n+1];
        Arrays.fill(dp,-1);
        return solve(n,dp,0);
    }
}