class Solution {
    int solve(String text1, String text2,int m,int n,int [][]dp){
        if(m<0 || n<0) return 0;
        if(dp[m][n]!=-1) return dp[m][n];
        int lcs=0;
        char c=text1.charAt(m);
        char a=text2.charAt(n);
           if(c==a){
            lcs= 1+ solve(text1,text2,m-1,n-1,dp);
           }else{
            lcs=Math.max(solve(text1,text2,m-1,n,dp),solve(text1,text2,m,n-1,dp));
           }
         return dp[m][n]=lcs;
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        int [][]dp=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(text1,text2,m-1,n-1,dp);
    }
}