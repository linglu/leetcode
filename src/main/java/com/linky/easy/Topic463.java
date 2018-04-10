package com.linky.easy;

import com.linky.stdlib.StdOut;

/**
 * Island Perimeter
 * https://leetcode.com/problems/island-perimeter/description/
 */
public class Topic463 {

    public int islandPerimeter(int[][] grid) {

        int perimeter = 0;
        int outlength = grid.length;

        for (int i = 0; i < outlength; i++) {

            int innerlength = grid[i].length;

            for (int j = 0; j < innerlength; j++) {

                if (grid[i][j] == 1) {

                    if (j == 0 || grid[i][j - 1] == 0) {
                        perimeter++;
                    }

                    if (j == innerlength - 1 || grid[i][j + 1] == 0) {
                        perimeter++;
                    }

                    if (i == 0 || grid[i - 1][j] == 0) {
                        perimeter++;
                    }

                    if (i == outlength - 1 || grid[i + 1][j] == 0) {
                        perimeter++;
                    }
                }
            }
        }

        return perimeter;
    }

    public static void main(String[] args) {

        int[][] a = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        StdOut.println(new Topic463().islandPerimeter(a));

    }
}
