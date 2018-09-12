package com.astar_greedy;

import java.util.ArrayList;

public class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {

    public String cityCode;
    public int x=0;
    public int y=0;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Vertex(String cityCode, int x, int y) {
        this.x= x;
        this.y=y;
        this.cityCode=cityCode;
    }

    public Edge getEdge(Vertex v,ArrayList<Edge> allEdges) {
        for (Edge e : allEdges) {
            if (e.to.equals(v) && e.from.equals(this))
                return e;
        }
        return null;
    }

    @Override
    public boolean equals(Object v1) {

        if (!(v1 instanceof Vertex))
            return false;

        final Vertex v = (Vertex) v1;

        return (this.x == v.x) && (this.y == v.y);
    }

    @Override
    public int compareTo(Vertex<T> v) {
      return 0;
    }

    @Override
    public String toString() {
        return "(X:"+ x+",Y:"+y+")";
    }
}
