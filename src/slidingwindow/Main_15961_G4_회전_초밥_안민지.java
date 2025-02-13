package slidingwindow;
//map 에서 set 써서 만들었따~
import java.util.HashMap;
import java.util.Scanner;
// 2884ms 334188KB
public class Main_15961_G4_회전_초밥_안민지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 첫 번째 줄 입력
        int N = sc.nextInt(); // 접시 수
        int d = sc.nextInt(); // 초밥 가짓수 (사용 안 함)
        int k = sc.nextInt(); // 연속해서 먹는 접시 수
        int c = sc.nextInt(); // 쿠폰 번호 (이 번호의 초밥은 무조건 먹을 수 있음)
        
        // 초밥 종류 입력
        int[] nums = new int[N]; // 초밥 종류 배열
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt(); // 각 접시에 있는 초밥 번호
        }
        
        sc.close(); // Scanner 자원 반납
        
        int max = 0; // 최대 고른 초밥 종류의 개수
        HashMap<Integer, Integer> eating = new HashMap<>(); // 현재 먹고 있는 초밥 종류와 개수 (중복 처리)
        
        // 처음 k 개 초밥을 먹음 (슬라이딩 윈도우의 첫 번째 창)
        for (int i = 0; i < k; i++) {
            eating.put(nums[i], eating.getOrDefault(nums[i], 0) + 1); // 초밥 종류별로 먹은 횟수 갱신
        }
        
        // 쿠폰 초밥 추가하기 (쿠폰으로 제공되는 초밥은 무조건 먹음)
        eating.put(c, eating.getOrDefault(c, 0) + 1); // 쿠폰 초밥도 포함
        max = eating.size(); // 처음 최대 값은 현재 먹은 초밥 종류의 수
        
        // 슬라이딩 윈도우 기법 적용 (슬라이딩 윈도우를 통해 배열을 한 칸씩 옮기며 검사)
        for (int i = 0; i < N; i++) {
            int removeIdx = i; // 윈도우에서 나가는 초밥
            int addIdx = (i + k) % N; // 윈도우에 들어오는 초밥 (순환되기 때문에 나머지 연산 사용)
            
            // 첫 번째 요소 제거 (윈도우에서 나가는 초밥)
            if (eating.get(nums[removeIdx]) == 1) {
                eating.remove(nums[removeIdx]); // 만약 해당 초밥이 한 번만 있었으면 제거
            } else {
                eating.put(nums[removeIdx], eating.get(nums[removeIdx]) - 1); // 아니면 개수만 줄임
            }
            
            // 새로운 요소 추가 (윈도우에 새로 들어오는 초밥)
            eating.put(nums[addIdx], eating.getOrDefault(nums[addIdx], 0) + 1); // 새 초밥 추가
            
            // 최대값 갱신 (현재 상태에서 먹은 초밥 종류 수가 최대인 경우 저장)
            max = Math.max(max, eating.size());
        }
        
        // 결과 출력
        System.out.println(max); // 최대 초밥 종류의 개수 출력
    }
}
