package chapter05;

import chapter04.MyDate;

/**
 * interface 
 * - 상수와 추상 메서드로만 구성되어 있다. 
 *   => 딱히 선언하지 않아도 속성은 public static final(수정할 수 없다)(3개 다 속성으로 들어감)로 선언이 되고 
 *      메서드는 public abstract으로 선언된다.
 *       
 * - 다중 상속이 됨.   => 다형성을 위해 다중 상속이 됨.  
 * 선언] 
 *    [public] interface 인터페이스명 [extends super인터페이스명1, ....]{ }
 *    
 * 구현]
 *    [modifiers] class 클래스명 [extends super클래스]
 *      					   [implements super인터페이스명1, ....]{ 
 *      
 *    }
 *    
 * 추상 메서드 :
 * - 메서드의 선언부만 작성하고 구현을 하지 않음 
 * - sub class(상속 받는 클래스, 자식 클래스)에서 추상 메서드를 반드시 Override 하도록 위임 
 *   => sub class에서 추상 메서드를 Override하지 않으면 컴파일 에러 발생     
 *    
 */
				//interface 간 상속도 extends 사용
interface Flyer extends Cloneable{ //추상메서드 (구현불가능 {}들어가면 에러)
	int Type = 1;	//public static final (추후 내용 수정 불가능, 접근은 가능)
	void fly(); //public abstract로 선언됨
}

class Human{
	String name;
	public void start() {
		System.out.println("걸어 봅시다.");
	}
}
			//Human 클래스 상속받고, 인터페이스 Flyer를 implements로 상속
class SuperMan extends Human implements Flyer{
	public SuperMan(String name) {
		this.name = name;
	}
	public void fly() { //인터페이스를 상속받으면 그 안에는 무조건 인터페이스 안에서 선언한 클래스가 있어야함!(override)
		System.out.println("하늘을 날아서 지구를 구해야지");
	}
	public void stop() {
		System.out.println("그만 움직이고 쉬어야징!!");
	}
}
public class InterfaceTest {
	public static void main(String[] args) {
		System.out.println(Flyer.Type); //Type은 static이므로 객체 생성 없이 접근 가능
//		Flyer.Type = 3; 				//Type은 final이므로 값 변경 불가능
		
		MyDate d1 = new MyDate();
		d1.setYear(2024);
//		d1.name //name 속성은 default로 선언되어 있기 때문에 다른 패키지에서는 접근 불가능 (에러)
	}
}





