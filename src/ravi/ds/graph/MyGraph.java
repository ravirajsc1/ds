package ravi.ds.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyGraph {

    private Map<Integer, List<Integer>> adjList;

    public MyGraph(){
        this.adjList=new HashMap<>();
    }


    public void addVertex(Integer vertix){
        this.adjList.putIfAbsent(vertix,new ArrayList<>());
    }

    public void addEdges (Integer  source, Integer destination){
        this.adjList.get(source).add(destination);
        this.adjList.get(destination).add(source);


    }

    public static void main(String[] args) {
        MyGraph myGraph=new MyGraph();
        myGraph.addVertex(1);
        myGraph.addVertex(2);
        myGraph.addVertex(3);
        myGraph.addVertex(4);

        myGraph.addEdges(1,2);
        myGraph.addEdges(2,3);

        myGraph.addEdges(3,4);
        myGraph.addEdges(4,1);
        myGraph.printGraph();

    }

    public void printGraph(){

        for(Integer key:adjList.keySet()){
            StringBuilder printvalue = new StringBuilder().append(key).append(" :");
            for(Integer value:adjList.get(key)){
                printvalue.append(" ").append(value);
            }
            System.out.println(printvalue );
        }

    }


}
