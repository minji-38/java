package datastructure;

import java.util.Stack;
/**
 * Stack 
 *  - 마직막에 저장한 데이타를 먼저 꺼내는 방식의 자료 구조(LIFO:Last Input First Out)
 *  ex) 쌓아 놓은 접시를 맨 위에부터 사용하는 방식
 *  - 컴퓨터의 연산 처리시 사용, 메서드 호출 처리에서 사용
 *	- push(arg) : 맨 끝에 저장 
 *  - pop()		: 맨 끝에 있는 데이타를 제거 후 리턴
 *  - peek()   	: 맨 끝에 있는 데이타를 제거 없이 리턴
 *  - isEmpty()	: 저장된 데이타가 있으면 false 없으면 true
 *  - size()	: 저장된 데이타의 개수를 리턴
 *  - contains(데이타) : 해당 데이타가 stack에 저장되어 있으면 true, 없으면 false
 */
public class StackTest {
	public static void main(String[] args) {
//		API로 제공하는 자료구조(Stack, LinkedList...)는 객체만 저장
//		- toString()가 제공되어 저장된 자료들을 출력한다. 
		Stack<Integer> stack = new Stack<>();
		System.out.println(stack.isEmpty());
		System.out.println(stack.size());
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack);
		
		System.out.println(stack.contains(3)); //3이 있는지~
		System.out.println(stack.peek());//맨 끝 값 보기(제거는 안함!)
		System.out.println(stack);
		System.out.println(stack.pop()); //맨 끝 값 보기 (제거함)
		System.out.println(stack);//마지막 값 제거되어있음
		
//		while(!stack.isEmpty()) { //비어있지 않은동안
//			
//		}
	}
}


