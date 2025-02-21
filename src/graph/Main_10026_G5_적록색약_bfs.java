package graph;
//BFS로 바꿨다!

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
/**
 * - map을 구역 나누기 문제 
 *   - 같은 구역인 경우 count세기 
 *   - 모든 노드를 1번씩만 탐색하기 때문에 dfs, bfs 모두 가능 
 *   - 전체 맵을 반복하면서 
 *     방문하지 않은 노드라면 그 노드 부터 같은 구역인지 (dfs, bfs) 탐색하기 
 *     
 * - 적녹색약
 *   1. 비적녹색약인을 위한 버전으로 구역 탐색하고 
 *   2. 적녹색약인을 위해 visits 초기화 하고
 *      map의 정보를 G->R로 바꾸거나 R->G으로 바꾼후 구역 탐색하기 
 */
public class Main_10026_G5_적록색약_bfs {
	static int N;
    static char map[][];
    static boolean visits[][];
    static int dr[] = {-1,0,0,1};
    static int dc[] = {0,1,-1,0};
 
    public static void main(String args[]) throws Exception{
 
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new char[N][N];
        visits = new boolean[N][N];
 
        for (int i=0; i<N; i++){
        	//toCharArray() : 문자열을 문자 배열로 변환하는 함수
        	map[i] = in.readLine().toCharArray();
        }
        int dltonism = 0, nonDltonism = 0, cnt = 0;
        //비적녹색약인 위한 탐색
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visits[i][j]) { //방문하지 않은 노드는 새로운 구역
					bfs(i,j); 
					nonDltonism++; //구역이 바뀌니까 1증가
				}
			}
		}
        //적녹색약인을 위한 탐색
        //visits 초기화
        visits = new boolean[N][N]; //한번 하는경우 이 방법
        //매번 초기화 해야한다면 하단 방법이 더 빠름
//        for (int i = 0; i < N; i++) {
//			Arrays.fill(visits[i], false);
//		}
        //G->r or R->G 변경
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'G' ) {
					map[i][j] = 'R';
				}
			}
		}
        //구획탐색
        for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visits[i][j]) { //방문하지 않은 노드는 새로운 구역
					bfs(i,j); 
					dltonism++; //구역이 바뀌니까 1증가
				}
			}
		}
        System.out.println(nonDltonism +" "+dltonism);
    }
 
    //bfs로 바꾼 버전
    public static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        visits[r][c] = true; // 시작점 방문 처리
        q.offer(new int[]{r, c}); // 큐에 좌표를 추가

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0]; // 현재 행
            int cc = cur[1]; // 현재 열

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nr =cr + dr[i];
                int nc = cc + dc[i];

                // 경계 체크 및 같은 색상, 미방문 확인
                if (nr >= 0 && nr < N && nc >= 0 && nc < N 
                    && !visits[nr][nc] && map[nr][nc] == map[cr][cc]) {
                    visits[nr][nc] = true; // 방문 처리
                    q.offer(new int[]{nr, nc}); // 큐에 추가
                }
            }
        }
    }

}
