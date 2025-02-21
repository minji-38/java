package graph;
//DFS로 짜본 코드!~ BFS로 바꿔보기!
//16372KB	136ms
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
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
public class Main_10026_G5_적록색약_dfs {
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
					dfs(i,j); 
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
					dfs(i,j); 
					dltonism++; //구역이 바뀌니까 1증가
				}
			}
		}
        System.out.println(nonDltonism +" "+dltonism);
    }
 
    public static void dfs(int r, int c ){
        visits[r][c] = true;
        char color = map[r][c];
        //같은컬러면 계속 탐색, 아니면 탐색 중지
        for (int i = 0; i < 4; i++) {
        	//경계검사
        	int nr = r + dr[i];
        	int nc = c +dc[i];
			
        	if (nr<0 || nr>=N || nc<0|| nc>=N) continue; //경계면 나가기
        	if (!visits[nr][nc] && map[nr][nc] == color) {
        		//방문안하고 같은 색이면
        		dfs(nr, nc);
        	}
		}
    }
}
