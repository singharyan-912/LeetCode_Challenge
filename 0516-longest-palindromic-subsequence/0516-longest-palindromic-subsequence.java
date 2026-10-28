class Solution {
    int solve(String a,int left,int right,int [][]dp){
        if(left> right) return 0;
        if(left==right) return 1;
     
      int lps=0;
      if(dp[left][right]!=-1) return dp[left][right];
    
        if(a.charAt(left)==a.charAt(right)){
            lps= 2+solve(a,left+1,right-1,dp);
        }else{
           lps= Math.max(solve(a,left+1,right,dp),solve(a,left,right-1,dp));
        }
   return dp[left][right]=lps;
    }
    public int longestPalindromeSubseq(String s) {
        int m=s.length();
        int [][]dp=new int[m][m];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s,0,m-1,dp);
    }
}