class Solution {
    int solve(int [][]grid,int row,int col,int m,int n,int [][]dp){
        int mod=1_000_000_007;
        int totalPath=1;
        if(dp[row][col]!=-1) return dp[row][col];
         if(col + 1<n && grid[row][col]<grid[row][col+1]){
            totalPath=(totalPath+solve(grid,row,col+1,m,n,dp)) % mod;
         }
         if(col - 1>=0 && grid[row][col]<grid[row][col-1]){
              totalPath=(totalPath+solve(grid,row,col-1,m,n,dp)) % mod;
            }
            if(row + 1<m && grid[row][col]<grid[row+1][col]){
                totalPath=(totalPath+solve(grid,row+1,col,m,n,dp)) % mod;
            }
            if(row -1 >=0 && grid[row][col]<grid[row-1][col]){
                totalPath=(totalPath+solve(grid,row -1,col,m,n,dp)) % mod;
            }
        return dp[row][col]=(int) totalPath;                       
         }
    
    public int countPaths(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        long totalPath=0;
        int mod=1_000_000_007;
        int [][]dp=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                totalPath =(totalPath+ solve(grid,i,j,m,n,dp))% mod;
            }
        }
    return (int) totalPath;
    }}
