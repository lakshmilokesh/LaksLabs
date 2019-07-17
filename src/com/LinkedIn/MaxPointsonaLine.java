package com.LinkedIn;

import java.util.HashMap;
import java.util.Map;

/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 *
 * Example 1
 *
 * Input: [[1,1],[2,2],[3,3]]
 * Output: 3
 *
 * Explanation:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 *
 * Example 2
 *
 * Input: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * Output: 4
 * Explanation:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 *
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 *
 */
public class MaxPointsonaLine {
    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(2,2);
        Point p3 = new Point(0,3);
        Point p4 = new Point(0,3);
        Point p5 = new Point(0,3);
        Point p6 = new Point(0,3);

        Point[] points = new Point[]{p1,p2,p3,p4,p5,p6};
        System.out.println(maxPoints(points));
    }

    public static int maxPoints(Point[] points) {

        if (points == null) return 0;
        if (points.length <= 2) return points.length;

        int samex = 1;

        int maxFreqency = 0;
        Map<Integer, Integer> slopes = new HashMap<>();
        for (Point point : points) {

            if (point.x == 0) {
                samex++;
                continue;
            }
            int slope = (point.y/point.x);
            int frequncy = slopes.getOrDefault(slope,0);
            slopes.put(slope,frequncy+1);
            maxFreqency = Math.max(maxFreqency,frequncy+1);
        }
        maxFreqency = Math.max(maxFreqency,samex);
        return maxFreqency;
    }
}

 class Point {
     int x;
     int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }
