package ravi.algo.concepts;

import java.util.ArrayList;
import java.util.List;

class Stack {
    private List<Integer> stackList;

    public Stack() {
        stackList = new ArrayList<>();
    }

    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    public int top() {
        if (isEmpty()) {
            return -1; // Assuming -1 indicates an empty stack
        }
        return stackList.get(stackList.size() - 1);
    }

    public int size() {
        return stackList.size();
    }

    public void push(int value) {
        stackList.add(value);
    }

    public int pop() {
        if (isEmpty()) {
            return -1; // Assuming -1 indicates an empty stack
        }
        int topValue = stackList.get(stackList.size() - 1);
        stackList.remove(stackList.size() - 1);
        return topValue;
    }
}