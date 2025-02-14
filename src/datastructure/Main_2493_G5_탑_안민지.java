package datastructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//980ms 134256KB
public class Main_2493_G5_탑_안민지 {
	
    public static void main(String[] args) throws Exception{
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
         int n = Integer.parseInt(br.readLine()); // 탑의 개수 입력 받기

         StringTokenizer st = new StringTokenizer(br.readLine()); // 타워 높이 한 줄 입력을 한 번에 처리
         StringBuilder result = new StringBuilder(); 

         Stack<Integer> heights = new Stack<>(); // 높이만 저장하는 스택
         Stack<Integer> index = new Stack<>(); // 해당 높이의 인덱스 저장하는 스택
         
        // 첫번째 탑부터 시작
        for(int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());

            // 현재 탑보다 낮거나 같은 탑은 수신 불가능이니 제거
            while(!heights.isEmpty() && heights.peek() < height) {
            	heights.pop();
            	index.pop();
            }
            if (index.isEmpty()) { //수신한 탑이 없는 경우
            	result.append("0 ");
            }else {
	        	// 스택에 남아 있는 요소중 최상단은 레이저를 수신하는 탑(인덱스 필요함~)
	        	result.append(index.peek()+ " ");
            }

            // 현재 탑을 스택에 추가
            heights.push(height);
            index.push(i);
        }
        System.out.println(result.toString().trim()); // 결과 출력
    }
}