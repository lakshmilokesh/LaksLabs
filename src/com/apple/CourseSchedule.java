package com.apple;

/*
 * There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as
  a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: 2, [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 *
 *
 *
 */

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule {

    public static void main(String[] args) {

        int[][] pre = new int[][]{{1,0}};
        System.out.println(canFinish(2,pre));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];
        List<Integer>[] adj = new List[numCourses];
        for(int i = 0; i < numCourses; i++)
            adj[i] = new ArrayList<Integer>();
        for(int i = 0; i < prerequisites.length; i++)
        {
            int curCourse = prerequisites[i][0];
            int preCourse = prerequisites[i][1];
            adj[preCourse].add(curCourse);
        }
        for(int i = 0; i < numCourses; i++)
        {
            if(!dfs(adj, visited, i))
                return false;
        }
        return true;
    }

    private static boolean dfs(List<Integer>[] adj, boolean[] visited, int course){

        if(visited[course])         // have circle
            return false;
        visited[course] = true;
        for (int i = 0; i < adj[course].size(); i++)
        {
            if(!dfs(adj, visited, adj[course].get(i)))
                return false;
            adj[course].remove(i);  // delete edge
        }
        visited[course] = false;
        return true;
    }
}
