package greedy;
//73912KB	648ms (그리디)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 13904 과제 문제의 답을 이용
 * 과제 문제와 다른점은 N의 범위(long타입 써야함)
 * 라면의 최대 개수가 2^31이므로 int타입으로 불가능
 */
public class Main_1781_G2_컵라면_안민지 {

	public static void main(String[] args) throws Exception {
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	     int N = Integer.parseInt(in.readLine());

	     //int[0] : 데드라인, [1]:컵라면 수
	     PriorityQueue<int[]> cupNoodles = new PriorityQueue<>((a,b) ->{
	    	 int result = a[0] - b[0]; //데드라인순으로 정렬 (a-b 오름차순, b-a 내림차순)
	    	 return result == 0 ? b[1] - a[1] : result; //점수순으로 정렬 (내림차순 = 높->낮) 동일 데드라인인 경우 점수를 기준으로 정렬
	     });

//	     2. 데이타 입력 받기. 
	     for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int deadLine = Integer.parseInt(st.nextToken());
			int number = Integer.parseInt(st.nextToken());
			
			cupNoodles.offer(new int[] {deadLine, number});
		}
	     //선택한 문제의 컵라면 수를 담을 PQ (Comparator 지정안하면 기본적으로 오름차순 정렬)
	     PriorityQueue<Long> choose_cup = new PriorityQueue<>();
	     
//	     3. 모든 과제들을 탐색 시도   
	    while(!cupNoodles.isEmpty()) {
//	        3.1 과제를 꺼내와 컵라면 수PQ의 size 와 문제 데드라인을 비교한다.                                                       
//	            ==> 컵라면 수 PQ의 size == 단위 시간 == 데드라인                                                          
	    	int[] hw = cupNoodles.poll();
	    	int d = hw[0];
	    	int s = hw[1];
	    	if (choose_cup.size()< d) {
//	        3.2 데드라인(d)보다 PQ size가 작다면 해당 문제는 풀 수 있는 문제 이므로                                                
//	            바로 점수PQ에 넣는다.
	    		choose_cup.offer((long)s);
	    	} else {
//	        3.3 데드라인이 같거나 크다면 점수PQ의 가장 낮은 점수와 비교해서                                                        
//	            현재 문제의 라면 개수가 높다면 기존 낮은 컵라면 수를 제거하고 현재 문제의 컵라면 수를 넣는다.
	    		if (choose_cup.peek() < s) {
	    			choose_cup.poll(); //기존의 낮은 컵라면 수 제거
	    			choose_cup.offer((long)s); //현재 문제의 컵라면 수 넣기
	    		}
	    	}
	    }
//	     4. 컵라면 수를 합계를 내고 출력한다.                                                                              
	    long result = 0;
	    for (Long s : choose_cup) {
			result += s;
		}
	    System.out.println(result);
	}
}
