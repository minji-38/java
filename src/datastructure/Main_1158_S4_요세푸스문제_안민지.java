package datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
//16740KB 232ms
/*
 * N(숫자 전체 수)의 범위가 낮은 경우에는 해당 코드로 가능,
 * 범위가 높아질수록 해당 코드로 풀 수 없다(시간초과,메모리초과)
 * 추후 LinkedList로 풀어야할수도~
 * 
 * Queue에 1~N까지 숫자를 넣는다.
 * K-1번만큼 앞에서 빼고 다시 뒤에 추가한다.
 * K번째 요소는 제거한다.
 * Queue가 빌때까지 반복해준다.
 */

public class Main_1158_S4_요세푸스문제_안민지 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());


        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (!queue.isEmpty()) {
            for (int i = 1; i < K; i++) {
				queue.add(queue.poll()); //K번째 전까지 앞에서 뺀 다음 뒤로 보낸다!
			}
            sb.append(queue.poll()); //K번째 사람 없애기
            if (!queue.isEmpty()) {
                sb.append(", ");
            }
        }

        sb.append(">");
        System.out.println(sb);
    }
}

