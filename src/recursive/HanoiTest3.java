package recursive;
//하노이의 탑 재귀함수로 해보자
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class HanoiTest3 {
	static StringBuilder result = new StringBuilder(100);
	static int N;
	static long tc = 0;
	static void hanoi(int count, int from, int temp, int to) {
		
		if (count == 0) return; // 모든 판을 다 옮긴 경우 종료
		
		// 현재 기둥에서 맨 아래 판을 뺀 나머지(count-1)들을 임시 기둥(temp)에 옮겨놓기
		hanoi(count-1,from, to, temp);
		
		// 맨 아래 판을 목적 기둥(to)에 옮겨놓기
		if (N < 20) {
			result.append(from);
			result.append(" ");
			result.append(to);
			result.append("\n");
		}
		tc++;
		// 나머지 판들(count-1 ~ 1)을 목적 기둥(to)에 옮기기!
		hanoi(count-1,temp,from,to);
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.parseInt(br.readLine());
		N = count;
		if (N >= 20) {
            // N이 20 이상이면 직접 연산으로 tc 계산 (2^N - 1)
            tc = (1L << N) - 1;
            System.out.println(tc); // 이동 횟수 출력
        } else {
            // N이 20 미만이면 재귀 호출로 tc 계산
            hanoi(count, 1, 2, 3);
            System.out.println(tc); // 이동 횟수 출력
            System.out.print(result); // 과정 출력
        }
		
	}
}




