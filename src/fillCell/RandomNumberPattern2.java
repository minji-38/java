package fillCell;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
// boolean 사용 안하고 int로 보완한 내 코드
/**
 * 가로, 세로의 길이가 N인 N x N 정사각 행렬이 있다. 
 * 이 행렬의 각각의 값으로서 0에서 9 사이의 수가 무작위로 넣어진다고 하자. 
 * 이 때 그 행렬 내에서 주위를 둘러싸고 있는 다른 모든 수들 보다 
 * 큰 수와 작은 수가 각각 몇 개인지를 구하는 프로그램을 작성하여라
 * 
 * [제한 조건]
 * 1. N은 3 이상 50 이하의 정수이다.
 * 2. 행렬의 가장자리에 있는 수는 8개의 수로 둘러싸여 있지 않으므로
 *    "주위를 둘러싸고 있는 다른 모든 수들보다 큰 수, 혹은 작은 수"가 될 수 없다.
 * [입력]
 * 입력은 다음과 같이 구성되어 있다.
 * 첫 번째 줄에는 테스트 케이스의 개수 T가 주어진다.
 * 그 다음 T 개의 테스트 케이스가 차례로 주어진다. 
 * 각 테스트 케이스는 다음과 같이 구성 되어 있다. 
 *    첫 줄에 정 사각 행렬의 크기 N이 주어진다. 
 *    그 다음 N 줄에 걸쳐 정 사각 행렬의 각 행의 값이 순서대로 주어진다. 
 * [출력]
 * 각 줄은 #x로 시작하고 (x는 테스트 케이스 번호) 공백을 하나 둔 다음, 
 * 문제에서 요구한 큰 수의 개수, 
 * 그리고 작은 수의 개수를 공백을 두어 차례로 출력한다. 
 *
 * [결과]
 * #1 6 4
 * #2 1 1
 */
public class RandomNumberPattern2 {
	static int[][] matrix;
	
	//8방향으로 좌표 설정
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
    
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("src/fillCell/RandomNumberPattern.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine().trim()); // **공백 제거**
        
        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine().trim()); // **공백 제거**
            matrix = new int[N][N];
            
            // 행렬 입력 받기
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(st.nextToken().trim()); // **공백 제거**
                }
            }
            
            int big = 0;
            int small = 0;

         // 내부 숫자만 탐색 (가장자리는 제외)
            for (int r = 1; r < N - 1; r++) {
                for (int c = 1; c < N - 1; c++) {
                    int current = matrix[r][c];
                    int big_count = 0;  // 1이면 큰 수, 0이면 아님
                    int small_count = 0; // 1이면 작은 수, 0이면 아님

                    // 8방향 탐색
                    for (int d = 0; d < 8; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];

                        if (matrix[nr][nc] > current) small_count++; 
                        if (matrix[nr][nc] < current) big_count++; 
                    }

                    if (big_count == 8) { //8개 중에 가장 큰 수였으면 big++
                    	big++; // 큰 수 개수 추가
                    }
                    if (small_count == 8) {
                    	small++; // 작은 수 개수 추가
                    }
                }
            }

            System.out.println("#" + test_case + " " + big + " " + small);
        }
    }
}