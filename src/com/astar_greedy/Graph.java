package com.astar_greedy;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    public List<Edge> allEdges;

    public ArrayList<Edge> getAllEdges() {
        return (ArrayList<Edge>) allEdges;
    }

    public void setAllEdges(List<Edge> allEdges) {
        this.allEdges = allEdges;
    }

    public List<Vertex> getAllVerices() {
        return allVerices;
    }

    public void setAllVerices(List<Vertex> allVerices) {
        this.allVerices = allVerices;
    }

    private List<Vertex> allVerices;

    Graph(List<Edge> allEdges, List<Vertex> allVerices) {
        this.allEdges = allEdges;
        this.allVerices = allVerices;
    }
}
