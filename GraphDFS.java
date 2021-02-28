package com.graphs;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphDFS {
	
	
	int time=-1;
	int V; //no. of Vertices (nodes)
	private Map<Integer, List<Integer>> adjacencyMap;
	
	GraphDFS(){
	}
	
	GraphDFS(int v){
		V = v;
		adjacencyMap = new HashMap<>();
		for (int i=0; i<v; ++i)
            adjacencyMap.put(i, new LinkedList<>());
	}
	
	void addEdge(int vertices, int edges) {
		List<Integer> l = adjacencyMap.get(vertices);
		l.add(edges);
	}
	
	
	//recursively call all the nodes, depending whether they are visited or not.
	void DFS () {
		boolean visited[] = new boolean[V];
		
		int[] arrival = new int[V];
		int[] departure = new int[V];
		
		for(int i=0; i<V; i++) {
			if(visited[i]==false) {
			DfsUtil(i, visited, arrival, departure);
			}
		}
		
	}
	
	
	//get the vertices adjacent to the node which we pass
	private void DfsUtil(int node, boolean[] visited, int[] arrival, int[] departure) {
		
		arrival[node]=++time;
		
			visited[node] = true;
		System.out.println(node + " " + "arrivalTime is " + arrival[node]);
		
		List l = adjacencyMap.get(node);
		Iterator<Integer> itr = l.listIterator();
		while(itr.hasNext()) {
			int n = itr.next();
			
			if(!visited[n])
				DfsUtil(n, visited, arrival, departure);
			
		}
		
		
		departure[node]=++time;
		System.out.println(node + " " + "departureTime is " + departure[node]);
		
		
	}


	public static void main(String[] args) {
		
		GraphDFS g = new GraphDFS(4);
		
	    g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        
        g.DFS();
 
		
	}

}
