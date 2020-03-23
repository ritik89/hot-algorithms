import java.util.HashMap;
import java.util.Map;

public class Sudoku {

    /**
     * Utility function to find out the subgrid of a given coordinate on board
     *
     * @param i row number
     * @param j column number
     *
     * @return subgrid number
     */
    public static int findSubgrid(int i, int j){
        return (i/3)*3 + j/3;
    }

    /**
     * isValidSudokuState checks the current status of sudoku board to be
     * valid state or not
     * 
     * @param board a 2-D array representing sudoku board state
     *
     * @return
     */
    public static boolean isValidSudokuState(int[][] board){

        Map<Integer, Map<Integer, Boolean>> rows = new HashMap<>();
        Map<Integer, Map<Integer, Boolean>> columns = new HashMap<>();
        Map<Integer, Map<Integer, Boolean>> subgrids = new HashMap<>();

        //initilize these hashmaps
        for(int i = 0 ; i< 9; i++){
            Map<Integer, Boolean> dummyrows = new HashMap<>();
            Map<Integer, Boolean> dummycolumns = new HashMap<>();
            Map<Integer, Boolean> dummysubgrids = new HashMap<>();
            for(int j = 1 ; j < 10; j++){
                dummyrows.put(j,false);
                dummycolumns.put(j,false);
                dummysubgrids.put(j,false);
            }
            rows.put(i,dummyrows);
            columns.put(i,dummycolumns);
            subgrids.put(i,dummysubgrids);
        }


        //process each set coordinate value of board
        int val,row,column,subgrid;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                val = board[i][j];
                //check this value is set and not initial value 0
                if(val == 0)
                    continue;

                //set this cordinate value for the row, column and subgrid it belongs to
                row = i;
                column = j;
                subgrid = findSubgrid(i,j);

                //see if the value presented exists already in row, column and subgrid. Return false if it does
                if(columns.get(column).get(val)){
                    return false;
                }else{
                    rows.get(row).put(val,true);
                    columns.get(column).put(val,true);
                    subgrids.get(subgrid).put(val,true);

                }

            }
        }

        return true;
    }



    //Driver function to call isValidSudokuState method for a sudoku board
    public static void main(String[] args) {
        int[][] board = new int[9][9];

        //initialize the board
        board[0][0]=5;board[0][1]=3;board[0][2]=0;  board[0][3]=0;board[0][4]=7;board[0][5]=0;  board[0][6]=0;board[0][7]=0;board[0][8]=0;
        board[1][0]=6;board[1][1]=0;board[1][2]=0;  board[1][3]=1;board[1][4]=9;board[1][5]=5;  board[1][6]=0;board[1][7]=0;board[1][8]=0;
        board[2][0]=0;board[2][1]=9;board[2][2]=8;  board[2][3]=0;board[2][4]=0;board[2][5]=0;  board[2][6]=0;board[2][7]=6;board[2][8]=0;

        board[3][0]=8;board[3][1]=0;board[3][2]=0;  board[3][3]=0;board[3][4]=6;board[3][5]=0;  board[3][6]=0;board[3][7]=0;board[3][8]=3;
        board[4][0]=4;board[4][1]=0;board[4][2]=0;  board[4][3]=8;board[4][4]=0;board[4][5]=3;  board[4][6]=0;board[4][7]=0;board[4][8]=1;
        board[5][0]=7;board[5][1]=0;board[5][2]=0;  board[5][3]=0;board[5][4]=2;board[5][5]=0;  board[5][6]=0;board[5][7]=0;board[5][8]=6;

        board[6][0]=0;board[6][1]=6;board[6][2]=0;  board[6][3]=0;board[6][4]=0;board[6][5]=0;  board[6][6]=2;board[6][7]=8;board[6][8]=0;
        board[7][0]=0;board[7][1]=0;board[7][2]=0;  board[7][3]=4;board[7][4]=1;board[7][5]=9;  board[7][6]=0;board[7][7]=0;board[7][8]=5;
        board[8][0]=0;board[8][1]=0;board[8][2]=0;  board[8][3]=0;board[8][4]=8;board[8][5]=0;  board[8][6]=0;board[8][7]=7;board[8][8]=9;

        boolean validSudokuState = isValidSudokuState(board);
        System.out.println("Sudoku board in valid state: " + validSudokuState);
    }

}
