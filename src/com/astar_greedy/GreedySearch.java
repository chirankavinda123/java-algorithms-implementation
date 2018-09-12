package com.astar_greedy;

import java.util.*;

public class GreedySearch {

    static void performGreedySearch(Graph graph, Vertex start, Vertex goal) {

        HashSet<Vertex> explored = new HashSet<>(20);
        List<Vertex> fringe = new ArrayList<>(20);

        final Map<Vertex, Vertex> traversedVia = new HashMap<>(); // The map of navigated nodes.


        // total cost from start -> goal through a specific point.
        final Map<Vertex, Integer> fScore = new HashMap<>();
        for (Vertex v : graph.getAllVerices())
            fScore.put(v, Integer.MAX_VALUE);
        fScore.put(start, (int) Utils.computeHeuristicCost(start, goal));


        Comparator<Vertex> comparator = (o1, o2) -> {
            if (fScore.get(o1) < fScore.get(o2))
                return -1;
            if (fScore.get(o2) < fScore.get(o1))
                return 1;
            return 0;
        };

        fringe.add(start);

        while (!fringe.isEmpty()) {
            Vertex current = fringe.get(0);
            if (current.equals(goal) || fringe.contains(goal)) {

                System.out.println("\n Goal found " + goal.cityCode + " " + goal.toString());

                System.out.println("\n Total path -->");
                reconstructPath(traversedVia, (ArrayList<Edge>) graph.allEdges, goal);
                break;
            } else {
                System.out.println("\n Expanding : " + current.cityCode + " " + current.toString());
            }
            fringe.remove(0);
            explored.add(current);

            Iterator iterator = (graph.allEdges).iterator();
            while (iterator.hasNext()) {

                Edge edge = (Edge) iterator.next();
                Vertex neighbor;

                if (edge.getFromVertex() == current && !fringe.contains(edge.getToVertex())) {
                    neighbor = edge.getToVertex();
                } else if (edge.getToVertex() == current && !fringe.contains(edge.getFromVertex())) {
                    neighbor = edge.getFromVertex();
                } else {
                    continue;
                }

                if (explored.contains(neighbor))
                    continue; // To ignore the neighbor if he has been explored already


                if (!fringe.contains(neighbor))
                    fringe.add(neighbor); // Adding a new node to open fringe

                traversedVia.put(neighbor, current);

                int estimatedFScore = 0;
                if (neighbor != null) {
                    estimatedFScore = (int) Utils.computeHeuristicCost(neighbor, goal);
                }
                fScore.put(neighbor, estimatedFScore);

                fringe.sort(comparator); //re-sort
                System.out.println(Collections.singletonList(fringe));
            }
        }

    }

    private static void reconstructPath(Map<Vertex, Vertex> cameFrom, ArrayList<Edge> allEdges,Vertex current) {

        List<Edge> totalPath = new ArrayList<>();

        while (current != null) {
            final Vertex previous = current;
            current = cameFrom.get(current);
            if (current != null) {
                final Edge edge = current.getEdge(previous,allEdges);
                totalPath.add(edge);
            }
        }
        Collections.reverse(totalPath);

        System.out.println(Collections.singletonList(totalPath));
        System.out.println();
    }

}
