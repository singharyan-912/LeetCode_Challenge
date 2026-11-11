class Solution {
    int solve(String s,String t,int i,int j,int m,int n,int [][]dp){
        if(i>=m){
            return n-j;
        }
        if(j>=n){
            return m-i;
        }
        if(dp[i][j]!=-1) return dp[i][j];
       char a=s.charAt(i);
       char c=t.charAt(j);
       if(a==c){
        return dp[i][j]=solve(s,t,i+1,j+1,m,n,dp);
       }
       int insert=solve(s,t,i,j+1,m,n,dp);
       int delete=solve(s,t,i+1,j,m,n,dp);
       int replace=solve(s,t,i+1,j+1,m,n,dp);
       return dp[i][j]=1+Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(word1,word2,0,0,m,n,dp);
    }
}