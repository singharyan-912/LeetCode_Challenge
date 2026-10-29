class Solution {
    int solve(String s,int left,int right,int [][]dp){
        if(left>=right) return 0;
        int count=0;
        char a=s.charAt(left);
        char c=s.charAt(right);
        if(dp[left][right]!=-1) return dp[left][right];
        if(a==c){
          count=  solve(s,left+1,right-1,dp);
        }else{
        count=1+ Math.min(solve(s,left+1,right,dp),solve(s,left,right-1,dp));
        }
        return dp[left][right]=count;
    }
    public int minInsertions(String s) {
        int m=s.length();
        int [][]dp=new int[m][m];
        for(int i=0;i<m;i++){
           Arrays.fill(dp[i],-1);
        }
        return solve(s,0,m-1,dp);
    }
}