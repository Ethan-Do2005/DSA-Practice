class Solution {
    private int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
    private int rows,cols;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();

        rows = heights.length;
        cols = heights[0].length;

        boolean[][] pacific = new boolean[rows][cols];
        boolean[][] atlantic = new boolean[rows][cols];

        //Left and Right Side
        for(int i = 0; i < rows; i++){
            dfs(heights, i, 0, pacific, Integer.MIN_VALUE); //Pacific Left Side
            dfs(heights, i, cols-1, atlantic, Integer.MIN_VALUE); //Atlantic Right Side
        }

        //Top and Down Side
        for(int i = 0; i < cols; i++){
            dfs(heights, 0, i, pacific, Integer.MIN_VALUE ); //Pacific Up Side
            dfs(heights, rows - 1, i, atlantic, Integer.MIN_VALUE); //Atlantic Down Side
        }

        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                if(pacific[r][c] && atlantic[r][c]){
                    result.add(Arrays.asList(r,c));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited, int prevHeight){
        if(row < 0 || row >= rows || col < 0 || col >= cols){
            return;
        }

        if(visited[row][col] || heights[row][col] < prevHeight){
            return;
        }

        visited[row][col] = true;

        for(int[] dir : directions){
            dfs(heights, row + dir[0], col + dir[1], visited, heights[row][col]);
        }


    }
}
/*
what is the range length ?
row >= 1 
col <= 200

For one cell is heights(2,2) value 5 
go from pacific ocean
example from (2,0) -> (2,1) -> (2,2) and mark (2,2) as true

Time and Space complexity: O(nlogn)

*/