package com.GoogleLessFrequent;

/*
 * Given a 2D grid, each cell is either a wall 'W', an enemy 'E' or empty '0' (the number zero), return the maximum
 * enemies you can kill using one bomb.
The bomb kills all the enemies in the same row and column from the planted point until it hits the wall since the wall
is too strong to be destroyed.
Note that you can only put the bomb at an empty cell.

Example:
For the given grid

0 E 0 0
E 0 W E
0 E 0 0

 * return 3. (Placing a bomb at (1,1) kills 3 enemies)
 *
 * Complexity :  First of all, I guess the worst case might be no 'W' in matrix at all.
Then, split iterators into three sub cases:

i = 0: O(mn)
j = 0: O(mn)
i > 0 && j > 0: O((m - 1) * (n - 1))
Lastly, add up above 3 cases to obtain a total O(3 * mn) time complexity. Three times of O(mn) still is O(mn).
 *
 *
 *
 *
 */
public class BombEnemy {


    public static void main(String[] args) {
        char[][] grid = new char[][]{{'0','E','0','0'},{'E','0','W','E'},{'0','E','0','0'}};
        System.out.println(maxKilledEnemies(grid));

    }
    public static int maxKilledEnemies(char[][] grid) {
        int m = grid.length, n = m == 0 ? 0 : grid[0].length;
        int result = 0, rowHits = 0, colHits[] = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    rowHits = 0;
                    // reset rowHits when hit wall, re calculate enemy after
                    for (int k = j; k < n && grid[i][k] != 'W'; k++) {
                        rowHits += grid[i][k] == 'E' ? 1 : 0;;
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colHits[j] = 0;
                    for (int k = i; k < m && grid[k][j] != 'W'; k++) {
                        colHits[j] += grid[k][j]== 'E' ? 1 : 0;
                    }
                }
                if (grid[i][j] == '0') {
                    result = Math.max(result, rowHits + colHits[j]);
                }
            }
        }
        return result;
    }
}
