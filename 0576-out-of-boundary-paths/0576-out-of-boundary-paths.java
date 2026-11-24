class Solution {
    private  final int mod= 1000000007;
    int solve(int m, int n, int mm, int r, int c,int [][][]dp){
        if(r>=m || r<0 || c>=n || c<0) return 1;
       if(mm==0) return 0;
       if(dp[r][c][mm]!=-1) return dp[r][c][mm];
         int down=solve(m,n,mm-1,r+1,c,dp);
         int up=solve(m,n,mm-1,r-1,c,dp);
         int left=solve(m,n,mm-1,r,c-1,dp);
         int right=solve(m,n,mm-1,r,c+1,dp);
         int ans=((down+up)% mod+(left+right)%mod)%mod;
         return dp[r][c][mm]=ans;
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int [][][] dp=new int[m+1][n+1][maxMove+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(m,n,maxMove,startRow,startColumn,dp);
    }
}