package ravi.ds.graph;

import java.util.*;

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

    public void bsfSearch(int start) {

        Set<Integer> visted = new HashSet<>();
        LinkedList<Integer> qeue = new LinkedList<>();

        if(Objects.isNull(adjList.get(start))){
            throw new RuntimeException("No where to start");
        }
        visted.add(start);
        //   visted.add(start);
        qeue.add(start);
        while (qeue.size() > 0) {
            start = qeue.poll();
            System.out.println(start + " ");

            adjList.get(start).forEach(node -> {
                if (!visted.contains(node)) {
                    visted.add(node);
                    qeue.add(node);
                }

            });
        }
    }


    public void dsfSearch(Integer start){

        if(Objects.isNull(adjList.get(start))){
            throw new RuntimeException("No where to start");
        }
        Set<Integer> visted = new HashSet<>();
        dsfRecursion(visted,start);


    }


    public void dsfRecursion(Set<Integer> visited,Integer s){

        System.out.println(s+" ");
        visited.add(s);
        adjList.get(s).forEach(node-> {
            if(!visited.contains(node)){

                dsfRecursion(visited,node);
            }
        });




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

        System.out.println("BSF:");
        myGraph.bsfSearch(3);
        System.out.println("DSF:");
        myGraph.dsfSearch(3);
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
