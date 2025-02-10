package fillCell;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * NxN 배열을 위한 기지국(A)와 집(H)가에 대한 정보가 주어진다. 
 * 기지국은 상하좌우 1셀씩만 커버한다. 커버하지 못하는 집의 개수를 출력
 *
 * [제약조건]
 * N은 3~15이하
 * 
 * [입력]
 * 첫줄은 테스트 케이스 수(T)가 주어진다.
 * 두번째 줄은 배열 크기(N)이 주어지고
 * 세번째 줄부터 N개의 기지국 정보가 제공된다. 
 * 
 * [출력 결과]
 * #1 4
 * #2 5
 * #3 9
 */
public class BaseStation1 {
    static int AnswerN=0;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("src/fillCell/basestation1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1; test_case<=T; test_case++){
			//테스트케이스마다 결과 변수를 초기화해줘야한다. 그렇지 않으면 이전 값 때문에 결과가 달라진다.
			AnswerN=0; 
			int N = Integer.parseInt(br.readLine());
			//입력 처리
			//데이터가 문자 데이터이므로 char 배열 선언
			char[][] map = new char[N][N]; 
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					//String 타입을 char로 변경하는 함수는 없고 String에 charAt(index)를 통해 특정 문자를 추출한다.
					map[i][j] = st.nextToken().charAt(0);
				}
			}
			
			//상하좌우 방향으로 좌표값 처리하기 위한 변수 선언
			 int[] dr = {-1, 1, 0, 0};
			 int[] dc = {0, 0, -1, 1};
			 int nr = 0, nc = 0, d = 4;
			 
			//구현하기
			//1. 기지국을 찾아 상하좌우에 커버됐다고 표시하기
				//1-1. 맵 전체를 탐색하면서
			 	for (int r = 0; r < N; r++) { //행 탐색
					for (int c = 0; c < N; c++) { //열 탐색
						//1-2. 기지국(A)를 찾는다.
						if (map[r][c] =='A') {
							//1-3. 기지국의 상하좌우 좌표를 얻고 경계내에 있는지 검사
							for (int i = 0; i < d; i++) { //사방(상하좌우) 처리
								nr = r+dr[i];
								nc = c+dc[i];
								//경계 안에 있고
								if (nr>-1 && nr<N && nc>-1 && nc<N && map[nr][nc] == 'H') {
									//1.4 상하좌우에 커버됐다고 표시한다
									map[nr][nc] = 'X';
								}
							}
						}
					}
			 	}
			 //2. 맵 전체를 탐색하면서 커버 안된 집의 개수를 센다.
			 	for (int r = 0; r < N; r++) {
			 		for (int c = 0; c < N; c++) {
			 			if(map[r][c] == 'H') {
			 				AnswerN++;
			 			}
					}
				}
			 //출력
			System.out.println("#"+test_case+" "+AnswerN);
		}
	}//end main
	private static void test(int i) {
		// TODO Auto-generated method stub
		i += 10;
		System.out.println(i);
	}
}//end class









