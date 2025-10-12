class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m  = matrix.length, n = matrix[0].length;

        List<Integer> res = new ArrayList<>();

        int top = 0, bot = m-1;
        int left = 0, right = n-1;

        while(res.size() < m*n){
            //TOP: LEFT -> RIGHT
            for(int c = left; c <= right && res.size() < m*n; c++) {res.add(matrix[top][c]);}
            top++;
            //RIGHT: TOP TO BOT
            for(int r = top; r <= bot && res.size() < m*n; r++) {res.add(matrix[r][right]);}
            right--;
            //BOT: RIGHT TO LEFT
            for(int c = right; c >= left && res.size() < m*n; c--){res.add(matrix[bot][c]);}
            bot--;
            //Left -> BOT TO TOP
            for(int r = bot; r >= top && res.size() < m*n; r--){res.add(matrix[r][left]);}
            left++;
        }

        return res;
    }
}