package ravi.algo.concepts;

import java.util.Deque;
import java.util.LinkedList;

public class MInHeap {
    Deque<Integer> dq;
    Deque<Integer> mins;

    public MInHeap(){
        dq=new LinkedList<>();
        mins=new LinkedList<>();
    }

    public void append(int x){
        dq.addLast(x);
        while(!mins.isEmpty() && mins.peekLast()>x){
            mins.pollLast();
        }
        mins.addLast(x);

    }

    public void popleft(){
        int x=dq.pollFirst();
        if(!mins.isEmpty() && mins.peekFirst()==x){
            mins.pollFirst();
        }
    }

    public int min(){
        return mins.peekFirst();
    }

    public int size(){
        return dq.size();
    }


}
