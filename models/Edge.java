package models;
import java.util.*;
 
//class to store edges of the weighted graph
public class Edge extends Jogador{
    int src, dest;
    double weight;
    //String name;
    public Edge(int src, int dest, double weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
}