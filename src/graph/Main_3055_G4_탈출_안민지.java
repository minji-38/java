package graph;
//14156KB	108ms
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
/*
 * 토마토처럼 한번에 큐에 넣고 가는 방법!
 * 초기 세팅 시 물을 먼저 큐에 넣고, 그 다음에 고슴도치를 넣기
 * 물 먼저 이동하는 이유 : 고슴도치 이동 시 물이 찰 예정인 곳은 못간다는 조건, 물이 먼저 퍼지고 이후 고슴도치 이동
 	
 	R*C 의 map
	. - 비어있는곳
	* - 물이 찬 곳
	X - 돌
	D - 비버 굴
	S - 고슴도치 위치
	고슴도치는 매 분마다 상하좌우 인접 이동
	물이 차있는 곳도 매 분마다 상하좌우 인접한 곳 차오름 (. 부분만)
	
	물, 고슴도치는 돌을 통과 ㄴㄴ
	고슴도치는 물 통과 ㄴㄴ
	물은 비버 굴 통과 ㄴㄴ
	
	고도는 물이 찰 예정인 칸으로 이동 불가능
    'D'와 'S'는 하나씩만 주어진다.

 *  물 범람 범위
 *  물은 돌과 비버굴만 통과 못하기 때문에, .과 S 모두 범람 가능
 *  map[nr][nc] == '.' || map[nr][nc] == 'S' 면
 *  map[nr][nc] = '*'
 *  
 *  고슴도치 이동 범위
 *  고슴도치는 돌과 물을 통과하지 못하기 때문에
 *  이동 완료 후 처리
 *  1. 고슴도치가 비버굴로 이동했다면, 이동 시간 출력
 *  2. 이동하지 못했다면 KAKTUS 출력
3 3
D.*
...
..S
KAKTUS
 */
public class Main_3055_G4_탈출_안민지 {

    static int R, C;
    static char[][] map;
    static int[][] time;
    static int[] dr = {-1, 1, 0, 0}; //상하좌우
    static int[] dc = {0, 0, -1, 1};

    static Queue<Node> water = new ArrayDeque<>(); //물 담는 큐
    static Queue<Node> hedgehog = new ArrayDeque<>(); // 고슴도치 이동 위치 담는 큐
    
    static class Node {
        int r, c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        time = new int[R][C];

        for (int i = 0; i < R; i++) {
            String line = in.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                time[i][j] = -1;

                if (map[i][j] == '*') { 
                	water.offer(new Node(i, j));// 물의 시작점
                } else if (map[i][j] == 'S') { 
                    hedgehog.offer(new Node(i, j));// 고슴도치 시작점
                    time[i][j] = 0;
                }
            }
        }

        int result = bfs();
     // 고슴도치의 비버굴 이동 여부에 따라 출력 내용 처리
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    static int bfs() {
    	// 큐 하나로 하고싶었는데 계속 틀려서 두개로 처리 (물->고슴도치 유지가 어려운듯)
    	// 물과 고슴도치의 이동을 하나의 큐에서 처리하면 물이 먼저 이동하지 않는 경우가 발생할 수 있는듯?

        while (!hedgehog.isEmpty()) { //고슴도치가 이동할 수 있는 경로가 남아있는 동안
            // 1. 물 먼저 확장시키기!!@
            int waterSize = water.size();
            while (waterSize-- > 0) {
                Node cur = water.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];
                    // 사방경계 확인
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                    //.과 S 부분에는 범람 가능
                    if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
                    	// 사방 ., S 부분에 * 처리
                        map[nr][nc] = '*';
                        water.offer(new Node(nr, nc)); 
                    }
                }
            }

            // 2. 고슴도치 이동
            int hedgehogSize = hedgehog.size();
            while (hedgehogSize-- > 0) {
                Node cur = hedgehog.poll();

                for (int i = 0; i < 4; i++) {
                    int nr = cur.r + dr[i];
                    int nc = cur.c + dc[i];

                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

                    if (map[nr][nc] == 'D') { // 비버 굴 도착한 경우
                        return time[cur.r][cur.c] + 1;
                    }

                    if (map[nr][nc] == '.' && time[nr][nc] == -1) { 
                    	// .인 땅에 방문하지 않았었다면, 타임 증가(방문처리)시키고 큐에 새로운 위치 넣기
                        time[nr][nc] = time[cur.r][cur.c] + 1;
                        hedgehog.offer(new Node(nr, nc));
                    }
                }
            }
        }
        return -1; // 고슴도치 큐에 내용도 없고 D로 이동도 못한 경우 -1 리턴
    }
}