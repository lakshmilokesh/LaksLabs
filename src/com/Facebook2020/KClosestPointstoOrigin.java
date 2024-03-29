package com.Facebook2020;

import java.util.*;
public class KClosestPointstoOrigin {
     
// Function to print required answer
static void pClosest(int [][]pts, int k)
{
    int n = pts.length;
    int[] distance = new int[n];
    for(int i = 0; i < n; i++)
    {
        int x = pts[i][0], y = pts[i][1];
        distance[i] = (x * x) + (y * y);
    }
 
    Arrays.sort(distance);
     
    // Find the k-th distance
    int distk = distance[k - 1];
 
    // Print all distances which are
    // smaller than k-th distance
    for(int i = 0; i < n; i++)
    {
        int x = pts[i][0], y = pts[i][1];
        int dist = (x * x) + (y * y);
         
        if (dist <= distk)
            System.out.println("[" + x + ", " + y + "]");
    }
}
 
// Driver code
public static void main (String[] args)
{
    int points[][] = { { 3, 3 },
                       { 5, -1 },
                       { -2, 4 } };
 
    int K = 2;
     
    pClosest(points, K);
}

}
