package ravi.algo.concepts;

import java.util.Stack;
import java.util.*;


class FreqStack {
    Map<Integer,Integer> freq;
    Map<Integer,Stack<Integer>> group;
    int max;

    public FreqStack() {
        freq=new HashMap<>();
        group=new HashMap<>();
        // Write your code here
    }

    public void push(int value) {

        int newFreq=freq.getOrDefault(value,0)+1;
        freq.put(value,newFreq);
        group.computeIfAbsent(newFreq,x->new Stack<>()).add(value);
        max=Math.max(max,newFreq);
    }

    public int pop() {
        int show=0;
        if(max>0){
                 show= group.get(max).pop();
                 if(group.get(max).isEmpty()){
                    max--;
                }

        }else{
            return -1;
        }


        return show;
    }

    public static void main(String[] args) {
        int[] inputs = {5, 7, 7, 7, 4, 5, 3};
        FreqStack obj = new FreqStack();
        for (int i = 0; i < inputs.length; i++) {
            obj.push(inputs[i]);
        }

        System.out.println("\tInput Stack: " + Arrays.toString(inputs) + "\n");

        for (int i = 0; i < inputs.length; i++) {
            System.out.print(i + 1);
            System.out.println(".\tPopping out the most frequent value...");
            System.out.println("\tValue removed from stack is: " + obj.pop());
          //  System.out.println(PrintHyphens.repeat("-", 100));
          //  System.out.println(PrintHyphens.repeat("-", 100));
        }
    }
}
