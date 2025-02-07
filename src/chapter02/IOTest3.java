package chapter02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class IOTest3 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		/* 
		 * System.in은 기본적으로 keyboard로 부터 입력 받지만,
		 * 다른 대상으로부터 입력 받을 경우 setIn(입력 받을 대상) 함수로 설정한다. 
		 */
		BufferedReader br = new BufferedReader(new StringReader(input));
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		System.out.println(line);

		/*
		 * split(구분자) : 구분자를 기준으로 데이타를 분리
		 */
		String[] tokens1 = line.split(""); //구분자를 제공하지 않았으므로 1개씩 조각낸다. [1, 0,  , 9,  , 8,  , 1, 1,  , 5]
		System.out.println(Arrays.toString(tokens1));
		String[] tokens2 = line.split(" "); //띄어쓰기 " "를 기준으로 조각냄 [10, 9, 8, 11, 5]
		System.out.println(Arrays.toString(tokens2));
		//숫자로 바꾸려면 for문 또돌아야함... 성능별로
		/*
		 * StringTokenizer :  구분자를 기준으로 데이타를 분리
		 */
//		StringTokenizer st = new StringTokenizer(line); //알아서 분리해줘!
		StringTokenizer st = new StringTokenizer(line," ");//공백 찾아서 분리해줘!
		int n = 5;
		for (int i = 0; i < n; i++) {
//			System.out.println(st.nextToken()); 
			//숫자로 변경하려면 for문 안에서 한번에 처리가능 (해당 방식을 더 많이 씀)
			System.out.println(Integer.parseInt(st.nextToken()));
		}
	}
	static String input = "10 9 8 11 5";
}
