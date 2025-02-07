package chapter02;

import java.io.File;
import java.util.Scanner;

public class IOTest4_scanner {

	public static void main(String[] args) throws Exception{
		//키보드로부터 읽기
//		Scanner scan = new Scanner(System.in);
		
		//파일로부터 읽기
		Scanner scan = new Scanner(new File("input.txt"));
		
		int n = 5;
		for (int i = 0; i < n; i++) {
			System.out.println(scan.nextInt());
		}
	}
	static String input = "10 9 8 11 5"; //메소드 바깥에서 선언시 static 붙이자~
}
