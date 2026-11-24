class Solution {
    int solve(int [][]grid,int row,int col,int m,int n,int [][]dp){
        if(row>=m || col>=n) return Integer.MAX_VALUE;
       if(row==m-1 && col==n-1) return grid[row][col];
       if(dp[row][col]!=-1) return dp[row][col];

     int right= solve(grid,row,col+1,m,n,dp);
     int down= solve(grid,row+1,col,m,n,dp);
    
    
    
      return dp[row][col]=grid[row][col]  + Math.min(right,down);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
      int dp[][]=new int[m+1][n+1];
      for(int i=0;i<=m;i++){
        Arrays.fill(dp[i],-1);
      }
        return solve(grid,0,0,m,n,dp);
    }
}