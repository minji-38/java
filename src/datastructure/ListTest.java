package datastructure;

import java.util.ArrayList;
import java.util.LinkedList;

import chapter06.Employee;

/**
 * List :  
 *   - 데이타를 저장한 순서대로 저장해 준다. (
 *   - 데이타의 Index는 0부터 size()-1이다
 *   - 중간 삽입할 수 있는 Index는  0부터 size()까지 이다. 
 *     => 범위를 벗어나면 IndexOutOfBoundsException이 발생한다.   
 *   - 데이타를 중복해서 저장할 수 있다. 
 *   -  indexOf(Object o), lastIndexOf(Object o), contains(Object o)
 *    , remove(Object o)에서 해당 기능을 수행하기 위해   equals(Object o)를 
 *      호출해서 객체가 같은지 비교후 처리한다. 
 *   
 */
public class ListTest {
	public static void main(String[] args) {
		
//		ArrayList list = new ArrayList(10);
		LinkedList list = new LinkedList();
		list.add("hello"); 		//맨 끝에 추가
		list.add("hello");
		list.add("java");
		list.add(3.14);
		list.add(new Employee("1", "1", 5000));
		list.add(0, 256);		//index번째 추가됨. 
//		list.add(6, 256);		//IndexOutOfBoundsException 발생. 
		
		System.out.println(list);
		
		
		/*java5에   컬렉션에 Generic을 적용
		 * - 선언과 생성시 저장할 타입를 지정
		 *   => 지정한 타입 외에는 저장할 수 없다. 
		 * - 추출시 형변환 없이 바로 사용
		 * 형식]
		 * 컬렉션<저장할타입> 변수 = new  컬렉션<저장할타입>();
		 *  */
		ArrayList<String> list2 = new ArrayList<>();
		list2.add("hello"); //String 타입 저장
//		list2.add(1); //String 타입이 아니므로 저장 불가능(에러)
		
		ArrayList<Employee> list3 = new ArrayList<>();
		list3.add(new Employee("1", "1",10000000));
		System.out.println(list3.indexOf(list3));
	}
}




















