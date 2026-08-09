package ravi.algo.concepts;

import java.util.*;


class TicTacToe {

    int[] rows;
    int[] cols;
    int diag;
    int antiDaig;
    Set<String> visted;
    int n;

    public TicTacToe(int n) {
        this.rows=new int[n];
        this.cols=new int[n];
        this.visted=new HashSet<>();
        this.n=n;
    }

    // move will be used to play a move by a specific player and identify who
    // wins at each move
    public int move(int row, int col, int player) {

        if(visted.contains(row+":"+col)){
            return -1;
        }

        visted.add(row+":"+col);

        int value=(player==1)?1:-1;

        rows[row]+=value;
        cols[col]+=value;

        if(row==col){
            diag+=value;
        }

        if(row+col==n-1){
            antiDaig+=value;
        }

        if(Math.abs(rows[row])==n ||
                Math.abs(cols[col])==n ||
                Math.abs(diag)==n ||
                Math.abs(antiDaig)==n ){
            return player;
        }
        // Replace this placeholder return statement with your code
        return 0;
    }
}
