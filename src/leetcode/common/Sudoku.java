package leetcode.common;/**
 * @description Sudoku
 * @author liusandao
 * @date 2020-5-6 10:16
 */

import java.util.HashSet;
import java.util.Set;

/**
 * @program: algorithm
 * @description:
 * @author: liusandao
 * @date 2020-05-06 10:16
 */

public class Sudoku {

    public void solveSudoku(char[][] board) {
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.'){
                    sum++;
                }
            }
        }
        while (sum < 81){
            int count = fillCertainblock(board);
            sum += count;
            if (count == 0){
                break;
            }
        }
        if (sum < 81){
            boolean[][] filled = new boolean[board.length][board[0].length];
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board.length; j++) {
                    if (board[i][j] != '.'){
                        filled[i][j] = true;
                    }
                }
            }
            traceBack(board, filled, 0, 0);
        }
    }

    public boolean traceBack(char[][] board, boolean[][] filled, int i, int j){
        if (j >= board.length){
            return traceBack(board, filled, i + 1, 0);
        } else if (i >= board.length){
            return true;
        } else if (filled[i][j]){
            return traceBack(board, filled, i, j + 1);
        } else {
            Set<Character> con = conflict(board, i, j);
            if (con.size() == 9){
                return false;
            } else {
                for (char c = '1'; c <= '9'; c++) {
                    if (!con.contains(c)) {
                        board[i][j] = c;
                        if(traceBack(board, filled, i, j + 1)){
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
    }

    public int fillCertainblock(char[][] board){
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.'){
                    Set<Character> con = conflict(board, i, j);
                    if (con.size() == 8){
                        count++;
                        for (char c = '1'; c <= '9'; c++){
                            if (!con.contains(c)){
                                board[i][j] = c;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    public Set<Character> conflict(char[][] board, int i, int j){
        Set<Character> con = new HashSet<>();
        for (int k = 0; k < board.length; k++) {
            if (board[i][k] != '.'){
                con.add(board[i][k]);
            }
            if (board[k][j] != '.'){
                con.add(board[k][j]);
            }
        }
        int areai = i / 3;
        int areaj = j / 3;
        for (int ai = areai * 3; ai < areai * 3 + 3; ai++){
            for (int aj = areaj * 3; aj < areaj * 3 + 3; aj++){
                if (board[ai][aj] != '.'){
                    con.add(board[ai][aj]);
                }
            }
        }
        return con;
    }

}
