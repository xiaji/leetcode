// Source: https://leetcode.com/problems/implement-queue-using-stacks/description/
// Author: xiaji
// Date: 2017-09-22
// Solution:


/**
 * Implement the following operations of a queue using stacks.
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Notes:
 * You must use only standard operations of a stack -- which means only push to top,
 * peek/pop from top, size, and is empty operations are valid.
 * Depending on your language, stack may not be supported natively.
 * You may simulate a stack by using a list or deque (double-ended queue),
 * as long as you use only standard operations of a stack.
 * You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
 * */

/** Mistakes:
 *
 *
 */

class MyQueue {
    private Stack<Integer> queue;
    private Stack<Integer> temp;
    /** Initialize your data structure here. */
    public MyQueue() {
        queue = new Stack<Integer>();
        temp = new Stack<Integer>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
      while (!temp.isEmpty()) queue.push(temp.pop());
      queue.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if (queue.isEmpty()) return Integer.MIN_VALUE;
        while (!queue.isEmpty()) temp.push(queue.pop());
        int result = temp.pop();
        while (!temp.isEmpty()) queue.push(temp.pop());
        return result;
    }
    
    /** Get the front element. */
    public int peek() {
        if (queue.isEmpty()) return Integer.MIN_VALUE;
        while (!queue.isEmpty()) temp.push(queue.pop());
        int result = temp.peek();
        while (!temp.isEmpty()) queue.push(temp.pop());
        return result;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
