class Solution {
    boolean solve(String s, String t,int m,int n,Boolean [][]dp){
       if(m<0) return true;
       if(n<0) return false;
       if(dp[m][n]!=null){
        return dp[m][n];
       }
      char c=s.charAt(m);
     char a=t.charAt(n);
       if(c==a){
        return solve(s,t,m-1,n-1,dp);
       }else{
        return solve(s,t,m,n-1,dp);
       }
      
    }
    public boolean isSubsequence(String s, String t) {
        int m=s.length();
        int n=t.length();
        Boolean [][]dp=new Boolean[m][n];
        return solve(s,t,m-1,n-1,dp);
    }
}