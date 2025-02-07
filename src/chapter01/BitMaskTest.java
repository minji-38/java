package chapter01;

public class BitMaskTest {
//1이면 있다. 0이면 없다.
	public static void main(String[] args) {
		/*
		 * Bit Mask
		 * - 기존의 bit를 &, |, ^, <<, >>를 이용해서 다른 값으로 변경 (masking)하는 작업
		 * int a = 0b1000;
		 * int b = 0b0010;
		 * 
		 * a &= b; // 0000  1이었던 비트가 0으로 masking 됨
		 * a |= b; // 1010  0이었던 비트가 1로 masking 됨
		 * 
		 * - 정수의 이진수표현을 자료 구조로 쓰는 기법 => boolean 배열을 대체하는 효과
		 * 	- 보통 어떤 비트가 1이면 '켜져있다, true, 해당 위치에 원소가 있다.'
		 * 				  0이면 '꺼져있다. false, 해당 위치에 원소가 없다.'
		 * 
		 * -장점
		 * 1. 수행 시간이 빠르다.
		 * 	비트 마스크는 bit 연산 (&, |, ^, ~)이므로 O(1)로 구현되는 것이 많다.
		 * 	==> 다른 자료구조(boolean 배열)를 이용하는 것보다 빠르게 동작된다.
		 * 	ex) 10만개의 word에 a k g 가 있는지 체크
		 * 		boolean 배열
		 * 		10만 * word의 크기 					 => O(n*word 크기)
		 * 		int result = 0;
		 * 		for(int i = 0; i<10만; i++) {
		 * 			for(int j = 0, size = word.length(); j < size ;j++) {
		 * 				if (word.charAt(j) == 'a'|| word.charAt(j) == 'k'||word.charAr(j) == 'g'){
		 * 					count++;
		 * 				}
		 * 			}
		 * 			if(count == 3) {
		 * 				result++;
		 * 			}
		 * 		}
		 * 
		 * 		bitmask 이용하면 10만으로 성능을 높일 수 있다. => O(n)
		 * 		int result = 0;
		 * 		for(int i = 0; i<10만; i++) {
		 * 			if (word&key == key) { //키랑 똑같은 부분만 1로 하고 나머지는 다 0으로 하니까 똑같이 일치하는 것만 == key를 충족
		 * 				result++;
		 * 			}
		 * 		}
		 * 2. 코드가 짧다.
		 * 	boolean 배열을 모두 순회해서 체크하는 코드가 bit 연산 하나로 대체 될 수 있으므로 코드가 간결해진다.
		 * 
		 * 3. 메모리 사용량이 적다.
		 * ex)  문이 잠긴 행, 열로 구성된 map에서 key(a,b,c,d,e,f)를 이용해서
		 * 		문을 열어야 도착점으로 탈출 할 수 있는 경우 방문체크 배열
		 * 		[행][열][a][b][c][d][e][f] 배열 선언 (8차원)
		 * 
		 * 		bitmask 사용 시
		 * 		[행][열][key] 배열 선언 (3차원)
		 * 
		 * 
		 */
		
		/* 1. 공집합과 꽉 찬 집합 구하기
		 * A = 0; 			//32개의 원소가 모두 0이므로 공집합
		 * n = 10;			//10개인 원소 
		 * A = (1<<n)-1;	//한개 원소 빠지고 나머지는 1로 가득참 = 꽉 찬 집합
		 * 		0000000001 << 10 ==> 10000000000
		 * 	   10000000000 -1 = 1111111111
		 */
		int n = 10;
		int A = (1<<n)-1;
		//1<<n이면 1 -> 10칸 앞으로 가니까 10000000000
		//-1을 하면 1111111111
		System.out.println(Integer.toBinaryString(A)); //1111111111
		
		/* 2. 특정 위치에 1이 있는지 check로 & 사용
		 * 
		 * & and : 연산하려는 두 비트가 모두 1일때 1이고 나머지는 0
		 * 		 : 특정 위치에 1이 있는지 체크 용도로 사용, data & 0 -> 0으로 초기화
		 */
		int a1 = 0b1000;
		int b1 = 0b0010;
		int c1 = 0b1110;
		System.out.println(Integer.toBinaryString(a1&b1)); //0
		System.out.println(Integer.toBinaryString(a1&c1)); //1000
		System.out.println(Integer.toBinaryString(b1&c1)); //10
		
		/* 3. 원소추가 : k번째 위치에 원소를 추가(1로 마스킹)하기 (OR | 사용)
		 * A |= (1<<k)
		 * k번째는 뒤에서부터 세기! (0번째부터~)
		 */
		A = 0;	//원소추가 확인용 공집합
		int k = 5; //5번째 위치에 1 추가예정 (뒤에서부터 543210)
		A |= (1<<k);
		System.out.println(Integer.toBinaryString(A)); //100000
		
		
		/* 4. 원소삭제
		 * 	  k번째의 위치에 있는 원소를 삭제 (0으로 만듦)
		 * 	  A &= ~(1<<k)
		 * 	  
		 */
		A &= ~(1<<k);
		System.out.println(Integer.toBinaryString(A));
		
		
		/* 5. 마지막 1의 위치 찾기
		 * A&-A		: A의 인지수에서 1의 마지막 위치를 찾기  (앞에서부터!)
		 */
		A = 0b1100111000;
		// 0011000111 (비트반전)
		// +        1
		// 0011001000 //2의보수!
		// 근데, 계산 안하고 쉽게해보는법! 맨 마지막 1의 위치부터 그 뒤는 그대로임! +1을 하지말고
		// 그냥 원본에서 마지막 1전까지는 반전하고, 마지막 1부터는 그대로 쓰기 (2의보수)
		
		System.out.println(Integer.toBinaryString(A));
		System.out.println(Integer.toBinaryString(A&-A));
		int m = 0b11010;
		System.out.println(Integer.toBinaryString(m));
		System.out.println(Integer.toBinaryString(m&-m));
		
		/* 6.최소 원소 지우기 (마지막 1부분부터(마지막1이니까 뒤는 어차피 0임) 뒤에 다 0으로)
		 * A & (A-1)  
		 */
		System.out.println(Integer.toBinaryString(A)); //1100111000
		System.out.println(Integer.toBinaryString(A & (A-1))); //1100110000
		
		
		String[] str = {"a","b","c","d"};
		/* 7. 모든 부분 집합 순회하기
		 * 
		 */
		int s = 0b1101;
		for (int subset = s; subset != 0; subset=(subset-1)&s) {
			System.out.println("subset:"+Integer.toBinaryString(subset));
		}
	}

}
