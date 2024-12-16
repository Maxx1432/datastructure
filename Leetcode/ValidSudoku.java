package Leetcode;

import java.util.HashSet;

public class ValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> numberFound = new HashSet<>();

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] != '.'){
                    if(!numberFound.add(i + " row " + board[i][j]))
                        return false;
                    if(!numberFound.add(j + " column " + board[i][j]))
                        return false;

                    int boxNumber = (i/3) * 3 + (j/3);
                    if(!numberFound.add(boxNumber + " box " + board[i][j]))
                        return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        char[][] board = {{'8','3','.','.','7','.','.','.','.'}
                         ,{'6','.','.','1','9','5','.','.','.'}
                         ,{'.','9','8','.','.','.','.','6','.'}
                         ,{'8','.','.','.','6','.','.','.','3'}
                         ,{'4','.','.','8','.','3','.','.','1'}
                         ,{'7','.','.','.','2','.','.','.','6'}
                         ,{'.','6','.','.','.','.','2','8','.'}
                         ,{'.','.','.','4','1','9','.','.','5'}
                         ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(isValidSudoku(board));
    }
}
