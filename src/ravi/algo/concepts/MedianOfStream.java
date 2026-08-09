package ravi.algo.concepts;

import java.util.PriorityQueue;

class MedianOfStream {

    public PriorityQueue<Integer> minHeapforLargerNumber;
    public PriorityQueue<Integer> maxHeapforSmallerNumber;


    public MedianOfStream() {
        // Write your code here
        minHeapforLargerNumber=new PriorityQueue<>((a, b) -> a - b);
        maxHeapforSmallerNumber=new PriorityQueue<>((a, b) -> b - a);

    }

    public void insertNum(int num) {

        if(maxHeapforSmallerNumber.isEmpty() || maxHeapforSmallerNumber.peek()>num){
            maxHeapforSmallerNumber.offer(num);
        }else{
            minHeapforLargerNumber.offer(num);
        }

        // rebalance

        if(minHeapforLargerNumber.size()>maxHeapforSmallerNumber.size()){
            maxHeapforSmallerNumber.offer(minHeapforLargerNumber.poll());
        }else if(maxHeapforSmallerNumber.size()>minHeapforLargerNumber.size()+1){
            minHeapforLargerNumber.add(maxHeapforSmallerNumber.poll());
        }


    }

    public double findMedian() {
        // Replace this placeholder return statement with your code
        if(maxHeapforSmallerNumber.size()==minHeapforLargerNumber.size()){
            return maxHeapforSmallerNumber.peek()/2.0+minHeapforLargerNumber.peek()/2.0;
        }
        return maxHeapforSmallerNumber.peek();
    }
}