package com.bfs_dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BFS {
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
	
	public static void main(String[] args) {
		Node node40 =new Node("Kandy");
		Node node10 =new Node("Kurunegala");
		Node node20 =new Node("Colombo");
		Node node30 =new Node("Kadawatha");
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
 
		BFS bfsExample = new BFS();
 
		System.out.println("The BFS traversal of the graph using Queue ");
		bfsExample.bfsUsingQueue(node40);
 
		
		// Resetting the visited flag for nodes
		node40.visited=false;
		node10.visited=false;
		node20.visited=false;
		node30.visited=false;
		node60.visited=false;
		node50.visited=false;
		node70.visited=false;

	}

	private void bfsUsingQueue(Node node) {
//		Queue<Node> queue = new PriorityQueue<Node>();
		String changeOfQueue = "";
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		int queueStep = 1;
		
		while(!queue.isEmpty()) {
			Node element = queue.remove();
//			System.out.println(element.data);
			
			System.out.print(element.data+" > ");
 
			
			if(element.data=="Galle") {
				
				break;
			}
			
			List<Node> neighbours=element.getNeighbours();
			
			
			/*******************************************sorting**********/
			class Sortbyname implements Comparator<Node>
		     {
		

				public int compare(Node n1, Node n2) {
					 return n1.data.compareTo(n2.data);
				}
		     }
			Collections.sort(neighbours,new Sortbyname()); 
			/*******************************************end sorting******/

			
			for (int i = 0; i < neighbours.size(); i++) {
				Node n = null;
				n=neighbours.get(i);
				
				
				if(n!=null && !n.visited)
				{

					n.visited=true;
					try {
					queue.add(n);
					
					
					String currQueue =  "Queue "+queueStep+": ";
					queueStep++;
					for(Node s : queue) { 
						currQueue += s.data.toString() +" |";
						}
					changeOfQueue +=currQueue+"\n";
							
					}catch(Exception e) {
						System.out.println(e);
					}
				
				}
				
			}
			

		}
		System.out.println("\n\n"+changeOfQueue);
	
		
	}
	

}