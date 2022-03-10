package models;
import java.util.*;

// Graph class
public class Graph {

    // node of adjacency list 
    static class Node {
            Node p ;
            Node q ;
            int value;
            float weight;
        Node(int value, double weight)  {
            this.p = null;
            this.q = null;
            this.value = value;
            this.weight = weight;
        }
        public void setP(Node n){
            this.p = n;
        }
        public void setQ(Node n){
            this.q = n;
        }
        public Node getP(){
            return this.p;
        }
        public Node getQ(){
            return this.q;
        }
        public bool isLast(){
            if(this.p == null && this.q == null){
                return true;
            }else{
                return false;
            }
        }
    };
 Node first;
 Node current;
 /*
 void insertNode(string parentNode, bool isQ, Node newNode) {
     Node parent = this.findNode(parentNode);
     if (isQ) parent.setQ(newNode);
     else parent.setP(newNode);
}
*/ 
// define adjacency list
List<List<Node>> adj_list = new ArrayList<>();
 
    //Graph Constructor
    public Graph(List<Edge> edges)
    {
        // adjacency list memory allocation
        for (int i = 0; i < edges.size(); i++)
            adj_list.add(i, new ArrayList<>());
 
        // add edges to the graph
        for (Edge e : edges)
        {
            // allocate new node in adjacency List from src to dest
            adj_list.get(e.src).add(new Node(e.dest, e.weight));
        }
    }
// print adjacency list for the graph
    public static void printGraph(Graph graph)  {
        int src_vertex = 0;
        int list_size = graph.adj_list.size();
 
        System.out.println("The contents of the graph:");
        while (src_vertex < list_size) {
            //traverse through the adjacency list and print the edges
            for (Node edge : graph.adj_list.get(src_vertex)) {
                System.out.print("Vertex:" + src_vertex + " ==> " + edge.value + 
                                " (" + edge.weight + ")\t");
            }
 
            System.out.println();
            src_vertex++;
        }
    }

}

