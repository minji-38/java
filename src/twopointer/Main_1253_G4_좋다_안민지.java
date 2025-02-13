package twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 좋다 정답 코드
 * 현재 검사 중인 data[i]를 제외한 범위에서 투 포인터를 실행
 */
/*
 * 초기 코드의 문제점을 수정함!
 * 1. 현재 검사 중인 값을 제외하지 않았음 (짧은 배열에서는 상관 없으나, 더 긴 배열에서는 메모리 초과~)
 * 2. 모든 배열을 순회하면서 더한 값이 배열에 있는지 확인 할 필요가 없음!
 * 한번 배열에서 찾았으면 이미 true 이기 때문에 뒤에 부분은 계산 할 필요가 없다. break로 나와라~
 */
public class Main_1253_G4_좋다_안민지 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(data);

        int count = 0;

        for (int i = 0; i < N; i++) {
            int left = 0;
            int right = N - 1;

            while (left < right) {
                if (left == i) { // 현재 검사 중인 값 제외
                    left++;
                    continue;
                }
                if (right == i) { // 현재 검사 중인 값 제외
                    right--;
                    continue;
                }

                int sum = data[left] + data[right];

                if (sum == data[i]) { 
                    count++;
                    break; // 찾았으면 더 이상 검사할 필요 없음
                } else if (sum < data[i]) { 
                    left++;
                } else { 
                    right--;
                }
            }
        }
        System.out.println(count);
    }
}

