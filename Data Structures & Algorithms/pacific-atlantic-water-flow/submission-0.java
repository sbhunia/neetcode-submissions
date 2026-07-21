class Solution {
    int[][] heights;
    int row;
    int col;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.heights=heights;
        this.row=heights.length;
        this.col=heights[0].length;
        int[][] pacific = new int[row][col];
        int[][] atlantic = new int[row][col];
        for(int r=0; r<row; r++)
            for(int c=0; c<col; c++){
                pacific[r][c]=0;
                atlantic[r][c]=0;
            }

        for(int r=0; r<row; r++ ){
            dfs(r,0, pacific);
            dfs(r, col-1, atlantic);
        }
        for(int c=0; c<col; c++){
            dfs(0,c, pacific);
            dfs(row-1, c, atlantic);
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for(int r=0; r<row; r++)
            for(int c=0; c<col; c++)
                if(pacific[r][c]==1 && atlantic[r][c]==1){
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(r);
                    cell.add(c);
                    result.add(cell);
                }
        return result;
    }
    void dfs(int r, int c, int[][] ocean){
        if(ocean[r][c]==1) // already visited
            return;
        ocean[r][c]=1;//make it visited
        if(r-1>=0)
            if(heights[r-1][c]>=heights[r][c])
                dfs(r-1, c, ocean);
        if(r+1<row)
            if(heights[r+1][c]>=heights[r][c])
                dfs(r+1, c, ocean);
        if(c-1>=0)
            if(heights[r][c-1]>=heights[r][c])
                dfs(r, c-1, ocean);
        if(c+1<col)
            if(heights[r][c+1]>=heights[r][c])
                dfs(r, c+1, ocean);
    }
}
