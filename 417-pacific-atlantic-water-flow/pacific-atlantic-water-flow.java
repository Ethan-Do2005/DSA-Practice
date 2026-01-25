class Solution {
    List<List<Integer>> result;
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    int rows, cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        result = new ArrayList<>();
        rows = heights.length;
        cols = heights[0].length;

        boolean[][] checkPacific = new boolean[rows][cols];
        boolean[][] checkAtlantic = new boolean[rows][cols];

        //Left and Right Side
        for(int r = 0; r < rows; r++){
            dfs(heights, r, 0, checkPacific, 0); // Pacific check
            dfs(heights, r, cols - 1, checkAtlantic, 0); // Atlantic check
        }

        //Top and Bot
        for(int c = 0; c < cols; c++){
            dfs(heights, 0, c, checkPacific, 0);
            dfs(heights, rows - 1, c, checkAtlantic, 0);
        }

        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                if(checkPacific[row][col] && checkAtlantic[row][col]){
                    result.add(Arrays.asList(row, col));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight){
        if(r < 0 || r >= rows || c < 0 || c >= cols){
            return;
        }

        if(visited[r][c] || heights[r][c] < prevHeight){
            return;
        }

        visited[r][c] = true;
        for(int[] dir : directions){
            dfs(heights, r + dir[0], c + dir[1], visited, heights[r][c]);
        }
    }
}