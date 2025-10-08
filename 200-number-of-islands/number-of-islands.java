class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    isLand(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void isLand(char[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == '0'){
            return;
        }

        grid[r][c] = '0';

        isLand(grid, r + 1, c);
        isLand(grid, r - 1, c);
        isLand(grid, r, c + 1);
        isLand(grid, r, c - 1);
    }
}
/*
My idea:
using nested loop:

Using helper method to check 4 directions
*/