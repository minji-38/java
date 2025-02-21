package divideconquer;

import java.util.Iterator;
import java.util.Scanner;

public class paper_cut {
	static int[][] paper;
	static int white = 0;
	static int blue = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		paper = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		
		cut(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
		
		sc.close();
	}
	private static void cut(int x, int y, int size) {
		if (colorCheck(x,y,size)) {
			if (paper[x][y] == 0) {
				white++;
			} else {
				blue++;
			}
			return;
		}
		int half = size / 2;
		cut(x,y,half);
		cut(x,y+half,half);
		cut(x+half,y,half);
		cut(x+half,y+half,half);
	}
	private static boolean colorCheck(int x, int y, int size) {
		int color = paper[x][y];
		for (int i = x; i < x+size; i++) {
			for (int j = y; j < y+size; j++) {
				if (paper[x][y] != color) {
					return false;
				}
			}
		}
		return false;
	}
}
