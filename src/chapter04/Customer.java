package chapter04;
//94학번

/**
 * 	   기계어			: 모든 명령셋이 0 1로 구성되어 있어 기계어로 프로그램 구현하기 어렵다. 
 *  => 어셈블러 		: 명령이 간단한 심볼(fatch, mov)로 구성되어 있어 기계어보다는 쉽지만 여전히 어렵다.  
 *  => 절차식 언어 		: 자연어와 가까워 프로그램을 구현하기 쉬워졌지만 프로그램이 실행 되는 순서대로 
 *  				  모든 코드가 구현되어야 하므로 구현 양이 많아  메모리를 많이 차지하고 프로그램 개발 시간이 오래 걸린다. (코드 재사용 불가) 
 *  => 구조적 언어 		: 자주 사용하는 코드를 모듈화하여 재사용 함으로서 구현된 코드 양이 적어 빠르고 개발 시간이 적다. 
 *  				  데이타와 코드의 커플링이 너무 높아 수정하기 힘들다.
 *  => 객체 지향언어	: 데이타와 코드의 커플링이 낮아 재사용성과 수정성이 높다. (Interface 가 동일하기 때문에)
 * 
 * 
 * 객체 지향
 * 캡슐화, 상속, 다형성 => 재사용성과 수정성을 높이기 위한 특징
 * 
 * 객체 
 * - 현실 세계의 모든 것들 ==> 객체 지향에서는 현실 세계의 모든것들이 프로그램의 대상이다
 * - 속성, 행위(메서드)를 가지고 있다.  
 * - 재사용의 단위 (유지보수의 단위)
 * 
 * 
 * 예시를 보고 동사, 명사 구분 후 객체,속성,행위 지정해보기
 * ex )다리,  색상, 재질, 가격,  상판,  테이블
 *   객체/속성 속성  속성  속성 개체/속성  객체
 *   다리, 상판도 객체지만 테이블안에서는 속성이됨
 *   
 * key abstraction 
 *   -무수히 많은 객체 중에서 프로그램에 필요한 객체를 선정하고
 *    객체에 무수히 많은 속성과 기능 중에서 프로그램에 필요한 속성, 메서드를 추출하여 
 *    클래스를 정의 하는 과정 
 *    
 * 명세서(요구사항 정의서-> 유즈케이스 명세서)와  다양한 워크 문서들 통해
 * 명사(데이타)와 동사(기능)을 추출
 *     
 * 클래스
 * - 객체의 속성과 행위를 선언해서 생성을 통해 객체를 생성할 수 있는 대상
 * 	=> 속성과 메서드 코드가 객체 생성을 통해 메모리에 올라가므로 매번 필요할 때마다 선언할 필요가 없다.(재사용)
 *  
 *  
 *  
 *  []생략가능
 *  pubilc/생략 , abstract/final
 * [modifiers] class 클래스이름 {
 * 		//속성 선언
 * 		abstract 빼고 나머지 다 가능
 * 		[modifiers] DataType 속성명;
 * 		
 * 		//생성자
 * 		[access_modifier] 클래스이름([인자, ...]) {}
 * 		
 * 		//메서드
 * 		[modifiers] 리턴타입 메서드이름([인자,...]) {
 * 			[return [데이타]];
 * 		}
 * }
 * 
 */

/*
 * 한 파일 내에는 public class는 한개만 있어야한다.
 * public class는 파일 이름과 동일해야한다.
 */
class test {
	
}
public class Customer { //top class, enclosing class에는 private, static을 붙일 수 없다. (재사용성)
	//public,abstract,final,생략 제외하고 [modifiers]에 올 수 없음 (파일이름의 클래스만 public 가능)
	/**
	 * 클래스 내에 선언한 클래스는 Nested class
	 */
//	static private class MyClass{ } // Nested class (모든 modifiers를 다 넣을 수 있다)
	/*
	 * - 속성은 객체가 생성(new)될 때 기본값으로 초기화된다.
	 *   정수 : 0
	 * 	 실수 : 0.0
	 * 	 논리 : false
	 * 	 문자 : \u0000 //유니코드
	 * 	 객체 : null
	 * - 기본값이 아닌 다른 값으로 설정할때만 속성명 = 값;으로 초기화 한다.
	 */
	String name;
	String address;
	int age;
	/**
	 * 
	 * 생성자 Overloading
	 * 동일한 이름의 생성자를 인자(인자의 개수, 인자 타입, 인자의 순서)가 다르게 해서 
	 * 한개 이상 선언할 수 있다. 
	 * 
	 * default Constructor
	 * -클래스 내에 생성자가 한개도 없으면 컴파일러가 no-arg, no-body인 생성자를
	 * 	작성한다.
	 *  ==> 클래스 내에 생성자가 있다면 컴파일러가 default Constructor를 만들지 않는다.
	 */
	public Customer(String name, String address, int age) {
		/**
		 * this : this는   this를 작성한 클래스로 부터 생성된 객체 중 현재 사용 중인 객체를 참조  
		 *  1. 속성과 로컬변수 이름이 같을 때 구별하기 위해 속성 앞에 this.을 붙인다. 
		 *  2. 코드 재사용을 위해 인자가 다른 생성자를 호출할 때 this(~)를 사용한다. 
		 *      주의점: 생성자 호출은 생성자의 첫번째 명령에서만 호출이 됨. (무조건 클래스 첫번째줄에!)
		 *  3. 클래스 내부에서 해당 클래스의 객체가 필요한 경우 
		 *     ex) 이벤트 처리     
		 */
		this.name = name; //1. 속성과 로컬변수 이름이 같으면 컴파일러가 뭐가 뭔지 모르니까 둘이 같은걸로 봄. 이런경우에는 꼬옥 this.를 써줘야함
		this.address = address;
		this.age = age;
	}
	public Customer() {
		//생성자는 new를 통해서만 호출가능
		//2. new Customer('','',2);해서 할 수는 있지만 메모리할당을 여러번 해야해서 JVM이 할 일이 너무 많음
		this("minji","경기도 구리시",27); //this()를 쓰면 해결됨~ (기본값을 주고싶어서 할당한거임)
	}
	
	/**
	 *  toString()
	 *  객체의 내용을 문자열로 리턴하는 기능
	 *  
	 *  문자열 + 객체, System.out.println(객체)할때 toString()가 호출된다.
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [name=");
		builder.append(name); //사실 여기도 this.name인데 컴파일러가 알아서 this. 넣어줘서 안쓰는거임!
		builder.append(", address=");
		builder.append(address);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
	public boolean equals(Customer cust) {
		return this == cust; //클래스내에서 현재 사용중인 객체가 필요할때 this 사용
	}
	

}






