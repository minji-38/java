package greedy;
//14312KB	104ms (그리디)
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
 * 5kg로 나눈 몫을 먼저 가져가고 남은 무게를 3kg로 채울 수있는지 확인
 * 가능 : 최소 봉지수 출력
 * 불가능: 5kg 하나 줄이고 다시 3kg로 채울 수있는지 확인
 */
public class Main_2839_S4_설탕배달_greed {
	static int count = 0;
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while (N >= 0) {
            if (N % 5 == 0) {  // 5kg 봉지로 나누어떨어지는 경우
                count += N / 5;
                System.out.println(count);
                return;
            }
            N -= 3;  // 3kg 봉지를 하나 사용
            count++;
        }

        System.out.println(-1);  // 정확한 무게를 만들 수 없는 경우 -1출력하기
    }// end of class
}// end of main