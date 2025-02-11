package chapter06;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Comparable
 *   - Arrays.sort(객체배열), Collections.sort(Collection)
 *   함수를 통해 정렬할 때 어떤 기준으로 정렬할지 compareTo()로 지정하기 위한 interface
 *   - 정렬하려는 객체의 클래스에서 Comparable를 상속받는다.. 
 *     ex) Employee 객체들을 정렬하기 위해서는 Employee 클래스에 Comparable 선언한다. 
 *     
 * Comparator (정렬 기준을 따로 주려고 할 때 사용)   
 *   - Arrays.sort(객체배열, Comparator), Collections.sort(Collection, Comparator)
 *   함수를 통해 정렬할 때 어떤 기준으로 정렬할지 compare()로 지정하기 위한 interface
 * 
 *   - sort() 함수의 두번째 인자로 Comparator를 전달한다. 
 *  
 */
public class ComparableTest {
	public static void main(String[] args) {
		Employee[] emps = { 
				new Employee("2", "1", 5),
				new Employee("1", "1", 1),
				new Employee("3", "1", 2),	
		};
		
		Arrays.sort(emps);
		System.out.println(Arrays.toString(emps)); //Employee.jave에서 salary 기준으로 내림차순 정렬함
		
		int [] array1 = {7,5,2,3,4,6,1}; //primitive 객체임
		/*
		 * 기본타입의 배열을 정렬할 때 Comparator로 인자를 주지 않아도 오름차순으로 정렬됨.
		 */
		Arrays.sort(array1); 
		System.out.println(Arrays.toString(array1));
		
		/*
		 * 기본 타입을 내림차순으로 정렬하는 법
		 * 	- Comparator를 두번째 인자로 전달해야 한다.
		 * 		==> Comparator의 compare 함수는 객체만 전달 받는다.
		 * 			==> Wrapper를 이용해야한다.
		 */
		// 내림차순으로 정렬하려면 Comparator 사용해서 정렬기준을 만들자!
		//int[] array1은 primitive 타입 그대로 Comparator를 쓸 수 없어서 Wrapper로 감싸줘야함.
		//integer[] array = {}로 선언해야한다~
		
		Integer[] array2 = {5,54,46,7,8,0};
		Arrays.sort(array2, new Comparator<Integer>() {  //<>사이에 정렬하는 타입을 넣는다.
			@Override
			public int compare(Integer o1, Integer o2) {
				//내림차순
				return o2 - o1;
			}
		});
		System.out.println(Arrays.toString(array2));
		
		
		
		
		Arrays.sort(emps,new Comparator<Employee>() { //comparator 를 써서 정렬 기준을 따로 줌
			/*
			 * compare(arg1, arg2)
			 * arg1 : 기준 데이타
			 * arg2 : 비교 데이타
			 */
		
			public int compare(Employee arg1, Employee arg2) { //사원번호 기준 정렬 정하기
				// 오름차순
//				String empno = arg1.getEmpno();
//				return empno.compareTo(arg2.getEmpno());
				
				// 내림차순
				String empno = arg2.getEmpno();
				return empno.compareTo(arg1.getEmpno()); //두번째에서 첫번째 빼준 느낌이라 내림차순이 됨
			}
		});
		System.out.println(Arrays.toString(emps)); //사원번호로 정렬한 내용 출력
	}

}
