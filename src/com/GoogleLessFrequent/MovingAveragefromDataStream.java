package com.GoogleLessFrequent;

import java.util.LinkedList;
import java.util.Queue;

/*
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

For example,
MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
 *
 *
 */
public class MovingAveragefromDataStream {

    Queue<Integer> q;
    int sum;
    int limit;

    public MovingAveragefromDataStream(int size) {

        this.limit = size;
        this.sum = 0;
        this.q = new LinkedList<>();
    }

    public double next(int val) {

        if (q.size() == limit) {
            sum = sum - q.remove();
        }
        sum = sum+val;
        q.add(val);
        return sum/q.size();

    }
}
