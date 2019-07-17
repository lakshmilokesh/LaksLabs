package com.GoogleLessFrequent;

/*
 * There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, left
 * or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.
 *
 * Given the ball's start position, the destination and the maze, determine whether the ball could stop at the destination.
 *
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. You may assume that the
 * borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 *
 */

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {

    public static void main(String[] args) {

    }
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int m = maze.length;
        int n = maze[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        q.offer(start);
        visited[start[0]][start[1]] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == destination[0] && cur[1] == destination[1])
                return true;

            for (int[] d: dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];

                while (x > 0 && y > 0 && x < m-1 && y < n-1 && maze[x][y] == 0) {
                    x = x+d[0];
                    y = y+d[1];
                }

                if (!visited[x-d[0]][y-d[1]]) {
                    q.offer(new int[]{x-d[0],y-d[1]});
                    visited[x-d[0]][y-d[1]] = true;
                }
            }

        }

    return false;
    }
}
