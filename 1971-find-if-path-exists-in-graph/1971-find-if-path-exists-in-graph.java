class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination){
            return true;
        }
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []edge:edges){
            int from=edge[0];
            int to=edge[1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        Queue<Integer> q=new LinkedList<>();
        boolean vis[]=new boolean[n];
        q.add(source);
        vis[source]=true;
        while(!q.isEmpty()){
            int temp=q.poll();
            for(int i=0;i<adj.get(temp).size();i++){
                int neigh=adj.get(temp).get(i);
                if(neigh==destination){
                    return true;
                }
                if(!vis[neigh]){
                q.add(neigh);
                vis[neigh]=true;
            }
            }
        }
        return false;
    }
}