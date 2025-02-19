package subset;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 
 * @author 
 * 시간 복잡도 2^n
 *
 */
public class SubsetTest3_외워 {
	static int N, totalCnt;
	static int[] input;
	static int[] numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		long start = System.currentTimeMillis();
		subset(0,0);
		long end = System.currentTimeMillis();
		System.out.printf("총 경우의 수 : %d 시간 : %dms",totalCnt,end-start);
		
	}
	/*
	 * depth 	: 현재 고려중인 원소의 인덱스
	 * len 		: 집합에서 선택한 원소 수 (부분집합의 원소 수)
	 */
	private static void subset(int depth, int len) {
		//모든 원소에 대해서 선택 or 비선택을 통해 subset을 만들기 때문에
		//depth가 N이 됐을때 1개의 subset이 완성됨
		if (depth == N) {
			//subset이 완성됐으므로 필요한 코드 작성
			totalCnt++;
			//copyOfRange(배열,시작위치,len) 시작위치부터 len 개수를 배열 복사
			System.out.println(Arrays.toString(Arrays.copyOfRange(numbers, 0, len)));
			return;
		}
		//원소 선택
		numbers[len] = input[depth];
		subset(depth+1, len+1);
		//원소 비선택
		subset(depth+1, len); // 비선택일때 상단 원소선택 부분을 실행하고 와도, 비선택 시 len이 증가하지 않은 상태이므로 덮어씌워져서 괜찮!
	}
}
