package recursive;

public class RecursiveCallTest4 {
	//피보나치 수열은 top -> down 방식을 통해 재귀함수로 구할 수 있다.
	//1 1 2 3 5 8 13   (1+1) = 2 (1+2) = 3 (2+3) = 5....
	public static void main(String[] args) {
		System.out.println(fibo(7));
	}
	public static int fibo(int n) {
		if (n <= 2) {return 1;} //피보나치수열 1,2번째 값은 1로 고정
		return fibo(n-1) + fibo(n-2); //현재값의 앞 값, 그 앞 값을 더하면 다음 현재값이 나옴
		
	}

}
