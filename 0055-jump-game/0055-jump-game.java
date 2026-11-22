class Solution {
    public boolean solve(int [] nums,int i,Boolean []dp){
       if(i>=nums.length - 1) return true;
       if(dp[i]!=null){
      return dp[i];
       } 
       int maxjump=nums[i];
       for(int step=1;step<=maxjump;step++){
       if(solve(nums,i+step,dp)){
      return dp[i]=true;
       }
       }
       return dp[i]=false;
    }
    public boolean canJump(int[] nums) {
        Boolean []dp=new Boolean[nums.length];
        return solve(nums,0,dp);
    }
}