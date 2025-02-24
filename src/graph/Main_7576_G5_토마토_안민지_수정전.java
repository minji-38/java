package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * -1 : 토마토 없음, 0 : 안익음, 1 : 익음
 * 인접 공간에 있는 토마토 (왼,오,앞,뒤)는 익은 토마토의 영향을 받아 익는다...
 * [최종 출력]
 * 0인 토마토가 모두 익는데 걸리는 최단 시간 출력
 * 익을 수 없는 토마토가 있어도 => -1
 * 토마토가 하나 이상 있는 경우만 입력으로 주어진다.
 * 
	5 5
	-1 1 0 0 0
	0 -1 -1 -1 0
	0 -1 -1 -1 0
	0 -1 -1 -1 0
	0 0 0 0 0
	
 * 익은 토마토가 여러개인 경우를 따져서 처리하기
 * 
 * 익은 토마토가 있는 위치부터 좌표값 담고, 해당 반복하기...?
 * 
 * 모든 초기 위치를 Queue 에 초기값으로 다 담기 = 멀티 BFS방식 (점진적으로 퍼져나감)
 */
public class Main_7576_G5_토마토_안민지_수정전 {

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] distance = new int[N][M];
		boolean[][] visited=new boolean[N][M];
		
		Queue<int[]> q = new ArrayDeque<int[]>();
//		맵 정보를 입력 받는다.  
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j)-'0'; //문자데이타를 숫자 데이타로 받아오기위해 -0해줌
				distance[i][j] = -1;
				if (map[i][j] == 1) {
					q.offer(new int[] {i,j});
					distance[i][j] = 0;
				} else if (map[i][j] == -1) {
					distance[i][j] = -1;
				}
			}
		}
//		4방향 탐색을 위한 delta 배열 선언
		int[] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		visited[0][0] = true;
//		사방 탐색을 위한 현재 좌표와 다음좌표 거리를 위한 변수 선언하기 
		int r, c, dist, nr, nc;
		
//		큐에 탐색할 노드가 없을때까지 탐색 시도
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			r = cur[0];
			c = cur[1];
//			사방을 돌면서 다음 좌표를 구하고
			for (int i = 0; i < 4; i++) { //4방향 돌면서 처리
				nr = r+dr[i];
				nc = c+dc[i];
				if (nr>-1 && nr<N && nc>-1 && nc<M && !visited[nr][nc] && map[nr][nc] == 1) {
					if (nr==N-1 && nc==M-1) {
						//결과 출력 후 종료 
						//결과
						System.out.println();
						return;
					}
//					도착 위치가 아니면 다음 좌표를 탐색하기 위해 방문 처리후 큐에 넣기
					visited[nr][nc] = true;
//					q.offer(new int[] {nr,nc,);
				}
				
			}
		}
	}

}
