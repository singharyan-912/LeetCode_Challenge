class Solution {
    void bfs(Queue<int[]> q, boolean vis[][], int[][] grid, int m, int n) {
        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && !vis[nr][nc] && grid[nr][nc] == 0) {
                    vis[nr][nc] = true;
                    q.add(new int[] { nr, nc });
                }
            }
        }
    }

    boolean isBoundary(int i, int j, int m, int n) {
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
            return true;
        } else {
            return false;
        }
    }

    public int closedIsland(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;
        boolean vis[][]=new boolean[m][n];
        Queue<int []> q=new LinkedList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isBoundary(i,j,m,n) && !vis[i][j] && grid[i][j]==0){
                  vis[i][j]=true;
                  q.add(new int[]{i,j});
                }
            }
        }
        bfs(q,vis,grid,m,n);
         for(int i=0;i<m;i++){
             for(int j=0;j<n;j++){
                     if(!vis[i][j] && grid[i][j]==0){
                         ans++;
                         vis[i][j]=true;
                         q.add(new int[]{i,j});
                        bfs(q,vis,grid,m,n);
                                                              
         }
    }}
    return ans;
}
}