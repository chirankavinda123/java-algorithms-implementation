/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ucs;

/**
 *
 * @author Gaya
 */
public class Node {
    public final String nodeName;
    public double pathCost;
    public Edge[] adjacencies;
    public Node parent;

    public Node(String val){
            nodeName = val;
    }

    public String toString(){
            return nodeName;
    }
}
