class Solution {
    List<Integer>[] graph ;
    boolean[] visited;


    public int countComponents(int n, int[][] edges) {
        graph =  new ArrayList[n];
        visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<Integer>();
            visited[i] = false;
        }
        for(int[] edge: edges){
            int a = edge[0];
            int b = edge[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        int islands = 0;
        for(int i=0; i<n; i++){
            if(!visited[i]){
                islands++;
                dfs(i);
            }   
        }
        return islands;

    }
    void dfs(int v){
            if(visited[v])
                return;
            visited[v] = true;
            for(int neighbor: graph[v])
                dfs(neighbor);
        }
}
