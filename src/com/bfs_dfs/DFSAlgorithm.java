package com.bfs_dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

import java.util.List;

public class DFSAlgorithm {
	static class Node
	{

		String data;
		boolean visited;
		List<Node> neighbours;
 
		Node(String data)
		{
			this.data=data;
			this.neighbours=new ArrayList<Node>();
 
		}
		public void addneighbours(Node neighbourNode)
		{
			this.neighbours.add(neighbourNode);
		}
		public List<Node> getNeighbours() {
			return neighbours;
		}
		public void setNeighbours(List<Node> neighbours) {
			this.neighbours = neighbours;
		}
	}
 
	 
	

 
	// Iterative DFS using stack
	public  void dfsUsingStack(Node node)
	{
		Stack<Node> stack=new  Stack<Node>();
		stack.add(node);
		node.visited=true;
		boolean stop = false;
		String changeOfStack = "";
		int stackStep = 1;
		
		
		while (!stack.isEmpty()&&!stop)
		{
			Node element=stack.pop();
			System.out.print(element.data+" > ");
 
			
			if(element.data=="Galle") {
				stop = true;
				break;
			}
			
			List<Node> neighbours=element.getNeighbours();
			

		
			Stack<Node> tmpStack = new Stack<Node>();
			for (int i = 0; i < neighbours.size(); i++) {
				Node n = null;
				
				
				
				/******neighbours sorting **/
				class Sortbyname implements Comparator<Node>
			     {
			

					public int compare(Node n1, Node n2) {
						 return n1.data.compareTo(n2.data);
					}
			     }
				Collections.sort(neighbours,new Sortbyname());
				
				/**end neighbours sorting **/
				

				n =neighbours.get(i);
				
				if(n!=null && !n.visited)
				{
					/*stack.add(n);
					n.visited=true;
					*/
					
					tmpStack.add(n);
					
					
					
					
 
				}
				
			}
			
			while(!tmpStack.isEmpty()) {
				Node n = tmpStack.pop();
				n.visited = true;
				stack.add(n);
				
				
				
			}
			/**dispaly put data to stack*/
			for(Node s : stack) { 
				changeOfStack += s.data.toString() +" |";
			}
			changeOfStack += "\n";
			
			/**end display stack*/
			
			
		}
		System.out.println("\n\n"+changeOfStack);
	}
 
	public static void main(String arg[])
	{
 
		Node node40 =new Node("Kandy");
		Node node10 =new Node("Kurunegala");
		Node node20 =new Node("Colombo");
		Node node30 =new Node("Skadawatha");
		Node node60 =new Node("Kirirbathgoda");
		Node node50 =new Node("Gampaha");
		Node node70 =new Node("Galle");
 
		node40.addneighbours(node10);
		node40.addneighbours(node20);
		node10.addneighbours(node30);
		node20.addneighbours(node10);
		node20.addneighbours(node30);
		node20.addneighbours(node60);
		node20.addneighbours(node50);
		node30.addneighbours(node60);
		node60.addneighbours(node70);
		node50.addneighbours(node70);
 
		DFSAlgorithm dfsExample = new DFSAlgorithm();
 
		System.out.println("The DFS traversal of the graph using stack ");
		dfsExample.dfsUsingStack(node40);
 
		System.out.println();
 
		// Resetting the visited flag for nodes
		node40.visited=false;
		node10.visited=false;
		node20.visited=false;
		node30.visited=false;
		node60.visited=false;
		node50.visited=false;
		node70.visited=false;
 
	}

}