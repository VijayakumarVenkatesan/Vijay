package BackTracking;

import java.util.Arrays;

public class SuddokuSolver {
    public static boolean solve(char[][] board,int row,int column){
        if(row==9) return true;
        if(column==9) return solve(board,row+1,0);
        if(board[row][column]!='.') return solve(board,row,column+1);
        for (int i = 1; i < 10; i++) {
            if (valid(board, row, column, i)) {
                board[row][column]= (char)(48+i);
                if(solve(board,row,column+1)) return true;
                board[row][column] = '.';
            }
        }
        return false;
    }
    public static boolean valid(char[][] board,int row,int col,int value){
        //row
        for(int i=0;i<9;i++){
            if(board[row][i]!='.') if((board[row][i]==(char)(value+'0'))) return false;
        }
        //cloumn
        for(int i=0;i<9;i++){
            if(board[i][col]!='.') if(board[i][col]==(char)(value+'0')) return false;
        }
        //square box
        int rowstart=(row/3)*3,colstart=(col/3)*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[rowstart+i][colstart+j]!='.'){
                    if((board[rowstart+i][colstart+j]==(char)(value+'0'))) return  false;
                }
            }
        }
        return true;
    }
    public static void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
        for(int i=0;i<9;i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}
