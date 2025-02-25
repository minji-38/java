package graph;


//20552KB	216ms
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/*
5 3 20
10 10 20 20 30
1 3
2 4
5 4

=> 20
 */
public class Main_16562_G4_친구비_안민지{
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
			//오름차순 정렬
			return Integer.compare(this.weight, o.weight);
		}
	}
	
	static Edge[] edgeList;
	static int[] parents;
	static int[] friendCosts; //각각 친구비용
	static int V,E,K; //학생 수, 친구관계수, 가지고 있는 돈
	
	public static void make() {
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
	}
	public static int find(int a){
		if (parents[a] == a) return a;
		return parents[a] = find(parents[a]);
	}
	
	public static boolean union(int a,int b){
		int aRoot = find(a);
		int bRoot = find(b);
		
		if (aRoot == bRoot) return false;
		
		//최소 비용을 요구하는 친구를 부모로 설정하기
		if (friendCosts[aRoot] < friendCosts[bRoot]) {
			parents[bRoot] = aRoot;
		} else {
			parents[aRoot] = bRoot;
		}
		return true;
	}	
	
	
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        friendCosts = new int[V + 1]; //1번 학생부터 시작이니까 +1해주기
        parents = new int[V+1];
        edgeList = new Edge[E];
        
        st = new StringTokenizer(br.readLine().trim());
        for (int i = 1; i <= V; i++) {
			friendCosts[i] = Integer.parseInt(st.nextToken());
		}
        
        //간선 정보 입력
        for(int i=0; i<E; ++i){
        	st = new StringTokenizer(br.readLine().trim());
        	int from = Integer.parseInt(st.nextToken());
        	int to = Integer.parseInt(st.nextToken());
        	int weight = Math.min(friendCosts[from], friendCosts[to]);
        	edgeList[i] = new Edge(from, to, weight);
        }
        make();
//        
////      간선비용이 작은 순서대로 정렬
        Arrays.sort(edgeList);
        
//      모든 간선을 반복하면서
        for (Edge edge : edgeList) { //모두 친구를 만드는게 목적 = 싸이클 돌아도 상관 없어서 그냥 다 유니온 해버림
	    	union(edge.from,edge.to);
		}
        
        int totalCost = 0; //총 친구 비용
        //모든 학생의 대표 루트를 확인하자!
        for (int i = 1; i <= V; i++) {
			if (find(i) == i) { //현재 학생i의 루트 노드가 자기자신인 경우 = 현재 그룹의 대표일때
				totalCost += friendCosts[i]; //해당 그룹의 대표 친구비를 내야하는 친구비에 합산
				//대표 친구는 그룹내에서 제일 적은 친구비를 가진 친구
			}
		}
        
        if (totalCost > K) {
            System.out.println("Oh no");
        } else {
            System.out.println(totalCost);
        }
    }
}// end class
