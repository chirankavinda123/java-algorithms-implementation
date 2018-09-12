package com.astar_greedy;

import java.util.ArrayList;
import java.util.List;

public class TestAlgorithms {


    public static void main(String[] args){

        Vertex a = new Vertex("LA",1,1);
        Vertex b = new Vertex("NY",3,2);
        Vertex c = new Vertex("CA",1,3);
        Vertex d = new Vertex("BO",2,2);
        Vertex e = new Vertex("PA",4,1);
        Vertex f = new Vertex("FL",3,4);
        Vertex g = new Vertex("MI",5,5);

        List<Vertex> vertices = new ArrayList<>();
        vertices.add(a);
        vertices.add(b);
        vertices.add(c);
        vertices.add(d);
        vertices.add(e);
        vertices.add(f);
        vertices.add(g);


        Edge e1 = new Edge(10,a,b);
        Edge e2 = new Edge(20,a,c);
        Edge e3 = new Edge(40,a,e);
        Edge e4 = new Edge(15,b,c);

        Edge e5 = new Edge(25,b,d);
        Edge e6 = new Edge(30,c,f);
        Edge e7 = new Edge(36,d,f);
        Edge e8 = new Edge(40,d,e);

        Edge e9 = new Edge(50,f,g);
        Edge e10 = new Edge(48,e,g);

        List<Edge> edges = new ArrayList<>();
        edges.add(e1);
        edges.add(e2);
        edges.add(e3);
        edges.add(e4);
        edges.add(e5);
        edges.add(e6);
        edges.add(e7);
        edges.add(e8);
        edges.add(e9);
        edges.add(e10);

        Graph graph = new Graph(edges,vertices);


        System.out.println("---------------------A Star Search--------------------------------------------");
        AStar.performAStarSearch(graph,a,g);

        System.out.println("\n---------------------Greedy Best-First Search----------------------------------");

        GreedySearch.performGreedySearch(graph,a,g);
    }
}
