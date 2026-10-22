package Graph;

import java.util.*;

public class Graph {
    private Map<Integer, List<Integer>> adjList;
    //Map<Integer,Map<Integer,Integer>>
    Graph(){
        adjList=new HashMap<>();
    }
    public void addVertex(int vertex){
        adjList.putIfAbsent(vertex,new ArrayList<>());
    }
    public void addEdge(int src,int dest){
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }
    public void display(){
        for(int vertex:adjList.keySet()){
            System.out.println(vertex+"->"+adjList.get(vertex));
        }
    }
    public void bfs(int start){
        ArrayList<Integer> visited=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        visited.add(start);
        queue.add(start);
        while(!queue.isEmpty()){
            int node=queue.poll();
            System.out.print(node+" ");
            for(int neighbour: adjList.get(node)){
                if(!visited.contains(neighbour)){
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Graph graph=new Graph();
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(1,3);
        graph.display();
        System.out.println("BFS: ");
        graph.bfs(1);
    }
}
