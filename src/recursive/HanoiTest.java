package recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//하노이의 탑 재귀함수로 해보자
//
//public class HanoiTest {
//	static StringBuilder result = new StringBuilder(100);
//	static void hanoi(int n, int from, int temp, int to) {
//		if (n == 0) return;
//		
//		//현재 기둥에서 맨 밑 부분 빼고 다 temp로 옮기기
//		hanoi(n-1, from, to, temp);
//		//맨 아래판을 to로 옮기기
//		result.append(n + ":" + from + "->" + to+"\n");
//		//나머지 판도 to로 옮기기
//		hanoi(n-1, temp, from, to);
//	}
//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int count = Integer.parseInt(br.readLine());
//		hanoi(count,1,2,3);
//		
//		System.out.println(result);
//	}
//}










public class HanoiTest {
	//값을 한번에 담아서 뿌리기 위해 StringBuilder를 만들어줬다.
	static StringBuilder result = new StringBuilder(100);
	
	//하노이 탑 블록 위치 계산하는 함수를 따로짠다!
	static void hanoiTop(int n, int from, int temp, int to) {
		//종료 조건 달기 n이 0이되면 종료한다.
		if (n == 0) return; 
		//현재 기둥 (from)에서 맨 밑 블록 빼고 다 임시 공간(temp)로 옮긴다.
		
		//맨 아래 판을 완성판(to)에 옮긴다.
		
		//나머지 블록들도 완성판에 옮긴다.
	}
	
	public static void main(String[] args) throws Exception{
	//하노이의 탑 블록 개수를 입력 받는다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//받아온 개수를 저장한다. (throws Exception)
		int count = Integer.parseInt(br.readLine());
		
	}
}