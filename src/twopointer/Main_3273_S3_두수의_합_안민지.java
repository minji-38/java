package twopointer;
//27220KB 	312ms
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *  1. 배열을 정렬한다.
	2. 두 개의 포인터(left, right)를 사용해 left는 가장 왼쪽(작은 값), right는 **가장 오른쪽(큰 값)**에서 시작한다.
	현재 합(sum)이 M과 같으면 카운트 증가,
	작으면 left++ (더 큰 수를 찾음)
	9
	5 12 7 10 9 1 2 3 11
	13크면 right-- (더 작은 수를 찾음)
	두 포인터가 교차할 때까지 반복한다.
 */
public class Main_3273_S3_두수의_합_안민지 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 입력 받기
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine()); //되야하는 수

        // 2. 배열 정렬 (Two Pointer 사용할거야!)
        Arrays.sort(data);

        // 3. 투포인터를 사용해서 왼쪽 오른쪽 출발!
        int left = 0, right = N - 1;
        int count = 0;

        while (left < right) {
            int sum = data[left] + data[right];

            if (sum == M) { // 3.1 두 수의 합이 M이면 카운트 증가 후 포인터 이동
                count++;
                left++;
                right--;
            } else if (sum < M) { // 3.2 합이 M보다 작으면 left를 증가
                left++;
            } else { // 3.3 합이 M보다 크면 right를 감소
                right--;
            }
        }

        // 4. 결과 출력
        System.out.println(count);
    }
}
