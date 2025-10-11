class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int r = 0, c = 0;
        boolean up = true;
        int k = 0;
        int[] res = new int[m*n];
        
        while(k < m*n){
            res[k++] = mat[r][c];
            if(up){
                //Case reching right (first): Down row;
                if(c == n-1){r++; up = false;}
                //Case reaching top (Second): Move col;
                else if(r == 0){c++; up = false;}
                //Other Case: moving diag
                else{r--; c++;}
            }else{
                //Case reaching bot (first): Move col
                if(r == m - 1){c++; up = true;}
                //Case reaching left (second): Down row
                else if(c == 0){r++; up = true;}
                // Other Case: moving diag
                else{r++; c--;}
            }
        }

        return res;
    }
}