class Solution {
    public int solve(int []cost,int i,int [] dp){
        if(i>=cost.length){
       return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int takeOne=cost[i] +solve(cost,i+1,dp);
        int takeTwo=cost[i]+solve(cost,i+2,dp);
        return dp[i]= Math.min(takeOne,takeTwo);
    }
    public int minCostClimbingStairs(int[] cost) {
        int dp[]=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(solve(cost,0,dp),solve(cost,1,dp));
    }
}