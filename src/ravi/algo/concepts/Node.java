package ravi.algo.concepts;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int data;
    List<Node> neighbors;

    public Node(int data){
        this.data=data;
        this.neighbors=new ArrayList<Node>();
    }


}
