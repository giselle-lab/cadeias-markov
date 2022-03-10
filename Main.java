import java.util.*;
import models.*;

public class Main{
 
    public static void main (String[] args) {
        // define edges of the graph 
        double min= 0.7, max = 0.8;
        //gera uma probabilidade com 0.7<= p <= 0.8 do jogador A ganhar
        double p =  (double) ((Math.random() * (max - min)) + min);
        p = Math.round(p * 100.0) / 100.0;
        double q = 1-p;

        Jogador jA = new Jogador("ja",p);
        Jogador jB = new Jogador("jb",q);
        Jogo jogo = new Jogo(jA,jB);

        List<Edge> edges = Arrays.asList(new Edge(0, 1,1-p),new Edge(0, 2,p),
                    new Edge(1, 3, 1-p),new Edge(1, 4, p), new Edge(2, 4,1-p),
                   new Edge(2, 5, p), new Edge(3, 6,1-p),new Edge(3, 7, p)
                   ,new Edge(4, 7,1-p),new Edge(4, 8, p),new Edge(5, 8,1-p)
                   ,new Edge(5, 9, p),new Edge(6, 13,1-p),new Edge(6, 10, p)
                   ,new Edge(7, 10,1-p),new Edge(7, 11, p),new Edge(8, 11,1-p)
                   ,new Edge(8, 12, p),new Edge(9, 12,1-p),new Edge(9, 16, p)
                   ,new Edge(10, 13, 1-p),new Edge(10, 14, p),new Edge(11, 14,1-p)
                   ,new Edge(11, 15, p),new Edge(12, 15,1-p),new Edge(12, 16, p)
                   ,new Edge(14, 13,1-p),new Edge(14, 11, p),new Edge(15, 11,1-p)
                   ,new Edge(15, 16,p));
 
        // call graph class Constructor to construct a graph
        Graph graph = new Graph(edges);
        
        for(int i = 0; i < 100; i++){

        }

        // print the graph as an adjacency list
        Graph.printGraph(graph);
    }
}
