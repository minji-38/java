package chapter04;

public class MyDateTest {
	public static void main(String[] args) {
		MyDate d1 = new MyDate(); //기본생성자 자동으로 만들어짐
//		d1.year = 2025;
//		d1.month = 13;
//		d1.day = 32;
		d1.setYear(2024);
		d1.name = "minji"; //default 이기 때문에 같은 패키지 내에서는 접근이 가능하다. private 이면 안됨
		
	}	
}
