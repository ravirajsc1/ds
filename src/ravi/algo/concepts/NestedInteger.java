package ravi.algo.concepts;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {
    private List<NestedInteger> nList;
    private int integer;
    private boolean isSingleInteger;

    // Constructor initializes an empty nested list
    public NestedInteger() {
        nList = new ArrayList<>();
        isSingleInteger = false;
    }

    // Constructor initializes a single integer
    public NestedInteger(int value) {
        integer = value;
        isSingleInteger = true;
    }

    // Returns true if this NestedInteger holds a single integer rather than a nested list
    public boolean isInteger() {
        return isSingleInteger;
    }

    // Returns the single integer this NestedInteger holds, if it holds a single integer
    // Otherwise, return null if this NestedInteger holds a nested list
    public Integer getInteger() {
        return isSingleInteger ? integer : null;
    }

    // Sets this NestedInteger to hold a single integer equal to value
    public void setInteger(int value) {
        integer = value;
        isSingleInteger = true;
    }

    // Sets this NestedInteger to hold a nested list and adds the nested integer elem to it
    public void add(NestedInteger elem) {
        if(isSingleInteger){
            nList = new ArrayList<>();
        }
        nList.add(elem);
        isSingleInteger = false;
    }

    // Returns the nested list that this NestedInteger holds, if it holds a nested list
    // Otherwise, return empty list if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return nList;
    }
}