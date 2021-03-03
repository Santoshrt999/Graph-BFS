package com.graphs;

import java.util.*;

public class Bridge {
	
	int v;
	HashMap<Integer, List<Integer>> adjMap;
	int time=0;
	static final int NIL =-1;
	
	
	
	public Bridge(int v) {
		this.v=v;
		adjMap = new HashMap<>();
		for(int i=0; i<v; i++) {
			adjMap.put(i, new LinkedList<>());
		}
	}
	
	
	
	void addEdge(int v, int w) {
		adjMap.get(v).add(w);
		adjMap.get(w).add(v);
	}
	
	
	void bridge() {
		
		int[] disc = new int[v];
		boolean[] visited = new boolean[v];
		int[] low = new int[v];
		int[] parent = new int[v];
		
		for(int i=0; i<v; i++) {
			
			parent[i]=NIL;
			visited[i]=false;
			
			if(!visited[i])
				dsfBdrigeUtil(i, low, disc, parent, visited);
		}
		
		
	}

	private void dsfBdrigeUtil(int u, int[] low, int[] disc, int[] parent, boolean[] visited) {
		
		
		visited[u]=true;
		
		disc[u]=low[u]=++time;
		
		List<Integer> list = adjMap.get(u);
		Iterator<Integer> itr = list.listIterator();
		
		while(itr.hasNext()) {
			int v = itr.next();
			
			
			if(!visited[v]) {
				
				parent[v]=u;
				//dfs
				dsfBdrigeUtil(v, low, disc, parent, visited);
				
	             // Check if the subtree rooted with v has a 
                // connection to one of the ancestors of u 
                low[u]  = Math.min(low[u], low[v]); 
  
                // If the lowest vertex reachable from subtree 
                // under v is below u in DFS tree, then u-v is 
                // a bridge 
                if (low[v] > disc[u]) 
                    System.out.println(u+" "+v); 
             
					
			} else if (v != parent[u]) {
				
				
				low[u]=Math.min(low[v], disc[u]);
			}
				
			
		}
		
	}



	public static void main(String[] args) {
		

		 System.out.println("Bridges in first graph "); 
		 Bridge g1 = new Bridge(5); 
	        g1.addEdge(1, 0); 
	        g1.addEdge(0, 2); 
	        g1.addEdge(2, 1); 
	        g1.addEdge(0, 3); 
	        g1.addEdge(3, 4); 
	        g1.bridge(); 
	        System.out.println(); 
	  
	        System.out.println("Bridges in Second graph"); 
	        Bridge g2 = new Bridge(4); 
	        g2.addEdge(0, 1); 
	        g2.addEdge(1, 2); 
	        g2.addEdge(2, 3); 
	        g2.bridge(); 
	        System.out.println(); 
	  
	        System.out.println("Bridges in Third graph "); 
	        Bridge g3 = new Bridge(7); 
	        g3.addEdge(0, 1); 
	        g3.addEdge(1, 2); 
	        g3.addEdge(2, 0); 
	        g3.addEdge(1, 3); 
	        g3.addEdge(1, 4); 
	        g3.addEdge(1, 6); 
	        g3.addEdge(3, 5); 
	        g3.addEdge(4, 5); 
	        g3.bridge(); 
	    } 
	} 
