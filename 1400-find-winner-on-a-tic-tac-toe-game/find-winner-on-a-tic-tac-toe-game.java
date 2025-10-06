class Solution {
    public String tictactoe(int[][] moves) {
        int k = 3;
        int row[] = new int[k]; 
        int col[] = new int[k];

        int diag = 0; int anti = 0;
        int turn = 1; //A or B player

        for(int[] mv : moves){
            int r = mv[0]; int c = mv[1];
            row[r] += turn;
            col[c] += turn;

            if(r == c) diag += turn;
            if(r + c == k -1) anti += turn;
            if(Math.abs(row[r]) == k || Math.abs(col[c]) == k || Math.abs(diag) == k || Math.abs(anti) == k){
                return (turn == 1) ? "A" : "B";
            }
            turn = -turn;
        }

        return (moves.length == k*k) ? "Draw" : "Pending";
    }
}
/*
Check for 
row[], col[]
diag ; anti-diag

for loop
    r - first value, c - second value
    row[r] += turn; col[c] += turn;
    if(r == c ) diag += 1;
    if(r + c == k - 1) anti +=1;
    if(Math.abs(4 conditions))
        return if turn = 1 A then B
    
    return if move.length == k *k Draw then Pending
*/