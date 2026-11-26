class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean vis[]=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int temp=q.poll();
            for(int i=0;i<rooms.get(temp).size();i++){
                int neigh=rooms.get(temp).get(i);
                if(vis[neigh]==false){
                     vis[neigh]=true;
                    q.add(neigh);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                return false;
            }
        }
        return true;
    }
}