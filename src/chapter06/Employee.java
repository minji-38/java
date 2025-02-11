package chapter06;

public class Employee implements Comparable<Employee>{ //Employee 를 비교하는 인터페이스 추가
	private String empno;
	private String name;
	private int salary;
	public Employee() {}
	public Employee(String empno, String name, int salary) {
		this.empno = empno;
		this.name = name;
		this.salary = salary;
	}
	
	/*
	 * 오름 차순 정렬
	 * 비교할 값이 비교 대상 보다 크면 양수, 같으면 0, 작으면 음수를 리턴한다.
	 * 
	 * 내림 차순 정렬
	 * 비교할 값이 비교 대상 보다 크면 음수, 같으면 0, 작으면 양수를 리턴한다.
	 * 
	 * ==> 
	 * 오름 차순 : 현재 객체 - 인자로 전달된 객체 
	 * 내림 차순 : 인자로 전달된 객체 - 현재 객체 
	 * 기준 범위보다 비교범위가 넘어서면 음수가 나와서 오버플로우가 나올 수 있음!! 
	 */
	public int compareTo(Employee o) {
		//오름차순 정렬~
//		if (salary > o.salary) return 1;
//		else if (salary == o.salary) return 0;
//		else return -1;
//		return salary - o.salary; //한줄로 가능 (음수빼기 음수면 에러남 잘 생각해보기~)
//		return Integer.compare(salary, o.salary); //직관적으로 위에 if문으로 외우는게 짱~
		
		//내림차순 정렬~
		if (salary > o.salary) return -1;
		else if (salary == o.salary) return 0;
		else return 1;
//		return o.salary - salary; 
//		return Integer.compare(o.salary, salary);
	}
	public String getEmpno() {
		return empno;
	}
	public void setEmpno(String empno) {
		this.empno = empno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder(50);
		builder.append("empno=").append(empno).append(", name=").append(name).append(", salary=")
				.append(salary);
		return builder.toString();
	}
	
	/**
	 * 객체의 내용을 비교하는 기능 
	 * - 반드시 Override를 해야 객체 내용을 비교할 수 있다. 
	 */
	public boolean equals(Object obj) {
		if (obj instanceof Employee) { //instanceof가 null검사도 한다 
			Employee emp = (Employee) obj;
			if( empno != null && empno.equals(emp.empno)) {
				return true;
			}
		}
		return false;
	}
}










