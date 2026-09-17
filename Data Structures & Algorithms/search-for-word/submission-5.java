class Solution {
    char[][] board;
    String word;
    Set<List<Integer>> visited = new HashSet<>();
    public boolean exist(char[][] board, String word) {
        this.board=board;
        this.word=word;
        for(int r =0; r< board.length; r++)
            for(int c = 0; c<board[0].length; c++) 
                if(dfs (r,c, 0)) // if DFS succesful then return true
                    return true;
        return false;
    }
    boolean dfs(int r, int c, int index){
        if(index==word.length())// that mean DFS reached the end of string
            return true;
        if(r<0 || r>=board.length)
            return false;
        if(c<0 || c>= board[0].length)
            return false;
        if(board[r][c]!=word.charAt(index)) // worng character match
            return false;
        List<Integer> cell = new ArrayList<>();
        cell.add(r);
        cell.add(c);
        if(visited.contains(cell)) // this cell is already visited
            return false;
        visited.add(cell); // otherwise mark this cell as visited
        
        boolean result = false;
        result = result || dfs(r-1, c, index+1);
        result = result || dfs(r+1, c, index+1);
        result = result || dfs(r, c-1, index+1);
        result = result || dfs(r, c+1, index+1);
        visited.remove(cell);
        return result;
    }
}
