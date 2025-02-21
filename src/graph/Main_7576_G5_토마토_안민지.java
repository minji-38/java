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

public class Main_7576_G5_토마토_안민지 {

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        
        int M = Integer.parseInt(st.nextToken()); // 열의 개수 (가로)
        int N = Integer.parseInt(st.nextToken()); // 행의 개수 (세로)
        
        int[][] map = new int[N][M];         // 토마토 상태를 저장하는 배열
        int[][] distance = new int[N][M];    // 익는데 걸리는 시간을 저장하는 배열
        
        Queue<int[]> q = new ArrayDeque<>(); // BFS 탐색을 위한 큐 (좌표를 저장)
        
        // 토마토 맵 입력을 받으며 초기값 설정
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(in.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if (map[i][j] == 1) { // 익은 토마토인 경우
                    q.offer(new int[]{i, j}); // 초기 BFS 시작점으로 설정
                    distance[i][j] = 0;       // 익은 토마토의 시작 거리는 0
                } else if (map[i][j] == 0) {
                    distance[i][j] = -1;      // 익지 않은 토마토는 -1로 초기화
                }
                // map[i][j] == -1 (빈 칸)은 distance 배열에서도 기본값인 0을 유지
            }
        }

        // 상, 하, 좌, 우 방향 벡터
        int[] dr = {-1, 1, 0, 0}; // 행 이동 (위, 아래)
        int[] dc = {0, 0, -1, 1}; // 열 이동 (왼, 오른)
        
        // BFS 탐색 시작
        while (!q.isEmpty()) {
            int[] cur = q.poll(); // 현재 좌표
            int r = cur[0];
            int c = cur[1];
            
            // 사방 탐색
            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d]; // 다음 행 좌표
                int nc = c + dc[d]; // 다음 열 좌표
                
                // 유효한 좌표인지 확인 & 방문하지 않은 익지 않은 토마토(0)만 처리
                if (nr >= 0 && nr < N && nc >= 0 && nc < M && distance[nr][nc] == -1) {
                    distance[nr][nc] = distance[r][c] + 1; // 거리(날짜) 갱신
                    q.offer(new int[]{nr, nc}); // 다음 탐색을 위해 큐에 추가
                }
            }
        }

        // 결과 계산
        int maxTime = 0; // 최단 시간 계산을 위한 변수
        boolean tomato_ok = false; // 익지 못한 토마토가 남아 있는지 확인
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (distance[i][j] == -1) { // 익지 않은 토마토가 남아 있는 경우
                	tomato_ok = true;
                }
                maxTime = Math.max(maxTime, distance[i][j]); // 최장 거리 갱신
            }
        }
        
        //  최종 출력
        if (tomato_ok) {
            System.out.println(-1); // 익지 못한 토마토가 있다면 -1 출력
        } else {
            System.out.println(maxTime); // 모두 익는데 걸린 최단 시간 출력
        }
    }
}

