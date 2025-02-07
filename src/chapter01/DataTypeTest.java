package chapter01;

public class DataTypeTest {
/*
 *	Primitive Type
 * -자바에서 제공하는 기본 데이타 타입
 * -변수를 위해서 할당한 공간에 실제 값이 저장된다.
 * 		   1byte  2byte  4byte  8byte
 * 	정수형 : byte=> short=> int=> long  (=>방향으로 형변환 가능!)
 * 				 (2byte)
 * 	문자	 :		 char =>int
 * 	실수형 : 						float(4byte), double(8byte)
 * 	논리	 : boolean (형변환 불가능)
 * 
 *  ReferenceType(참조 타입, 사용자 정의 데이타 타입, 객체)
 *  - class, interface, enum, 배열
 *  - 변수를 위해 할당된 공간에 객체를 참조할 수 있는 참조값(hashcode)가 저장된다.
 *  
 *  변수 선언 형식
 *  -> 데이타타입 변수명;
 *  
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 100;
		String str = "hello";
		System.out.println(str.charAt(2));
		System.out.println("hello".charAt(2));
		
		
		/* 정수의 기본 타입은 int 이다.
		 * 숫자 123 <- int
		 * 
		 * byte, short의 변수를 연산 시 int로 형변환 시킨다.
		 */
		byte b1 = 1; //int로 자동 변환시켜줌(java에서)
		byte b2 =2;
		//byte b3 = b1+b2; //오류나는 이유 : int를 byte로 형변환 할 수 없기 때문
		int i1 = b1+b2; //int로 쓰면 됨~
		
		byte b3 = (byte)(b1+b2);//그래도 byte로 쓰고싶다면, 형변환을 해줘야함.
		long l1 = 2222222222l; //int 범위를 벗어난 정수를 사용할때는 l, L로 long 표시
		
		// 정수 / 정수 = 정수  (소수점 밑은 버림) => 몫을 구함
		// 실수 / 정수, 정수 / 실수 = 실수
		System.out.println(5/2);
		System.out.println(5.0/2);
		System.out.println(5/2.0);
		int num1 = 5;
		int num2 = 2;
		System.out.println((double)num1/num2);
		System.out.println(num1/(double)num2);
		
		float f1 = 3.14f;
		double d2 = 3.14; //d 안써도됨
		
		// 0~1 사이 무한의 실수를 4byte, 8byte로 표현 불가능. -> 각각 byte로 근사값을 보여준다.
		 float f2 =65536.123456789f;
		 double d3 =65536.123456789;
		 double d4 =65536.12345678901234567890;
		 
		 System.out.println("f2: "+f2);
		 System.out.println("d3: "+d3);
		 System.out.println("d4: "+d4);
		 
		 //문자 '' 
		 char c1 = 'a'; //0
		 char c2 = 'b'; //1
		 
		 /*
		  * 숫자, 영문자, 특수기호는 ASCII 코드이므로 내부적으로 연산 가능
		  * A:65, a = 97
		 */
		 System.out.println(c1);
		 System.out.println(c2-c1); //내부적으로는 다 숫자이기 때문에(아스키코드 = 0,1) 연산 가능
		 System.out.println((int)'A');
		 System.out.println((int)'a');
		 
		 //a 일때 1칸 점프, b 일때 2칸 점프, c 일때 3칸 점프하려면
		 char state = 'C';
		 int jump = state - 'A' + 1; //A-A 는 0인데, 1칸 점프해야하니 +1
		 System.out.println("jump: "+jump);
		 
		
	}

}
