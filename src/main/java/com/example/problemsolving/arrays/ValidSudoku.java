package com.example.problemsolving.arrays;

import javax.swing.*;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{{'5','3','.','.','7','.','.','.','.'}
                                                    ,{'6','.','.','1','9','5','.','.','.'}
                                                    ,{'.','9','8','.','.','.','.','6','.'}
                                                    ,{'8','.','.','.','6','.','.','.','3'}
                                                    ,{'4','.','.','8','.','3','.','.','1'}
                                                    ,{'7','.','.','.','2','.','.','.','6'}
                                                    ,{'.','6','.','.','.','.','2','8','.'}
                                                    ,{'.','.','.','4','1','9','.','.','5'}
                                                    ,{'.','.','.','.','8','.','.','7','9'}}));
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i=0; i<9; i++) {
            Set<Character> horizontal= new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j]!='.' && !horizontal.add(board[i][j])) return false;
            }
            Set<Character> vertical= new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i]!='.' && !vertical.add(board[j][i])) return false;
            }
        }
        int x = 0;
        while(x<9) {
            int y = 0;
            while (y < 9) {
                Set<Character> subBox = new HashSet<>();
                for (int i = x; i < 3 + x; i++) {
                    for (int j = y; j < 3 + y; j++) {
                        if (board[i][j]!='.' && !subBox.add(board[i][j])) return false;
                    }
                }
                y += 3;
            }
            x += 3;
        }
        return true;
    }
}