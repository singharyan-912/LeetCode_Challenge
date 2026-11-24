class Solution {
    int solve(int [][]num,int m,int n,int r,int c,int [][]dp){
        if(r>=m || c>=n ) return Integer.MAX_VALUE;
        if(r==m-1 && c==n-1) return Math.max(1,1-num[r][c]);
        if(dp[r][c]!=-1) return dp[r][c];
        int right=solve(num,m,n,r+1,c,dp);
        int down=solve(num,m,n,r,c+1,dp);
        int minhp=Math.min(down,right);
        int hpneed=minhp-num[r][c];
        return dp[r][c]=Math.max(1,hpneed);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int m=dungeon.length;
        int n=dungeon[0].length;
        int [][]dp=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(dungeon,m,n,0,0,dp);
    }
}