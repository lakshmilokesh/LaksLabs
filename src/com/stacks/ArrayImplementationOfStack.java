package com.stacks;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * Created by Laks on 8/5/17.
 */
public class ArrayImplementationOfStack {

    private int[] arr;
    private int n;
    private int top;

    public ArrayImplementationOfStack(int size) {
        arr = new int[size];
        n = size;
        top = -1;

    }
    public void push(int x) {
        if (top == n-1) {
            System.out.println("Stack is full");
        }
        else
        {
            top = top+1;
            arr[top] = x;
        }
    }
    public int peek() {
        return arr[top];
    }

    public void pop() {
        if(isEmpty())
            System.out.println("Cannot pop from an empty stack");
        else
            top = top - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void display(){
        for (int i = 0; i <= top; i++) {
            System.out.println(arr[i]);
        }
    }
}
