package chapter04;

public class CustomerTest {
	public static void main(String[] args) {
		/*
		 * 객체 선언		클래스명 변수명;
		 * 객체 생성		변수명 = new 클래스명([인자]);
		 * 객체 접근		변수명.속성명			변수명.함수명
		 * 
		 * 선언 & 생성
		 * 클래스명 변수명 = new 클래스명([인자]);
		 */
//		Customer cust1 = new Customer(); //선언과 생성을 동시에 함
//		cust1.name = "minji";
//		cust1.age = 27;
//		cust1.address = "경기도 구리시";
		
		Customer cust1 = new Customer("minji", "경기도 구리시", 27);
//		System.out.println(cust1.toString()); //이미 객체자체가 string인 경우 toString()생략가능 println에서 알아서 string으로 바꿔줌
		System.out.println(cust1); 
		System.out.println(new Customer("uplus","선릉",2).toString()); //Customer [name=null, address=null, age=0] 값을 안넣어줘서, 기본값으로 초기화됨
		System.out.println(new Customer().toString()); //Customer [name=null, address=null, age=0] 값을 안넣어줘서, 기본값으로 초기화됨
		
		
		Customer cust2 = new Customer("1","1",1);
		System.out.println(cust1.equals(cust2));

		
	}

}
