package twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 초기 코드의 문제점!
 * 1. 현재 검사 중인 값을 제외하지 않았음 (짧은 배열에서는 상관 없으나, 더 긴 배열에서는 메모리 초과~)
 * 2. 모든 배열을 순회하면서 더한 값이 배열에 있는지 확인 할 필요가 없음!
 * 한번 배열에서 찾았으면 이미 true 이기 때문에 뒤에 부분은 계산 할 필요가 없다. break로 나와라~
 */

public class Main_1253_G4_좋다_큰배열실패코드 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        // 2. 배열 정렬 (Two Pointer 사용할거야!)
        Arrays.sort(data);
        // 3. 투포인터를 사용해서 왼쪽 오른쪽 출발!
        int left = 0, right = N - 1;
        int count = 0;
        boolean[] result = new boolean[data.length];
        for (int i = 0; i < data.length; i++) {
//        	System.out.println("data : "+data[i]);
        	while (left < right) {
        		int sum = data[left] + data[right];
//        		System.out.println("sum :"+sum);
        		if (sum == data[i]) { // 3.1 두 수의 합이 M이면 카운트 증가 후 포인터 이동
//        			count++;
        			result[i] = true;
        			left++;
        			right--;
        		} else if (sum < data[i]) { // 3.2 합이 M보다 작으면 left를 증가
        			left++;
        		} else { // 3.3 합이 M보다 크면 right를 감소
        			right--;
        		}
        	}
//        	System.out.println(Arrays.toString(result));
        	left = 0;
        	right = N - 1;
		}
        for (int i = 0; i < result.length; i++) {
			if (result[i]) {
				count++;
			}
		}
        // 4. 결과 출력
        System.out.println(count);
    }
}
