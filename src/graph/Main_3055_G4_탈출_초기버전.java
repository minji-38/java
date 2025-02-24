package graph;
//큐 하나로 하다가 실패ㅠㅠ 예제는 잘 맞는데 문제 넣고 돌리면 틀리나봄

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
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
 *  큐에 물{'*',r,c}, 고슴도치 {'S',r,c} 넣고 출발
 */

public class Main_3055_G4_탈출_초기버전 {
	
    static int R, C;
    static char[][] map; // 입력받은 맵 정보 배열
    static int[][] time; // 이동하면서 걸린 시간을 담는 배열
    static Queue<Object[]> q = new ArrayDeque<>(); // 물과 고슴도치를 한개의 큐에 함께 저장!
    static int[] dr = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine(), " ");
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        time = new int[R][C];
        
        int hedgehogR = 0, hedgehogC = 0; // 고슴도치 초기 위치 R,C 변수
        
        for (int i = 0; i < R; i++) {
            String line = in.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                time[i][j] = -1;
                
                if (map[i][j] == '*') { // 물의 시작점
                    q.offer(new Object[]{'*', i, j});
                } else if (map[i][j] == 'S') { // 고슴도치 시작점
                	hedgehogR = i;
                	hedgehogC = j;
                    q.offer(new Object[]{'S', i, j});
                    time[i][j] = 0;
                } 
            }
        }
        //물과 고슴도치의 순서를 유지하기 위해서 턴 구분 마커를 추가
        q.offer(new Object[] {'F', -1, -1});
        
        int result = bfs();
        // 고슴도치의 비버굴 이동 여부에 따라 출력 내용 처리
        System.out.println(result == -1 ? "KAKTUS" : result);
    }

    static int bfs() {
//    	for (Object[] array : q) {
//            System.out.println(Arrays.deepToString(array));
//        }
//    	System.out.println("----------------");
        while (!q.isEmpty()) { //큐에 내용이 없으면 종료한다..
            Object[] cur = q.poll(); // 큐에 들어있는 내용 하나 꺼내보기
            char type = (char) cur[0]; // 고슴도치인지 물인지 들어있는 내용
            int r = (int) cur[1];
            int c = (int) cur[2];
            
            if (type == 'F') { //턴 종료 마커를 만나면 해당 턴 종료하기
            	if (!q.isEmpty()) {
            		q.offer(new Object[] {'F',-1,-1});
            	}
            	continue;
            }
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
                
                if (type == '*') { // 타입이 물이면 사방 ., S 부분에 * 처리
                    if (map[nr][nc] == '.' || map[nr][nc] == 'S') {
                    	// 물은 돌('X')과 비버굴('D')을 제외한 공간에 범람함
                        map[nr][nc] = '*'; //.과 S를 만나면 *로 바꿈
                        q.offer(new Object[]{'*', nr, nc});
                    }
                } else if (type == 'S') { // 고슴도치 이동
                    if (map[nr][nc] == 'D') { // 비버의 굴 도착
                        return time[r][c] + 1;
                    }
                    if (map[nr][nc] == '.') {
                    	// 고슴도치는 물과 돌을 통과하지 못하므로 . 만 이동 가능
                        map[nr][nc] = 'S';
                        time[nr][nc] = time[r][c] + 1;
                        q.offer(new Object[]{'S', nr, nc});
                    }
                }
            }
//            for (Object[] array : q) {
//                System.out.println(Arrays.deepToString(array));
//            }
        }
        return -1; //고슴도치가 비버굴로 이동 못하면 -1 리턴
    }
}