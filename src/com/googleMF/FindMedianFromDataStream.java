package com.googleMF;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    static PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());//lower half
    static PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();//higher half

    public FindMedianFromDataStream(){
        maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());
        minHeap = new PriorityQueue<Integer>();
    }

    // Adds a number into the data structure.
    public static void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());
        }
    }

    // Returns the median of current data stream
    public static double findMedian() {
        if(maxHeap.size()==minHeap.size()){
            return (double)(maxHeap.peek()+(minHeap.peek()))/2;
        }else{
            return maxHeap.peek();
        }
    }

    public static void main(String[] args) {

        addNum(3);
        addNum(2);
        addNum(6);
        addNum(8);
        addNum(9);
        System.out.println(findMedian());
    }
}
