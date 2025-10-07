package ravi.algo.concepts;

import java.util.*;
import java.util.stream.Collectors;

public class NestedIterator {
    // NestedIterator constructor inializes the stack using the given nestedList list
    Deque<NestedInteger> stack;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack=new ArrayDeque<>();
        for(int i=nestedList.size()-1;i>0;i--){
            this.stack.push(nestedList.get(i));
        }
        // Write your code here

    }

    // hasNext() will return True if there are still some integers in the
    // stack (that has nested_list elements) and, otherwise, will return False.
    public boolean hasNext() {
        while(!stack.isEmpty()){
            NestedInteger top=stack.peek();
            if(top.isInteger()){
                return true;
            }
            List<NestedInteger> topList=stack.poll().getList();
            for(int i=topList.size()-1;i>=0;i--){
                this.stack.push(topList.get(i));
            }

        }
        return false;
    }

    // Check if there is still an integer in the stack
    public int next() {
        // Replace this placeholder return statement with your code
        if(hasNext()){
            return stack.pop().getInteger();
        }
        return 0;
    }

    // ------ Please don't change the following function ----------
    // flattenList function is used for testing porpuses.
    // Your code will be tested using this function
    public static List<Integer> flattenList(NestedIterator obj){
        List<Integer> result = new ArrayList<Integer>();

        while (obj.hasNext()) {
            result.add(obj.next());
        }
        return result;
    }
}