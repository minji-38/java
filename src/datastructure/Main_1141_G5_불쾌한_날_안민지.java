package datastructure;

import java.util.Scanner;
import java.util.Stack;
//651ms 52128MB
public class Main_1141_G5_불쾌한_날_안민지 {
	
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // 입력을 받기 위한 Scanner 객체 생성
        int n = sc.nextInt(); // 소의 수 입력 받기
        int[] data = new int[n]; // 각 소의 키를 저장할 배열 선언

        // 소들의 키 입력 받기
        for(int i = 0; i < n; i++){
            data[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>(); // 키를 저장할 스택 선언
        stack.push(data[0]); // 첫 번째 소의 키를 스택에 넣음
        long result = 0; // 총 볼 수 있는 쌍의 개수를 저장할 변수

        // 두 번째 소부터 반복문 실행
        for(int i = 1; i < n; i++) {
            int d = data[i]; // 현재 소의 키

            // 스택의 top에 있는 소보다 현재 소가 크거나 같다면
            // top에 있는 소는 현재 소를 볼 수 없으므로 제거
            while(!stack.isEmpty() && stack.peek() <= d) {
                stack.pop();
            }

            // 스택에 남아 있는 요소의 개수가 현재 소가 볼 수 있는 소의 수
            result += stack.size();

            // 현재 소의 키를 스택에 추가
            stack.push(d);
        }
        System.out.println(result); // 결과 출력
    }
}
//시간 복잡도 O(n) : 스택에 소가 한 번 들어가거나 한 번 나가고 또 들어갈 일은 없으므로
//나를 볼 수 있는 소들을 스택에 넣어줌
//처음거는 무조건 들어감
//두번째부터 스택의 제일 위에 있는 애가 나를 볼 수 있는 애인지 체크
//볼 수 있는 애면 남기고 볼 수 없는 애면 pop()
//그 후 스택에 남아있는 것들은 나를 볼 수 있는 애들이고 큰순으로 남음
//나를 스택에 추가 
//이어서 반복