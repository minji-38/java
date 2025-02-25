package graph;
//49244KB	556ms

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1922_G4_네트워크_연결_안민지{
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
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static Edge[] edgeList;
	static int[] parents;
	static int V,E;
	
	public static void make() {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
//		System.out.println(Arrays.toString(parents));
	}
	public static int find(int a){
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a,int b){
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		parents[aRoot] = bRoot;
		
		return true;
	}	
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        V = Integer.parseInt(br.readLine().trim());
        E = Integer.parseInt(br.readLine().trim());
        parents = new int[V+1];
        edgeList = new Edge[E];
        
        //간선 정보 입력
        for(int i=0; i<E; ++i){
        	StringTokenizer st = new StringTokenizer(br.readLine().trim());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int weight = Integer.parseInt(st.nextToken());
        	edgeList[i] = new Edge(from, to, weight);
        }
        
        
        
//      makeset
        make();
        
//      간선비용이 작은 순서대로 정렬
        Arrays.sort(edgeList);
        int result = 0;				//MST 비용
        int count=0;				// 연결 간선수
        
//      모든 간선을 반복하면서
        for (Edge edge : edgeList) {
//	    	싸이클이 발생하지 않았으면
        	if (union(edge.from,edge.to)) {
        		//true면 Cycle 발생하지 않은 것
//	    		비용 누적
        		result += edge.weight;
//	    		연결수 증가 및 V-1개인지 확인
        		if (++count == V-1) break; //연결이 다 끝났으니 break
        	}
			
		}
        
//      결과 출력
        System.out.println(result);
    }
}// end class
