class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int r = 0, c = n -1;
        while(r < m && c >=0){
            int value = matrix[r][c];
            if(value == target) return true;
            else if(value > target) c--;
            else r++;
        }

        return false;
    }
}