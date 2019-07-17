package com.sample;

import java.util.PriorityQueue;

public class PriorityQueueSample {

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(30);
        pq.offer(10);
        pq.offer(40);
        pq.offer(20);
        System.out.println(pq);
        pq.poll();
        pq.poll();
        pq.poll();
        pq.poll();
    }
}
