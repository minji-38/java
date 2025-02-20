package greedy;
//14616KB	124ms (그리디)
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 많은 점수를 받기 위해 
 * 데드라인이 짧은 과제 중 점수가 높은 것부터 해결하기.
 */
public class Main_13904_G3_과제_안민지 {

	public static void main(String[] args) throws Exception {
		 BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	     int N = Integer.parseInt(in.readLine());

//	     1. 과제와 점수를 담을 PQ를 선언한다.                                                                          
//	        과제들을 데드라인이 짧은순으로 정렬, 점수을 오름차순으로 정렬한다.                                                                
//	        점수 PQ를 사용하는 이유: 데드라인은 좀 느리지만 점수가 높다면 어떤것을 하는게 더 좋은지 비교해야 하므로
	     //int[0] : 데드라인, [1]:점수
	     PriorityQueue<int[]> homework = new PriorityQueue<>((a,b) ->{
	    	 int result = a[0] - b[0]; //데드라인순으로 정렬 (a-b 오름차순, b-a 내림차순)
	    	 return result == 0 ? b[1] - a[1] : result; //점수순으로 정렬 (내림차순 = 높->낮) 동일 데드라인인 경우 점수를 기준으로 정렬
	     });

//	     2. 데이타 입력 받기. 
	     for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int deadLine = Integer.parseInt(st.nextToken());
			int score = Integer.parseInt(st.nextToken());
			
			homework.offer(new int[] {deadLine, score});
		}
	     //선택한 과제의 점수를 담을 PQ (Comparator 지정안하면 기본적으로 오름차순 정렬)
	     PriorityQueue<Integer> choose = new PriorityQueue<>();
	     
//	     3. 모든 과제들을 탐색 시도   
	    while(!homework.isEmpty()) {
//	        3.1 과제를 꺼내와 점수PQ의 size 와 과제 데드라인을 비교한다.                                                       
//	            ==> 점수 PQ의 size == 단위 시간 == 데드라인                                                          
	    	int[] hw = homework.poll();
	    	int d = hw[0];
	    	int s = hw[1];
	    	if (choose.size()< d) {
//	        3.2 데드라인(d)보다 PQ size가 작다면 해당 과제는 수행할 수 있는 과제 이므로                                                
//	            바로 점수PQ에 넣는다.
	    		choose.offer(s);
	    	} else {
//	        3.3 데드라인이 같거나 크다면 점수PQ의 가장 낮은 점수와 비교해서                                                        
//	            현재 과제의 점수가 높다면  기존 낮은 점수를 제거하고 현재 과제의 점수를 넣는다.
	    		if (choose.peek() < s) {
	    			choose.poll(); //기존의 낮은 점수 제거
	    			choose.offer(s); //현재 과제의 점수 넣기
	    		}
	    	}
	    }
//	     4. 점수를 합계를 내고 출력한다.                                                                              
	    int result = 0;
	    for (Integer s : choose) {
			result += s;
		}
	    System.out.println(result);
	}

}
