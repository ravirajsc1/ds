package ravi.algo.concepts;

import java.util.PriorityQueue;

public class KthLargest {
    PriorityQueue<Integer> topKheap;
    public int k;

    public KthLargest(int k, int[] nums) {
        // Write your code Here
        topKheap=new PriorityQueue<>();
        for(int i=0;i<k;i++){
            topKheap.offer(nums[i]);
        }
        for(int i=k;i<nums.length;i++){
            add(nums[i]);
        }

    }

    // adds element in the topKHeap
    public int add(int val) {
        // Replace this placeholder return statement with your code
        if(!topKheap.isEmpty() && topKheap.peek()<val){
            topKheap.poll();
            topKheap.offer(val);
        }

        return topKheap.isEmpty()?-1:topKheap.peek();
    }
}
