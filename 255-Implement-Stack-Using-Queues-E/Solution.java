// Source: https://leetcode.com/problems/implement-stack-using-queues/description/
// Author: xiaji
// Date: 2017-09-22
// Solution:


/**
 * mplement the following operations of a stack using queues.
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * Notes:
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, 
 * and is empty operations are valid.
 * Depending on your language, queue may not be supported natively. 
 * You may simulate a queue by using a list or deque (double-ended queue), 
 * as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 * */

/** Mistakes:
 *
 *
 */

class MyStack {
    private Queue<Integer> stack;
    private Queue<Integer> temp;
    /** Initialize your data structure here. */
    public MyStack() {
        stack = new LinkedList<Integer>();
        temp = new LinkedList<Integer>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        while (!temp.isEmpty()) stack.offer(temp.poll());
        stack.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (stack.isEmpty()) return Integer.MIN_VALUE;
        while (stack.size() != 1) temp.offer(stack.poll());
        int result = stack.poll();
        while (!temp.isEmpty()) stack.offer(temp.poll());
        return result;
    }
    
    /** Get the top element. */
    public int top() {
        if (stack.isEmpty()) return Integer.MIN_VALUE;
        int result = 0;
        while (!stack.isEmpty()) {
          if (stack.size() == 1) result = stack.peek();
          temp.offer(stack.poll());
        }
        while (!temp.isEmpty()) stack.offer(temp.poll());
        return result;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

