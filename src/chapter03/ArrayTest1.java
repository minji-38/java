package chapter03;

import java.util.Arrays;

/**
 * 배열
 * - 하나의 변수에 여러개의 공간을 할당하고, 동일한 타입의 데이타를 저장/관리
 * - 어떤 타입도 배열로 선언할 수 있고, 배열로 선언하면 ReferenceType이 된다.
 * 	 주소값의 배열로 접근 불가능 (자바는 포인터가 없다) = return 으로 배열 넘기기 불가능
 *  
 * - 배열 객체를 생성하면 length라는 속성을 가지게 되고, 배열의 크기가 들어있다.
 * - index를 통해서 접근하고 index는 0부터 시작한다.
 * 	 =>접근 할 수 있는 index는 0~index.length-1까지이다.
 * 	 ==>접근 범위를 벗어나면 ArrayIndexOutOfBoundsException 오류가 발생한다.
 * 
 * - 배열 생성 시 size를 변경할 수 없다.
 * 	 =>변경할 필요가 있다면 다시 생성해서 copy 해야한다.
 * 
 * - 객체 생성 시 기본값으로 초기화 된다. (0으로 직접 초기화 할 필요 없음)
 * 	 정수 : 0
 * 	 실수 : 0.0
 * 	 논리 : false
 * 	 문자 : \u0000 //유니코드
 * 	 객체 : null
 *
 * - 선언 방법
 *	 DataType [ ] = 변수명;([]개수가 차원 수)    or       DataType 변수명[ ];
 *
 * - 생성
 * 	 변수명 = new DataType[size];
 * 
 * - 선언 & 생성
 * 	 DataType [ ] 변수명 = new DataType[size];
 * 
 * - 접근
 * 	 변수명[접근_index]
 * 
 * - 선언 & 생성 & 할당 (동시에)
 * 	 DataType[] 변수명 = [값1, 값2, ....} //값의 개수만큼의 크기로 배열이 생성된다.
 * 
 */
public class ArrayTest1 {

	public static void main(String[] args) {
		int[] a1, a2; 		//a1,a2는 1차원 int 배열
		int   b1, b2[]; 	//b1은 int, b2는 1차원 int 배열
		int[] c1, c2[];		//c1는 1차원 int 배열, c2는 2차원 int 배열
		
		int[] array = new int[3];
		for (int i = 0, size = array.length; i < size; i++) { //array.length .로 가면 heap가서 참조! 3번 찾아야하기때문에 선언부에 그냥 size로 넣어둠
			System.out.printf("array[%d] : %d%n",i, array[i]);
			
		}
		System.out.println(Arrays.toString(array));
		
		int[] array2 = {1,2,3,4,5};
		System.out.println(Arrays.toString(array2));
		
	}

}
