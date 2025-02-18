package sort;

import java.util.Arrays;
//데이타의 범위만큼 배열이 필요해서 (원소가 많고 범위가 좁을때 사용 시 개이득)
//원소가 100이지만 범위가 0~1억인 경우 필요한 배열이 1억 1개이기 때문에,,,


public class CountSortTest {
	public static void main(String[] args) {
		int[] data= {0,4,1,3,1,2,4,1};
		int n = data.length;
		int[] temp = new int[n];
		
		int max = Integer.MIN_VALUE;
		
//		step1. max값 찾기 및 카운트 배열 생성
		for (int i : data) {
			max = Math.max(max, i);
		}
		//자바의 배열은 0부터 시작하므로 데이타를 index로 사용해서 max+1개의 배열을 생성
		int[] counts = new int[max+1]; //인덱스는 0부터 시작하니까~ +1해줌
		
		
//		step2. 데이타 개수 세기
		for (int i : data) {
			counts[i]++; //데이타가 counts배열의 index가 된다. counts[데이타]를 누적한다.
		}
		System.out.println("각각 숫자의 카운트 :"+Arrays.toString(counts));
		
		
//		step3. count 배열에 값을 누적하기 - 앞의 값과 현재 값을 더해서 현재 index에 누적
		for (int i = 1; i <= max; i++) {
//			counts[i] = counts[i]+counts[i-1];
			counts[i] += counts[i-1]; // +=로 한방에 쓰쟈
		}
		System.out.println("각각 숫자의 인덱스 시작위치 :"+Arrays.toString(counts));
		
		
//		step4. 데이타 배열과 count 배열을 이용해서 정렬하기 
		int idx = -1;
		int d;
		//데이타 배열의 맨 끝에 있는 데이타 부터  정렬하기
		for (int i = n-1; i >= 0; i--) {
			d = data[i];
//			idx = counts[d]-1; //자바의 배열은 0부터 시작이니까 해당 값에서 -1해서 배열에 저장하려고~
//			temp[idx] = data[i];
//			counts[d]--;//--는 해당 안에 숫자를 하나씩 지워가면서 돌아야해서~....
			// 위에 세줄을 하단 두줄로 처리 가능
			idx = --counts[d];
			temp[idx] = data[i];
			
		}
		System.out.println(Arrays.toString(temp));
	}
}

















