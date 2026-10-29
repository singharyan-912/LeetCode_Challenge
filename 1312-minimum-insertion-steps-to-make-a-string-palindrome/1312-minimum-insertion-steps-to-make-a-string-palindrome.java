class Solution {
    public int minInsertions(String s) {
        int m=s.length();
        int [][]dp=new int[m+1][m+1];
        int count=0;
        for(int i=m-1;i>=0;i--){
           for(int j=i;j<m;j++){
            if(i>=j) {
                dp[i][j]=0;
                continue;
            }
          char a=s.charAt(i);
         char c=s.charAt(j);
         if(a==c){
            dp[i][j]=dp[i+1][j-1];
         }else{
            dp[i][j]=1+ Math.min(dp[i+1][j],dp[i][j-1]);
         }

           }
        }
        return dp[0][m-1];
    }
}