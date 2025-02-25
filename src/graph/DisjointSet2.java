package graph;

import java.util.ArrayList;
import java.util.List;

import graph.MST_Kruskal.Edge;

public class DisjointSet2 {
	static int N,E,K;
	static int[] parents; //부모배열
	static int[] friendCosts; //각각 친구비용
	static List<Edge> edges = new ArrayList<>();
	
	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;			//비용
		public Edge(int start, int end, int weight) {
			super();
			this.from = start;
			this.to = end;
			this.weight = weight;
		}
		public int compareTo(Edge o) {
			//오름 차순으로 정렬
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	public static void make() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	

	public static int find(int v) {
		if (parents[v] == v) return v;
		return parents[v] = find(parents[v]);
	}
	
	
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		parents[aRoot] = bRoot;
		return true;
		
	}
	public static void main(String[] args) {
		
	}	
}
