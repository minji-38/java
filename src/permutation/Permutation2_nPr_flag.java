package permutation;
//시간복잡도가 많이드는 순열 생성 코드를 boolean배열을 통해 공간복잡도로 처리해보기
//0.5초 -> 0.1초로 줄어들었음!
import java.util.Arrays;
// 10P10 : 0.5초 컷 
public class Permutation2_nPr_flag {
	static long tc;					//순열 개수
	static long count;				//반복 횟수 
	static int  R;					//뽑을 개수			
	static int  N;					//원소의 개수
	static int[] numbers;			//순열을 담은 배열
	static int[] input;				//입력된 데이타 
	static boolean[] isSelected; 	//원소 사용유무 체크하는 중복체크 배열
	/**
	 * 
	 * @param depth 뽑을 원소의 위치 
	 */
	public static void permutation(int depth) {
		count++;		
		//배열은 0부터 시작이므로 R-1개가 모두 뽑은 상황. idx가 R과 동일한 상황은 순열을 다 뽑은 상황 
		if(depth == R) {
			tc++;
			//순열을 뽑은 이후의 task를 작성 
//			System.out.println(Arrays.toString(numbers));
			return ;
		}
		top:
		for (int i = 0; i < N; i++) {
//			//중복 검사 
//			for (int j = 0; j <depth; j++) {
//				if(numbers[j]== input[i]) { //중복 된 경우 
//					continue top;
//				}
//			}
			if (isSelected[i]) continue; //중복검사 배열의 i번째 원소가 true면 다음 i++수행 (이미 사용중인 숫자임!) 아래로 안떨어지고 다시 for 문 수행
			numbers[depth] = input[i];
			isSelected[i] = true; //사용한 원소 true 표시 해주기! (다음에 중복체크위해)
			permutation(depth+1);
			//재귀 종료 후 다음 순열 뽑기 위해 i번째의 isSelected를 false로 변경!
			//그래야 나머지 순열도 생성 가능
			//저걸 안할 경우 [0,1,2] 뽑고, 이후에 [0, 뽑으려면 그 뒤에 둘다 true true 여서 뽑을게 없음
			//false를 줘야 [0,2,1]가능~
			isSelected[i] = false;
		}
	}
	public static void main(String[] args) {
		input = new int[] {1,2,3,4,5,6,7,8,9,10};
//		input = new int[] {1,2,3};
		N = input.length;
		R = input.length;
		numbers = new int[R];
		isSelected = new boolean[N]; //원소 개수만큼 boolean 선언해야함~ (동일하게) == 인덱스가 동일해야하니까!
		long start = System.currentTimeMillis();
		permutation(0);
		long end = System.currentTimeMillis();
		System.out.printf("tc: %d   count:%d   time:%dms%n", tc, count, end-start);
	}
}





