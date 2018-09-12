package com.astar_greedy;


public class Edge<T extends Comparable<T>> implements Comparable<Edge<T>>  {

    public Vertex from = null;
    public Vertex to = null;
    public int cost = 0;

    public Edge(int cost, Vertex from, Vertex to) {
        if (from == null || to == null)
            throw (new NullPointerException(" NULL values not allowed"));

        this.cost = cost;
        this.from = from;
        this.to = to;
    }

    public Edge(Edge<T> e) {
        this(e.cost, e.from, e.to);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Vertex getFromVertex() {
        return from;
    }

    public Vertex getToVertex() {
        return to;
    }

    @Override
    public int hashCode() {
        final int cost = (this.cost * (this.getFromVertex().hashCode() * this.getToVertex().hashCode()));
        return 31 * cost;
    }

    @Override
    public boolean equals(Object e1) {
        if (!(e1 instanceof Edge))
            return false;

        final Edge<T> e = (Edge<T>) e1;

        final boolean costs = this.cost == e.cost;
        if (!costs)
            return false;

        final boolean from = this.from.equals(e.from);
        if (!from)
            return false;

        return this.to.equals(e.to);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Edge<T> e) {
        if (this.cost < e.cost)
            return -1;
        if (this.cost > e.cost)
            return 1;

        final int from = this.from.compareTo(e.from);
        if (from != 0)
            return from;

        final int to = this.to.compareTo(e.to);
        if (to != 0)
            return to;

        return 0;
    }

    @Override
    public String toString() {
        return "from: "+from+" to: "+to;
    }
}
