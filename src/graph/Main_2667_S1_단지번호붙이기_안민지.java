package graph;
//14396KB	116ms
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Main_2667_S1_단지번호붙이기_안민지 {
    static int N;
    static char map[][];
    static boolean visits[][];
    static int dr[] = {-1, 0, 0, 1};
    static int dc[] = {0, 1, -1, 0};
    static ArrayList<Integer> cnt = new ArrayList<>();
    static int danji = 0;

    public static void main(String args[]) throws Exception {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(in.readLine());
        map = new char[N][N];
        visits = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = in.readLine().toCharArray();
        }

        // 미리 초기값을 넣어줘야 함
        for (int i = 0; i < N * N; i++) {
            cnt.add(0); // 초기값 0으로 세팅
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visits[i][j] && map[i][j] == '1') { 
                    bfs(i, j);
                    danji++; // 새로운 단지 번호 증가
                }
            }
        }
        cnt.removeIf(num -> num == 0); // 0인 값 삭제
        Collections.sort(cnt);// 오름차순으로 정렬
        System.out.println(cnt.size()); // 사용된 단지만 출력
        for (int i = 0; i < cnt.size(); i++) {
        	System.out.println(cnt.get(i));
		}
    }

    public static void bfs(int r, int c) {
        Queue<int[]> q = new ArrayDeque<>();
        visits[r][c] = true; 
        q.offer(new int[]{r, c});
        
        cnt.set(danji, cnt.get(danji) + 1); // 시작점도 단지에 포함

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N 
                    && !visits[nr][nc] && map[nr][nc] == '1') {
                    
                    visits[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                    cnt.set(danji, cnt.get(danji) + 1); // 단지 내 집 개수 증가ㄴ
                }
            }
        }
    }
}
