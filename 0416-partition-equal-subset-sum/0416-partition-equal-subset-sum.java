class Solution {
    boolean solve(int []nums,int n,int target,int i,Boolean [][]dp){
        if(i>=n  || target<0) return false;
        if(target==0) return true;
        if(dp[i][target]!=null) return dp[i][target];
        boolean take=false;
        if(nums[i]<=target){
            take=solve(nums,n,target-nums[i],i+1,dp);
        }
        boolean skip=solve(nums,n,target,i+1,dp);
        return dp[i][target]=take||skip;
    }
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int ts=0;
       
        for(int i=0;i<n;i++){
            ts+=nums[i];
        }
        if(ts%2!=0){
            return false;
        }
        int target=ts/2;
         Boolean [][]dp=new Boolean[n+1][target+1];
        return solve(nums,n,target,0,dp);
    }
}