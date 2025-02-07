package chapter03;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayTest3 {
	public static void main(String[] args) {
		/*
		 * System.arraycopy(src, srcPos, dest, destPos, length);
		 * src 		: 복사할 원본
		 * srcPos 	: 복사를 시작할 위치
		 * dest 	: copy본 (부본)
		 * destPos  : dest에서 데이타를 저장할 위치
		 * length	: 복사할 개수
		 */
		
		int[] src = {0,1,2,3,4,5,6,7,8,9};
		int[] copy1 = new int[15];
		int[] copy2 = new int[3];
		
		//전체 복사
		System.arraycopy(src, 0, copy1, 0, src.length);
		System.out.println(Arrays.toString(copy1)); //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0]
		
		//부분 복사
		System.arraycopy(src, 2, copy2, 0, copy2.length); //src 내용중 2번째부터 copy2에 copy2 길이만큼만 복사
		System.out.println(Arrays.toString(copy2)); //[2, 3, 4]

		/* 더 쉬운 전체복사 방법
		 * Arrays.copyOf(original, newLength) : T[]
		 * original 	: 복사할 원본 대상
		 * newLength	: copy본의 배열 크기 (배열의 크기를 늘일 개수)
		 * 
		 */
		int[] copy3 = Arrays.copyOf(src, 15);
		System.out.println(Arrays.toString(copy3)); //[0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0]
		
		/* 더 쉬운 부분 복사 방법
		 * Arrays.copyOfRange(original, from, to) : T[]
		 * origin 	: 복사할 원본 대상
		 * from 	: 복사할 시작 위치, 0부터 시작  (개수아님)
		 * to 		: 복사를 끝낼 위치!, 1번부터 시작 (개수아님)
		 */
		int[] copy4 = Arrays.copyOfRange(src, 2, 5); //src[2] 내용부터 src[4] (to는 1번부터여서) 내용까지 복사! 
		System.out.println(Arrays.toString(copy4)); //[2, 3, 4]
		
	}
}
