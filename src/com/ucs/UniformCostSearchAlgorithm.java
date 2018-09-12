package com.ucs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
//import java.util.Queue;
import java.util.Scanner;

public class UniformCostSearchAlgorithm {


    public static void main(String[] args) {
    //initialize the graph
        Node n1 = new Node("S");
        Node n2 = new Node("A");
        Node n3 = new Node("B");
        Node n4 = new Node("C");
        Node n5 = new Node("D");
        Node n6 = new Node("E");
        Node n7 = new Node("F");
        Node n8 = new Node("G");
        Node n9 = new Node("H");

        //initialize the edges

        //n1
        n1.adjacencies = new Edge[]{
            new Edge(n2,3),
            new Edge(n3,6),
            new Edge(n4,2)
        };

        //n2
        n2.adjacencies = new Edge[]{
            new Edge(n1,3),
            new Edge(n5,3)
        };

        //n3
        n3.adjacencies = new Edge[]{
            new Edge(n1,6),
            new Edge(n5,4),
            new Edge(n6,2),
            new Edge(n8,9)
        };

        //n4
        n4.adjacencies = new Edge[]{
            new Edge(n1,2),
            new Edge(n6,1)
        };

        //n5
        n5.adjacencies = new Edge[]{
            new Edge(n2,3),
            new Edge(n3,4),
            new Edge(n7,5)
        };

        //n6
        n6.adjacencies = new Edge[]{
            new Edge(n3,2),
            new Edge(n4,1),
            new Edge(n7,6),
            new Edge(n9,5)
        };

        //n7
        n7.adjacencies = new Edge[]{
            new Edge(n5,5),
            new Edge(n6,6),
            new Edge(n8,5)
        };

        //n8
        n8.adjacencies = new Edge[]{
            new Edge(n3,9),
            new Edge(n7,5),
            new Edge(n9,8)
        };

        //n9
        n9.adjacencies = new Edge[]{
            new Edge(n6,5),
            new Edge(n8,8)
        };

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nodes: A, B, C, D, E, F, G, H, S");
        
        System.out.println("Enter the source:");
        String start = scanner.nextLine();

        System.out.println("Enter the goal:");
        String desti = scanner.nextLine();

        Node nstart = null;
        Node ndesti = null;

        switch(desti) {
            case "S" :
                    ndesti = n1;
                    break;
            case "A" :
                    ndesti = n2;
                    break;
            case "B" :
                    ndesti = n3;
                    break;
            case "C" :
                    ndesti = n4;
                    break;
            case "D" :
                    ndesti = n5;
                    break;
            case "E" :
                    ndesti = n6;
                    break;
            case "F" :
                    ndesti = n7;
                    break;
            case "G" :
                    ndesti = n8;
                    break;
            case "H" :
                    ndesti = n9;
                    break;
            default :
                    System.out.println("Invalid source node");
        }

        switch(start) {
            case "S" :
                    nstart = n1;
                    break;
            case "A" :
                    nstart = n2;
                    break;
            case "B" :
                    nstart = n3;
                    break;
            case "C" :
                    nstart = n4;
                    break;
            case "D" :
                    nstart = n5;
                    break;
            case "E" :
                    nstart = n6;
                    break;
            case "F" :
                    nstart = n7;
                    break;
            case "G" :
                    nstart = n8;
                    break;
            case "H" :
                    nstart = n9;
                    break;
            default :
                    System.out.println("Invalid node");
        }

        System.out.println("\nSource : " + nstart);
        System.out.println("Goal : " + ndesti);

        UniformCostSearch(nstart,ndesti);

        List<Node> path = printPath(ndesti);

        System.out.println("Path: " + path);
    }
    public static void UniformCostSearch(Node source, Node goal){
		
        source.pathCost = 0;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(10, 
            new Comparator<Node>(){
                //override compare method
                public int compare(Node i, Node j){
                    if(i.pathCost > j.pathCost){
                        return 1;
                    }
                    else if (i.pathCost < j.pathCost){
                        return -1;
                    }
                    else{
                        return 0;
                    }
                }
            }
        );
		
        LinkedList<Node> exploredList = new LinkedList<>();
        boolean found = false;
        
        queue.add(source);
        
        //while frontier is not empty
        do{
            Node current = queue.poll();
            exploredList.add(current);


            //end if path is found
            if(current.nodeName.equals(goal.nodeName)){
                found = true;	
            }

            for(Edge e: current.adjacencies){
                Node child = e.target;
                double cost = e.cost;

                //add node to queue if node has not been explored
                if(!exploredList.contains(child) && !queue.contains(child)){
                    child.pathCost = current.pathCost + cost;
                    child.parent = current;
                    queue.add(child);
                }


                //current path is shorter than previous path found
                else if((queue.contains(child))&&(child.pathCost>(current.pathCost+cost))){
                    child.parent=current;
                    child.pathCost = current.pathCost + cost;
                    queue.remove(child);
                    queue.add(child);
                }
            }
        }
        while(!queue.isEmpty()&&(found==false));
        
        System.out.println("Order of visit: " + exploredList);
        
        while(!queue.isEmpty()){
            exploredList.add(queue.poll());
        }
 
        System.out.println("Priority Queue: " + exploredList); 
    }

    public static List<Node> printPath(Node target){
        List<Node> path = new ArrayList<Node>();
        for(Node node = target; node!=null; node = node.parent){
            path.add(node);
        }
        Collections.reverse(path);

        return path;
    }
}
