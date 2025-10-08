class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    IsLand(grid, i,j);
                    count++;
                }
            }
        }

        return count;
    }

    private void IsLand(char[][] grid, int r, int c){
        if(r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] =='0'){
            return;
        }

        grid[r][c] = '0';

        IsLand(grid, r + 1, c);
        IsLand(grid, r - 1, c);
        IsLand(grid, r, c + 1);
        IsLand(grid, r, c - 1);
    }
}
/*
My idea:
main method:
nested loop to check satisfy of '1'

helper method (private void method):
base case 

if condition (to check unsatify cases)

go through 4 directions;

*/