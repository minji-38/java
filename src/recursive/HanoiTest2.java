package recursive;
//하노이의 탑 재귀함수로 해보자
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HanoiTest2 {
	static StringBuilder result = new StringBuilder(100);
	static void hanoi(int count, int from, int temp, int to) {
		if (count == 0) return; // 모든 판을 다 옮긴 경우 종료
		
		// 현재 기둥에서 맨 아래 판을 뺀 나머지(count-1)들을 임시 기둥(temp)에 옮겨놓기
		hanoi(count-1,from, to, temp);
		
		// 맨 아래 판을 목적 기둥(to)에 옮겨놓기
		result.append(count+":"+from + "->"+to+"\n");  //블록 번호 : 시작위치번호(3개중) -> 도착 위치 번호
		// 나머지 판들(count-1 ~ 1)을 목적 기둥(to)에 옮기기!
		hanoi(count-1,temp,from,to);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		hanoi(count, 1,2,3);//막대기별 from, temp, to 지정해줌
		
		System.out.println(result);
		
	}
}
