package graph;

import queue.QueueInterface;
import stack.*;

public class GraphTest {

	public static void main(String[] args) {
		
		DirectedGraph<String> graph = new DirectedGraph<>();
		//ADDING VERTICIES
		/*
		graph.addVertex("LAX");
		graph.addVertex("PHX");
		graph.addVertex("LAS");
		graph.addVertex("IAH");
		graph.addVertex("DEN");
		graph.addVertex("ORD");
		graph.addVertex("DCA");
		graph.addVertex("DFW");
		graph.addVertex("MSP");
		*/
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");
		graph.addVertex("I");
		graph.addVertex("J");
		graph.addVertex("K");
		graph.addVertex("L");
		graph.addVertex("M");


		
		//ADDING EDGES
		/*
		graph.addEdge("LAX", "PHX", 370);
		graph.addEdge("LAX", "LAS", 236);
		graph.addEdge("LAX", "DEN", 862);
		graph.addEdge("DEN", "LAS", 628);
		graph.addEdge("MSP", "DEN", 680);
		graph.addEdge("PHX", "DFW", 868);
		graph.addEdge("LAS", "IAH", 1222);
		graph.addEdge("LAS", "ORD", 1514);
		graph.addEdge("ORD", "MSP", 334);
		graph.addEdge("DFW", "IAH", 224);
		graph.addEdge("IAH", "DCA", 1208);
		graph.addEdge("DCA", "ORD", 334);
		*/
		graph.addEdge("A","B",5);
		graph.addEdge("B","C",1);
		graph.addEdge("C","D",3);
		graph.addEdge("D","E",4);
		graph.addEdge("F","B",2);
		graph.addEdge("F","I",12);
		graph.addEdge("B","G",4);
		graph.addEdge("E","G",4);
		graph.addEdge("J","G",3);
		graph.addEdge("J","K",2);
		graph.addEdge("K","H",4);
		graph.addEdge("H","G",3);
		graph.addEdge("G","I",1);
		graph.addEdge("L","J",1);
		graph.addEdge("M","L",7);

		System.out.println("----------------------------------------------");
		
		//BREADTH
		System.out.println("Breadth First Traversal: ");
		QueueInterface<String> line = graph.getBreadthFirstTraversal("A");
		while(!line.isEmpty()) {
			System.out.println(line.dequeue());
		}
		System.out.println("----------------------------------------------");
		
		//DEPTH
		System.out.println("Depth First Traversal: ");
		QueueInterface<String> line2 = graph.getDepthFirstTraversal("A");
		while(!line2.isEmpty()) {
			System.out.println(line2.dequeue());
		}
		System.out.println("----------------------------------------------");
			
		//TOPOLOGICAL
		System.out.println("Topological Sort: ");
		try {
			StackInterface<String> stack = graph.getTopologicalOrder();
			while(!stack.isEmpty()) {
				System.out.println(stack.pop());
			}
			
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		System.out.println("----------------------------------------------");
		
		//CHEAPEST PATH
		System.out.println("Cheapest Path: ");
		StackInterface<String> path = new LinkedStack<>();
		System.out.println(graph.getCheapestPath("F", "M", path));
		while(!path.isEmpty())
			System.out.println(path.pop());
		
		

	}

}
