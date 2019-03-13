package com.song.leetcode;

public class Solution0419 {

    public int countBattleships(char[][] board) {

        if (board.length == 0 && board[0].length == 0) return -1;
        int result = 0;
        for (int i = 0; i < board.length; i++) {

            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    findIt(board, i, j);
                    result++;
                }
            }
        }
        return result;

    }

    public void findIt(char[][] board, int i, int j) {

        if (board[i][j] == '.') {
            return;
        }
        if (board[i][j] == 'X') {
            board[i][j] = '.';
        }
        if (i > 0) {
            findIt(board, i - 1, j);
        }
        if (i < board.length - 1) {
            findIt(board, i + 1, j);
        }
        if (j > 0) {
            findIt(board, i, j - 1);
        }
        if (j < board[i].length - 1) {
            findIt(board, i, j + 1);
        }
    }
}
