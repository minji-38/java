package chapter01;

public class BitOperateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int d = 10; //10진수
		int b = 0b1000; //2진수 = 8
		int o = 010; //8진수 = 8
		int h = 0x10; //16진수 = 16
		System.out.println(b);
		System.out.println(o);
		System.out.println(h);
		
		// & and : 연산하려는 두 비트가 모두 1일때 1이고 나머지는 0
		//		 : 특정 위치에 1이 있는지 체크 용도로 사용, data & 0 -> 0으로 초기화
		int a1 = 0b1000;
		int b1 = 0b0010;
		int c1 = 0b1110;
		System.out.println(Integer.toBinaryString(a1&b1)); //0
		System.out.println(Integer.toBinaryString(a1&c1)); //1000
		System.out.println(Integer.toBinaryString(b1&c1)); //10
		//1인 부분이 서로 일치하면 그부분만 1, 나머지는 0
		
		//a b c d e f g가 있을때,  a,c,f 위치값에 값이 있는지 확인
		int key = 0b1010010; //찾는 부분의 위치에 1 쓰고 나머지 0
		int word1 = 0b1110010;
		int word2 = 0b1110100;
		System.out.println(Integer.toBinaryString(key&word1)); //둘이 일치하는지 &로 확인(같은자리에 1인 부분만 1로 하고 나머지는 0)
		System.out.println(Integer.toBinaryString(key&word2));
		System.out.println((key&word1) == key);
		System.out.println((key&word2) == key); //key의 1 위치를 모두 가지지 않아서 false
		
		
		// | or : 두 비트가 모두 0일때만 0, 나머지는 1
		//		: 특정 위치에 1을 채우는 효과
		System.out.println(Integer.toBinaryString(a1|b1)); //1010
		System.out.println(Integer.toBinaryString(a1|c1)); //1110
		System.out.println(Integer.toBinaryString(b1|c1)); //1110
		
		
		/*
		 * shift : 비트를 이동시키는 연산자
		 * data << 이동시킬_비트_수 		지정한 수만큼 왼쪽으로 이동
		 * 							2^이동수 만큼 곱한 효과
		 * data >> 이동시킬_비트_수 		지정한 수만큼 오른쪽으로 이동
		 * 							2^이동수 만큼 나눈 효과
		 * 
		 */
		System.out.println(b<<2); //0b1000(8) << 2 0b100000(32)가 된다 8 * 2^2한 효과
		System.out.println(b>>2); //0b1000(8) >> 2 0b10(2)가 된다 8 / 2^2한 효과
		
		
		//^(xor) : 두 비트가 같으면 0다른 1 ==>  토글 효과
		int pw = 0b11001101;
		int salt = 0b10110011;
		int encoding = pw ^ salt;
		System.out.println(Integer.toBinaryString(encoding)); //암호화할때 씀
		System.out.println(Integer.toBinaryString(encoding^salt)); //복호화 (salt로 다시 하면 원본 pw 나옴)
		
		
		// ~ : 비트 반전
		int p = 0b1100;
		System.out.println(~p);
		System.out.println(Integer.toBinaryString(~p));
		int p2 = -12;
		System.out.println(Integer.toBinaryString(p2));
		System.out.println(Integer.toBinaryString(~p2));
	}

}
