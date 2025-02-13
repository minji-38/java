package permutation;

import java.util.Arrays;

public class Permutation_nTTr { //n파이r
	static int N; 	 			//원소 개수
	static int R;				//뽑을 개수
	static int[] input;			//입력 데이타
	static int[] numbers;		//뽑은 순열을 담을 배열
	static int tc;				//테스트 케이스 수
	
	public static void main(String[] args) {
		input = new int[] {1,2,3};
		N = input.length;
		R = 2;
		numbers = new int[R];
		perm(0); //(depth)주기
		System.out.printf("%dTT%d 중복 순열 개수 : %d",N,R,tc);
	}
	public static void perm(int depth) {
		/*
		 * 배열을 0부터 시작하므로 R-1의 위치까지가 모든 원소를 뽑은 상태
		 * depth==R이면 하나의 순열에서 모든 원소를 다 뽑은 상황이므로 종료한다.
		 */
		if (depth==R) { //depth가 R이 되면 다 뽑아서 더이상 뽑을게 없는 상황
			tc++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		//depth번째의 원소를 선택해야 한다.
		for (int i = 0; i < N; i++) { //0~N보다 작을때까지 반복한다.
			//여기에서 중복검사를 하면 순열!
			//하나하나 중복 검사를하면 depth가 커질수록 중복검사하는 범위가 넓어짐! -> 시간 복잡도가 커진다 => boolean 데이터를 배열에 넣어서 해당 배열과 공간 비교를 하면됨 (공간복잡도)
			numbers[depth] = input[i]; //중복순열이라 중복 검사를 안하고 무조건 뽑음
			perm(depth+1); //현재 원소에서 다음 원소를 뽑아야하니까 +1 배열로 보면[0]했으니까 [1]하러 간다는뜻
		}
	}
}
