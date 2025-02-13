package twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 슬라이딩윈도우를 사용해서 푼 회전초밥 문제에 투포인터를 넣어보자! 
 */
public class Main_15961_G4_회전_초밥_twoPointer_안민지 {
	static int N, d, k, c, dish[], check[], ans;
	
    public static void main(String[] args) throws Exception{
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//접시 수
		d = Integer.parseInt(st.nextToken());//초밥 종류수
		k = Integer.parseInt(st.nextToken());//연속 섭취 접시 수
		c = Integer.parseInt(st.nextToken());//쿠폰 초밥종류번호

        dish = new int[N];
        check = new int[d + 1]; // 초밥 개수 카운팅
        for (int i = 0; i < N; i++) {
        	dish[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;

        // 초기 윈도우 설정 (길이 K)
        for (int i = 0; i < k; i++) {
            if (check[dish[i]] == 0)
            	cnt++; // 새로운 초밥 종류 추가
            check[dish[i]]++;
        }

        // 초기 쿠폰 포함 여부 확인
        ans = cnt + (check[c] == 0 ? 1 : 0);

        // 회전시키기
        for (int i = 1; i < N; i++) {
            // 왼쪽 초밥 제거
            int leftDish = dish[(i - 1) % N];
            check[leftDish]--;
            if (check[leftDish] == 0) cnt--; // 종류 감소

            // 오른쪽 초밥 추가
            int rightDish = dish[(i + k - 1) % N];
            if (check[rightDish] == 0) cnt++; // 새로운 종류 추가
            check[rightDish]++;

            // 쿠폰 포함 여부 확인 후 최대값 갱신
            ans = Math.max(ans, cnt + (check[c] == 0 ? 1 : 0));
        }
        // 결과 출력
        System.out.println(ans);
    }
}