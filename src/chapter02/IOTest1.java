package chapter02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class IOTest1 {

	public static void main(String[] args) throws Exception{
		/*
		 * System.in  → 키보드로부터 입력받음 (기본적으로 1바이트씩 처리)
		 * InputStreamReader → 바이트 스트림을 문자 스트림으로 변환 (2바이트씩 처리)
		 * BufferedReader → 한 줄(String 단위)로 입력받을 수 있도록 도와줌
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*
		 * file로부터 입력 받기
		 */
//		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = br.readLine();
		
		System.out.println(line);
		

	}

}
