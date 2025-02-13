package slidingwindow;
/**
 * 길이가 N인 배열에서 길이가 K인 서브 배열의 특정 연산시 최적의 값을 구하는 경우 
 *  
 * 정수로 이루어진 길이가N인 배열에서 길이가 K인 서브 배열의 합계가 가장 큰 서브 배열은?
 * - ex)[2,4,7,10,8,4,5,6,7,1]  
 * 
 * -sequential로 풀 때 시간 복잡도 : k*(N-k+1)
 * 
 *  ex) 회전초밥(고) 
 *  2≤N≤3,000,000
 *  2≤k≤3,000 (k≤N)  3,000 * (3,000,000-3,000+1) => 89억정도 ==> 시간 초과 (1초에 1억)
 *
 */
public class MaxSumArray1 {
	public static void main(String[] args) {
		int[] nums = {2,4,7,10,8,4,5,6,7,1};
		int max = 0, sum=0;
		int k= 4;
		int idx = 0; //max값이 발견된 subset의 시작 위치
		//배열 전체를 탐색하면서
		for (int i = 0, size = nums.length-k; i < size ; i++) {
			sum = 0;
			//k개 만큼 반복하면서 sum을 구하고
			//i번째 위치에 잇는 원소부터 start 위치 -> k개를 sum 해야함
			for (int j = i,end = i+k; j < end; j++) {
				sum+=nums[j];
			}
			//max값과 같은지 비교한다.
//			max = Math.max(max, sum);
			if (max < sum) { //이미 있는 값과 동일한 값이면 if문 들어가지 x (가장 앞에 있는 최고값~)
				// 중복 중 뒤에 있는 값을 구하려면 따로 처리가 필요하나 그런 문제는 거의 없음
				max = sum;
				idx = i; //i가 max값을 구한 위치의 시작값이기 때문에
			}
		}
		
			//max 값과 같은지 비교함.
		
		System.out.println("서브 배열중 제일 큰 값 :" + max+", 시작 인덱스 값 :"+idx);
		//만약 배열 값까지 뽑고싶다면
		for (int i = idx,end = idx+k; i < end; i++) {
			System.out.printf("%d ",nums[i]);
			
		}
	}
}
