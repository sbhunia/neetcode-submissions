class Solution {
    List<Integer>[] neighbors;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length!=n-1)
            return false;
        neighbors = new ArrayList[n];
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            neighbors[i] = new ArrayList<Integer>();
            visited[i]=false;
        }
        for(int i=0; i<edges.length; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            neighbors[a].add(b);
            neighbors[b].add(a);
        }
        if(!dfs(0, -1, visited))
            return false;
        for(int i=0; i<n; i++)
            if(!visited[i])
                return false;
        return true;
    }
    boolean dfs(int v, int parent, boolean[] visited){
        if(visited[v])
            return false;
        visited[v]=true;
        for(int neighbor: neighbors[v]){
            if(neighbor!=parent)
                if(!dfs(neighbor, v, visited))
                    return false;
        }
        return true;            
    }

}
