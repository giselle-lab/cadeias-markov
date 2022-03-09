import java.util.*;
 
//class to store edges of the weighted graph
class Edge extends Jogador{
    int src, dest;
    double weight;
    //String name;
    Edge(int src, int dest, double weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;

        }
}
// Graph class
class Graph extends Jogador{
    // node of adjacency list 
    static class Node {
        int value;
        double weight;
        String name;
        Node(int value, double weight)  {
            this.value = value;
            this.weight = weight;
        }
    };
 
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
    public double getRandomNumber(double min, double max) {
        return (double) ((Math.random() * (max - min)) + min);
    }
}



class Main{
    public static void main (String[] args) {
        // define edges of the graph 
        double min= 0.7, max = 0.8;
        double p = (double) Math.floor(Math.random()*(max-min+1)+min);
        double q = 1-p;
        Jogador jA = new Jogador("ja",p);
        Jogador jB = new Jogador("jb",q);
        Jogo jogo = new Jogo(jA,jB);

        List<Edge> edges = Arrays.asList(new Edge(0, 1,1-p),new Edge(0, 2,p),
                    new Edge(1, 3, ),new Edge(1, 4, p), new Edge(2, 5, p),
                   new Edge(2, , 3), new Edge(4, 5, 1),new Edge(5, 4, 3));
 
        // call graph class Constructor to construct a graph
        Graph graph = new Graph(edges);
 
        // print the graph as an adjacency list
        Graph.printGraph(graph);
    }
}