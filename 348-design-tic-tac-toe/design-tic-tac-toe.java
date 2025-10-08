class TicTacToe {
    int n;
    int[] rows, cols;
    int diag = 0, anti =0;
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[n];
        cols = new int[n];
    }
    
    public int move(int row, int col, int player) {
        int add = (player == 1) ? 1 : -1;

        rows[row] += add;
        cols[col] += add;

        if(row == col) diag +=add;
        if(row + col == n - 1) anti += add;

        if(Math.abs(rows[row]) == n  || Math.abs(cols[col]) == n || 
            Math.abs(anti) == n || Math.abs(diag) == n){
                return player;
            }
            return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */