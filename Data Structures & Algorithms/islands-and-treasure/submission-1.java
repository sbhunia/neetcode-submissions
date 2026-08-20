class Solution {
    int[][] grid;
    int ROW,COL;
    static final int INF = 2147483647;
    ArrayDeque<int[]> queue = new ArrayDeque<>();


    public void islandsAndTreasure(int[][] grid) {
        this.grid=grid;
        this.ROW=grid.length;
        this.COL=grid[0].length;

        for(int r=0; r<ROW; r++)
            for(int c=0; c<COL; c++)
                if(grid[r][c]==0)
                    queue.addLast(new int[]{r,c});
        bfs();
    }
    void changeDistance(int r, int c, int proposedDistance){
        if(r<0 || r>= ROW || c<0 || c>=COL) // invalid cell
            return;
        if(grid[r][c] == -1)
            return; // don't touch water
        if(grid[r][c] > proposedDistance){
            grid[r][c] = proposedDistance;
            queue.addLast(new int[]{r,c});
        }
    }
    void bfs(){
        while(!queue.isEmpty()){
            int[] cell = queue.removeFirst();
            int r = cell[0];
            int c = cell[1];
            if(grid[r][c]!=-1){ // if water cell, don't do anything
                changeDistance(r-1,c, grid[r][c]+1);
                changeDistance(r+1,c, grid[r][c]+1);
                changeDistance(r,c-1, grid[r][c]+1);
                changeDistance(r,c+1, grid[r][c]+1);
            }
        }



    }

}
