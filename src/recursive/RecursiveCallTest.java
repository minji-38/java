package recursive;
/**
 * 재귀함수 (재귀함수의 반복횟수를 정확히 알면 for문으로 변경가능)
 * 	- 함수 내에서 해당 함수를 또 호출
 * 	- 반복의 depth가 랜덤일 때 사용 (인자 or 배열로 depth를 컨트롤한다.)
 * 	-
 * 		기저조건 : 재귀 함수를 중단하는 조건
 * 		유도파트 : 재귀 함수를 진행하는 파트
 * 
 */
public class RecursiveCallTest {
	static int N = 10;
	
	//Bottom -> Up
//	public static int sum1(int i) {
//		// 기저조건 : 재귀함수 종료 조건
//		if (i == N) return N;
//		return sum1(i+1)+i;
//	}
//	
	public static void print(int num) {
		if (num > N) return;
		System.out.print(num + " ");
		print(num + 1);
	}
	public static void main(String[] args) {
		for (int i = 0; i <= N; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		print(0);
		System.out.println();
		
		for (int i = N; i > -1; i--) {
			System.out.print(i+ " ");
		}
		System.out.println();
		print2(N);
	}
	public static void print2(int num) {
		if (num == -1) return;
		System.out.print(num+" ");
		print2(num -1);
	}

}
