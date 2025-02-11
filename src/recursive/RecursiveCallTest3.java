package recursive;
// 팩토리얼을 해봅시다!

/**
 * 재귀함수 (재귀함수의 반복횟수를 정확히 알면 for문으로 변경가능)
 * 	- 함수 내에서 해당 함수를 또 호출
 * 	- 반복의 depth가 랜덤일 때 사용 (인자 or 배열로 depth를 컨트롤한다.)
 * 	-
 * 		기저조건 : 재귀 함수를 중단하는 조건
 * 		유도파트 : 재귀 함수를 진행하는 파트
 * 
 */

//9!까지는 하단 일반 재귀함수로 가능. 10!부터는 처리값이 많아져서 성능이 낮아짐 swap사용
public class RecursiveCallTest3 {
	static int fac = 5;
	
	public static int fac1(int n) {
		//bottom -> top 1*2*3*4*5 재귀함수
		if (n == fac) return n;
		return n * fac1(n+1);
	}
	
	//5! 을 top -> down으로 재귀함수 처리하기
	public static int fac2(int n) {
		//top -> down 5*4*3*2*1 재귀함수
		if (n == 1) return 1;
		return n * fac2(n-1);
	}
	public static void main(String[] args) {
		int result = 1;

		//top->down for문
		for (int i = fac; i > 0; i--) {
			result *= i;
		}
		System.out.println(result); //for문 값
		System.out.println(fac1(1)); //재귀함수 값
		System.out.println(fac2(fac)); //재귀함수 값
	}


}
