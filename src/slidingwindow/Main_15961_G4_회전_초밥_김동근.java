package slidingwindow;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_G4_회전_초밥_김동근 {
	static int N, d, k, c, dish[], check[], ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		dish = new int[N];
		check = new int[d + 1];
		for (int i = 0; i < N; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}
		// 초기 값 설정해주기
		int cnt = 0;
		for (int i = 0; i < k; i++) {
			if (check[dish[i]] == 0)
				cnt++;
			check[dish[i]]++;
		}
		// 초기 : 쿠폰 초밥 먹었는지 체크
		if (check[c] == 0)
			ans = Math.max(ans, cnt + 1);
		else
			ans = Math.max(ans, cnt);
		// 회전시키기
		for (int i = 0; i < N - 1; i++) {
			check[dish[i]]--;
			if (check[dish[i]] == 0) {
				cnt--;
			}
			if (check[dish[(i + k) % N]] == 0)
				cnt++;
			check[dish[(i + k) % N]]++;
			// 회전 : 쿠폰 초밥을 먹었는지 체크
			if (check[c] == 0)
				ans = Math.max(ans, cnt + 1);
			else
				ans = Math.max(ans, cnt);
		}
		System.out.println(ans);
	}
}
