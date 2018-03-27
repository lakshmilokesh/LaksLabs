package com.stacks;

/**
 * Created by Laks on 8/5/17.
 */
public class ArrayImplementationOfQueue {

    private int[] arr;
    private int top;
    private int rear;
    private int size;

    public ArrayImplementationOfQueue(int capacity) {
        arr = new int[capacity];
        top = -1;
        rear = 0;
        size = capacity;
    }

    public void push(int x) {
        if (top <= size) {
            top = top+1;
            arr[top] = x;
        }
        else {
            System.out.println("queue full");
        }
    }

    public void pop() {
        if (top >= rear) {
            rear = rear+1;
        }
        else {
            System.out.println("queue empty");
        }
    }

    public int peek() {
        return arr[rear];
    }

    public void display() {
        for(int i = rear; i <=top; i++) {
            System.out.println(arr[i]);
        }
    }
}
