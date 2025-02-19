package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 완전 이진 트리(Complete Binary Tree)
 * 각 노드가 최대 2개의 자식 노드를 갖는 이진 트리로
 * 마지막 레벨을 제외한 모든 노드는 완전히 채워져 있어야 한다. 
 * 또한, 최하단 레벨의 노드는 좌측만 채워져 있거나, 좌측 우측이 모두 채워진 상태
 * 
 *     2					2							2
 *  8    12   			8		12					8		12
 *23 40				  23	   40  					  23  40
 *  (O)						(O)							(X)		
 *  
 *  
 * - heap, 세그먼트 트리는 완전 이진 트리를 이용해서 구현   (시간복잡도 logn)
 * N번 탐색해서 데이터 접근해야할때, 시간복잡도를 logn으로 줄여야하면 = 세그먼트 트리 (어려움)
 * CompleteBinaryTree를 이용해서 heap, 세그먼트 트리를 만들었다~
 * [중요] 이진트리는 왼쪽 레벨로 내려가면 본인 index*2의 값, 오른쪽 방향 레벨로 내려가면 index*2+1의 값
 * 
 */
public class CompleteBinaryTree<E> {
	
	//데이타를 저장할 배열
	private Object[] nodes;
	//현재 노드를 저장할 위치
	private int lastIndex;
	//tree의 크기
	private final int SIZE;

	public CompleteBinaryTree(int size) {
		SIZE = size;
		// 0인덱스 사용 안함 => 자식 노드 탐색할때, 왼쪽 자식은 현재 index*2, 오른쪽 자식은 *2+1
		nodes = new Object[size + 1];
	}

	public boolean isEmpty() {
		return lastIndex == 0;//다음 저장할 놈의 인덱스이면서 개수가 0이면 저장한게 없다는 뜻
	}
	public boolean isFull() {
		return lastIndex == SIZE; //현재 저장한 데이타 개수가 size와 동일하면 다 저장
	}
	public void add(E e) {
		if(isFull()) {
			System.err.println("포화상태입니다!!!!!");
			return; //함수호출한곳으로 돌아갈래에에에에~~ (return아래로 안감)
		}
		nodes[++lastIndex] = e; //0번인덱스를 안쓸거라서 ++시킨다음 e를 담아줌 = 저장 끝!
		
	}
/*
 * 프로그램 처리 후 방문 = 프리오더
 * 방문 후 처리  = 인오더
 * 왔다갔다 처리 = 포스트오더
 */
	public void inOrder(int current) { // 방문 후 프로그램 처리하고 마저 방문
		if (current <= lastIndex) {//현재 노드가 마지막 level 인덱스보다 작거나 같을때만~
			// 왼쪽 자식노드 방문처리
			inOrder(current * 2); 
			// 현재 노드 방문처리
			System.out.print(nodes[current] + " ");
			// 오른쪽 자식노드 방문처리
			inOrder(current * 2 + 1); 
		}
	}
	public void preOrder(int current) { //프로그램 처리 후 방문
		if (current <= lastIndex) {//현재 노드가 마지막 level 인덱스보다 작거나 같을때만~
			// 현재 노드 방문처리
			System.out.print(nodes[current] + " ");
			
			// 왼쪽 자식노드 방문처리
			preOrder(current * 2); 
			// 오른쪽 자식노드 방문처리
			preOrder(current * 2 + 1); 
		}
	}
	
	public void postOrder(int current) { //방문 왔다갔다 완료하고 처리
		if (current <= lastIndex) {//현재 노드가 마지막 level 인덱스보다 작거나 같을때만~
			// 왼쪽 자식노드 방문처리
			postOrder(current * 2); 
			// 오른쪽 자식노드 방문처리
			postOrder(current * 2 + 1); 
			
			// 현재 노드 방문처리
			System.out.print(nodes[current] + " ");
		}
	}
}



