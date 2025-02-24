package graph;
//15164KB	852ms	
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 가로 R, 세로 C인 표가 주어진다.
 * 해당 표 안에는 한칸에 한글자의 대문자 알파벳이 들어있고, 빈 칸은 없다~~
 * 알파벳을 중복없이 이동한다고 할때, 최대 이동 칸수는?
 * 네방향을 보고 알파벳 중복체크를하고, 갈 수 없으면 다시 돌아가고...
 * 즉 모든 경로를 다 확인해보고 가야한다아아아
 */

public class Main_1987_G4_알파벳_안민지 {

    static int R, C, max = 0;
    static char[][] map;
    static boolean[] alphabet; // 알파벳 방문 체크
    static int[] dr = {-1, 1, 0, 0}; // 상하좌우
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        alphabet = new boolean[26]; // 알파벳 개수만큼 배열 생성 (A-Z)

        for (int i = 0; i < R; i++) {
            map[i] = in.readLine().toCharArray();
        }

        // 시작점 초기화
        alphabet[map[0][0] - 'A'] = true;
        dfs(0, 0, 1); // 초기 이동 칸 수는 1 (시작점을 포함해야하니까)

        System.out.println(max);
    }

    //					   현재 행  현재 열  현재까지 이동한 칸 수
    public static void dfs(int r, int c, int count) {
        max = Math.max(max, count); // 최대 이동 칸 수 갱신

        // 4방향 탐색 (상하좌우)
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            // 경계 검사
            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

            // 방문하지 않은 알파벳이면 이동, 방문했었으면 백트래킹
            if (!alphabet[map[nr][nc] - 'A']) {
                alphabet[map[nr][nc] - 'A'] = true; // 방문 처리
                dfs(nr, nc, count + 1); // 다음 경로 탐색
                alphabet[map[nr][nc] - 'A'] = false; // 백트래킹 써서 이전으로 돌아가게 처리
            }
        }
    }
}

