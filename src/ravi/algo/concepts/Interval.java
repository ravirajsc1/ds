package ravi.algo.concepts;

public class Interval {
    int start;
    int end;
    boolean closed;

    public Interval(int start,int end){
        this.start=start;
        this.end=end;
        this.closed=true;

    }

    public void setClosed(boolean closed){
        this.closed=closed;
    }
}
