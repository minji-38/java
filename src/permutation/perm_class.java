package permutation;

import java.util.Arrays;

public class perm_class {
	static long tc;
	static long count;
	static int N;
	static int R;
	static int[] input;
	static int[] numbers;
	public static void perm(int depth, int flag) {
		if (depth == R) {
			tc++;
			System.out.println(Arrays.toString(numbers));
			return;
		}
		for (int i = 0; i < N; i++) {
			count++;
			if((flag & 1 << i) != 0) continue;
			numbers[depth] = input[i];
			perm(depth+1,flag|1<<i);
		}
	}
	
	public static void main(String[] args) {
		input = new int[] {1,2,3};
	    N = input.length;
	    R = input.length;
	    numbers = new int[R];   
	    long start = System.currentTimeMillis();
	    perm(0, 0);
	    long end = System.currentTimeMillis();
	    System.out.printf("tc: %d   count:%d   time:%dms%n", tc, count, end-start);
	}

}
