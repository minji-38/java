package divideconquer;
//34472KB	340ms (분할정복)
import java.util.Scanner;
/*
	1. 종이 전체를 담는 배열 만들기[N][N]
	
	2.색종이 영역별 탐색 + 분할 함수
	색 탐색 함수 호출 -> 일단 해당 영역 탐색
	-하나라도 틀리면 함수호출 부분에서 리턴되니까 하단 비교 안함
	[x][y] == 0 이면 white++;
	[x][y] == 1 이면 blue++'
	
	2-1. 색이 다르면, 4등분하기 (재귀함수)
	[1사분면]  [2사분면]  
	[3사분면]  [4사분면]  
	각각 영역의 크기 ==> 전체크기의 반 = 전체 / 2
	전체가 8*8이었다면, 절반은 4*4의 영역
	전체크기/2 가 newSize라고 한다면
	x,y 좌표가 0이라면, 
	1: x,0,전체크기의 절반
	2: x(x좌표는 그대로 = 같은줄이니까), y+newSize (1사분면 옆이니까),newSize
	3: x+newSize,y,newSize,newSize
	4: x+newSize,y+newSize,newSize
	의 정보로 2-1 다시 호출 size는 계속 재귀호출할때마다 갱신되니까 ~~~
	
	3. 색종이 내용 검증 함수
	(x,y,색종이 사이즈)를 넣고
	x,y for문으로 색종이 사이즈만큼 돌면서 색상 비교
	첫번째 들어온 값 종이[x][y]의 값으로 기준을 만들어서 모두 그것과 같으면 동일한 컬러로 채워진 종이
	하나라도 틀리면 리턴
 */
public class Main_2630_S2_색종이_만들기_안민지 {

    static int[][] paper;
    static int white = 0; // 전체 영역이 0인 영역의 개수
    static int blue = 0;  // 전체 영역이 1인 영역의 개수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 한 변의 길이
        paper = new int[N][N]; // 받아온 길이에 맞게 미리 배열 길이 설정

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                paper[i][j] = sc.nextInt();
            }
        }

        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);

        sc.close();
    }

    private static void divide(int x, int y, int size) {
        if (checkColor(x, y, size)) {
            // 모두 동일한 색상일 때 첫번째가 0이면 다 0인거니까 하얀색 색종이
            if (paper[x][y] == 0) {
                white++;
            } else { //아니면 파랑색 색종이
                blue++;
            }
            return;
        }
        // 색상이 다를 때 4등분하여 재귀 호출
        // 처음 시작 위치를 고정시켜놓고 바뀌는 size에 따라서 재귀호출
        int newSize = size / 2;
        divide(x, y, newSize);// 1사분면
        divide(x, y + newSize, newSize);// 2사분면
        divide(x + newSize, y, newSize);// 3사분면
        divide(x + newSize, y + newSize, newSize);// 4사분면
    }

    // 해당 영역의 색상이 동일한지 체크하는 함수
    private static boolean checkColor(int x, int y, int size) {
        int color = paper[x][y]; // 첫번째 값을 기준으로 잡고 해당 기준과 다르면 return시키기
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (paper[i][j] != color) {
                    return false; // 하나라도 다르면 false
                }
            }
        }
        return true; // 모두 동일하면 true
    }
}

