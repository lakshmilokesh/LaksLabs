package com.stacks;

import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by Laks on 1/22/16.
 *
 * Implement the following operations of a stack using queues.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and
 * is empty operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque
 * (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class StackUsingQueues {

    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {

        if (empty()) {
            queue1.offer(x);
        }
        else {
            if (queue1.size() > 0) {
                queue2.offer(x);
                int size = queue1.size();
                while (size > 0) {
                    queue2.offer(queue1.poll());
                    size--;
                }
            }
            else if (queue2.size() > 0){
                queue1.offer(x);
                int size = queue2.size();
                while (size > 0) {
                    queue1.offer(queue2.poll());
                    size--;
                }

            }
        }

    }

    // Removes the element on top of the stack.
    public void pop() {
        if (queue1.size() > 0) {
            queue1.poll();
        }
        else if (queue2.size() > 0) {
            queue2.poll();
        }
        else {
            try {
                throw new Exception("Stack Empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Get the top element.
    public int top() {
        int top = 0;
        if (queue1.size() > 0) {
            top = queue1.peek();
        }
        else if (queue2.size() > 0) {
            top = queue2.peek();
        }
        else {
            try {
                throw new Exception("Stack Empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return top;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty() & queue2.isEmpty();
    }
}
