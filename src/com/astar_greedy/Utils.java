package com.astar_greedy;

public class Utils {

    //this heuristic util returns Eucleadian dist.
    public static double computeHeuristicCost(Vertex current,Vertex goal){
        double xPow = Math.pow((double)goal.x - (double)current.x,2);
        double yPow = Math.pow((double)goal.y - (double)current.y,2);

        double distance = Math.sqrt(xPow + yPow);

        return distance;
    }
}
