class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        List<Integer> res = new ArrayList<>();
        int top = 0, bot = m-1;
        int left = 0, right = n - 1;

        while(res.size() < m*n){
            //Top Left -> Move col
            for(int c = left; c <= right && res.size() < m*n; c++) res.add(matrix[top][c]);
            top++;
            //Top Right -> Down row
            for(int r = top; r <= bot && res.size() < m*n; r++) res.add(matrix[r][right]);
            right--;
            //Bottom Right -> Move col 
            for(int c = right; c >= left && res.size() < m*n; c--) res.add(matrix[bot][c]);
            bot--;
            //Bottom Left -> Up Row
            for(int r = bot; r >= top && res.size() < m*n; r--) res.add(matrix[r][left]);
            left++;
        }

        return res;
    }
}
/*
Go through from 
+ top left to top right (move col) end with top++
+ right top to right bot (down row) end with right--
+ right bot to left bot (move col) end with bot--
+ left bot to left top (move top) end with left++

*/