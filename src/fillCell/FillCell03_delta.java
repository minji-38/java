package fillCell;
import java.util.Scanner;
/**
 * 배열 개수와 좌표를 입력 받아 해당 좌표에 상하좌우에 1을 표시한후 전체 배열을 화면에 출력
 * 경계 검사
 * 
 * 입력 : 
 *  배열의 개수   row좌표, column좌표
 *  ex) 3 0 0 
 * 
 */
public class FillCell03_delta {
//FillCell3의 버전을 좌표값으로 미리 정해두고 하는 방식으로 변경한 내용
	//상하좌우 사방에 1 씌우기, 8방좌표 예시도 작성함
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int r = sc.nextInt();
		int c = sc.nextInt();
		////////////////
		/// 처리 코드 작성
		// 			상 하 좌 우
//		int[] dr = {-1,1,0,0}; //행 이동 조정
//		int[] dc = {0,0,-1,1}; //열 이동 조정 {행 상, 행 좌, 열 좌, 열 우}
		
//		            상 하 좌 우 좌상 우상 좌하 우하
		int[] dr = {-1,1,0,0,-1,-1,1,1}; //행 이동 조정   상 :-1, 하 :1, 좌: -1, 우: 1 로 생각하면 쉬움 (기준이 열이냐 행이냐 따라)
		int[] dc = {0,0,-1,1,-1,1,-1,1}; //열 이동 조정 
		
		
//		int d = 4; //사방이어서 4
		int d = 8; //지정한 곳 제외하고 8곳 다 1찍도록 
		int nr, nc; //다음 좌표
		for (int i = 0; i < d; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if (nr > -1 && nr < N && nc > -1 && nc < N) {// 경계검사 (사방경계) 지정범위 넘어가면 안하도록
				map[nr][nc] = 1;
				
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
