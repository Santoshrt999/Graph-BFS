package com.graphs;

import java.util.*;

public class GraphBFS {
	
	int V; //no. of Vertices (nodes)
	private Map<Integer, List<Integer>> adjacencyMap;
	
	GraphBFS(){
		
	}
	
	
	GraphBFS(int v){
		V = v;
		adjacencyMap = new HashMap<>();
		for (int i=0; i<v; ++i)
            adjacencyMap.put(i, new LinkedList<>());
	}
	
	void addEdge(int vertices, int edges) {
		List<Integer> l = adjacencyMap.get(vertices);
		l.add(edges);
	}
	
	//run BFS from a source node
	
	void BFS(int s) {
		
		//the fishing net
		Queue<Integer> queue = new LinkedList<>();
		
boolean visited[] = new boolean[V];
		visited[s]=true;
		queue.add(s);
		
		//while queue is not empty Deque a vertex and print it
		while(!queue.isEmpty()) {
			
			   // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s+" ");
			
			List l = adjacencyMap.get(s);
			Iterator<Integer> i = l.listIterator();
			while(i.hasNext()) {
				int node = i.next();
				
				if(!visited[node]) {
					visited[node]=true;
					queue.add(node);
				}
					
			}
		}
	}
	
public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	GraphBFS g = new GraphBFS(4);
	
	   g.addEdge(0, 1);
       g.addEdge(0, 2);
       g.addEdge(1, 2);
       g.addEdge(2, 0);
       g.addEdge(2, 3);
       g.addEdge(3, 3);
	
	g.BFS(2);
	
	   

	}

}
