class Solution {
    private static final int INF = 1_000_000_000;
    int solve(int [][] num,int m,int n,int r,int c,Integer [][]dp){
        if( c<0 || c>=n) return INF;
        if(r==m-1) return num[r][c];
        if(dp[r][c]!=null) return dp[r][c];
      int down=solve(num,m,n,r+1,c,dp);
      int dl=solve(num,m,n,r+1,c-1,dp);
      int dr=solve(num,m,n,r+1,c+1,dp);
      return dp[r][c]=num[r][c]+Math.min(down,Math.min(dl,dr));
    }
    public int minFallingPathSum(int[][] matrix) { 
        int m=matrix.length;
        int n=matrix[0].length;
        Integer [][]dp=new Integer[m][n];
        int minsum=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minsum=Math.min(minsum,solve(matrix,m,n,0,i,dp));
        }
        return minsum;
    }
}