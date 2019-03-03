package com.song.leetcode;

import java.util.HashSet;
import java.util.Set;
//我的方法太复杂
public class Solution0036 {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++){
            if(!searchIt(board[i])) return false;
            char[] arr = {board[0][i],board[1][i],board[2][i],board[3][i],board[4][i],
                    board[5][i],board[6][i],board[7][i],board[8][i]};
            if (!searchIt(arr)) return false;

            int a = (i % 3) * 3;
            int b = (i / 3) * 3;

            char[] arr2 = {board[a][b],board[a + 1][b],board[a+2][b],board[a][b+1],board[a+1][b+1],
                    board[a+2][b+1],board[a][b+2],board[a+1][b+2],board[a+2][b+2]};
            if (!searchIt(arr2)) return false;
        }
        return true;
    }


    public boolean searchIt(char[] arr){
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < 9; i++){

            if ((arr[i] - 48) < 10 && (arr[i] - 48) > 0){
                set.add(arr[i] - 48);
                count++;


            }

        }

        if (count != set.size()) return false;


        return true;
    }

}
/* public boolean isValidSudoku(char[][] board) {
        // 记录某行，某位数字是否已经被摆放
        boolean[][] row = new boolean[9][10];
        // 记录某列，某位数字是否已经被摆放
        boolean[][] col = new boolean[9][10];
        // 记录某 3x3 宫格内，某位数字是否已经被摆放
        boolean[][] block = new boolean[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    if (row[i][num] || col[j][num] || block[i / 3 * 3 + j / 3][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[i / 3 * 3 + j / 3][num] = true;
                    }
                }
            }
        }
        return true;
    }*/