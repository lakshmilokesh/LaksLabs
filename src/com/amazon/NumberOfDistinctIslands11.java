package com.amazon;

/*
 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of 1's (representing land)
 * connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * Count the number of distinct islands. An island is considered to be the same as another if they have the same shape,
 * or have the same shape after rotation (90, 180, or 270 degrees only) or reflection (left/right direction or up/down
 * direction).
 *
 * 11000
 * 10000
 * 00001
 * 00011
 *
 * Given the above grid map, return 1.
 *
 *
 * Solution : using the constants 31, 33, 37, 39, and 41 will produce less than 7 collisions in each case. Knowing this,
 * it should come as no surprise that many Java implementations choose one of these constants.
 *
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfDistinctIslands11 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,1,0,0,0},{1,0,0,0,0},{0,0,0,0,1},{0,0,0,1,1}};
        System.out.println(numDistinctIslands2(grid));
    }

    public static int numDistinctIslands2(int[][] grid) {
        Set shapes = new HashSet<String>();
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; ++r) {
            for (int c = 0; c < grid[0].length; ++c) {
                List<int[]> shape = new ArrayList();
                dfs(r, c, grid, shape, seen);
                if (!shape.isEmpty())  shapes.add(computeHash(shape));
            }
        }

        return shapes.size();
    }

    public static int computeHash(List<int[]> tuple) {
        int size = tuple.size();
        int hash = 0;
        for (int i = 0; i < size; ++i) {
            int[] pt1 = tuple.get(i);
            for (int j = i + 1; j < size; ++j) {
                int[] pt2 = tuple.get(j);
                int deltar = pt1[0] - pt2[0];       // row distance
                int deltac = pt1[1] - pt2[1];       // col distance
                if (deltar == 0 || deltac == 0) {   // vertical or horizon
                    hash += 19 * (deltar * deltar + deltac * deltac);
                } else {        // diagonal
                    hash += 31 * (deltar * deltar + deltac * deltac);
                }
            }
        }
        return hash;
    }

    public static void dfs(int r, int c, int[][] grid, List<int[]> tuple, boolean[][] seen) {
        if (0 <= r && r < grid.length && 0 <= c && c < grid[0].length && grid[r][c] == 1 && !seen[r][c]){
            seen[r][c] = true;
            grid[r][c] = 0;
            tuple.add(new int[] {r, c});

            dfs(r+1, c, grid, tuple, seen);
            dfs(r-1, c, grid, tuple, seen);
            dfs(r, c+1, grid, tuple, seen);
            dfs(r, c-1, grid, tuple, seen);
        }
    }
}
