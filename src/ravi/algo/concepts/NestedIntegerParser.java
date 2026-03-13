package ravi.algo.concepts;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NestedIntegerParser {
    public static List<NestedInteger> createNestedInteger(String str) {
        Stack<NestedInteger> stack = new Stack<>();
        stack.push(new NestedInteger());

        int index = 0;

        while (index < str.length()) {
            if (Character.isDigit(str.charAt(index)) || (str.charAt(index) == '-' && Character.isDigit(str.charAt(index + 1)))) {
                int start = index;
                while (index < str.length() && (Character.isDigit(str.charAt(index)) || str.charAt(index) == '-')) {
                    index++;
                }

                int value = Integer.parseInt(str.substring(start, index));
                stack.peek().add(new NestedInteger(value));
            } else if (str.charAt(index) == '[') {
                index++;
                NestedInteger nestedList = new NestedInteger();
                stack.push(nestedList);
            } else if (str.charAt(index) == ',') {
                index++;
            } else if (str.charAt(index) == ']') {
                NestedInteger top = stack.pop();
                stack.peek().add(top);
                index++;
            } else {
                index++;
            }
        }

        List<NestedInteger> ret = new ArrayList<>();
        ret.add(stack.peek());
        return ret;
    }
}
