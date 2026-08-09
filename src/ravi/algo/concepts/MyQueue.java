package ravi.algo.concepts;

import java.util.*;

class MyQueue {

    Stack stack1;
    Stack stack2;
    public MyQueue() {
        stack1=new Stack();
        stack2=new Stack();
        // Write your code here
    }

    public void push(int x) {

        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        stack1.push(x);

        while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        // Write your code here
    }

    public int pop() {

        // Replace this placeholder return statement with your code
        return stack1.pop();
    }

    public int peek() {

        // Replace this placeholder return statement with your code
        return stack1.top();
    }

    public boolean empty() {

        // Replace this placeholder return statement with your code
        return stack1.isEmpty();
    }
}