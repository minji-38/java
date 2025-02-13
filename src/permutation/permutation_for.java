package permutation;

import java.util.Scanner;

/*
 * 순열
 * - 서로 다른 n개의 원소에서 r개를 순서를 고려해서 선택(나열)하는 것을 순열이라고 한다.
 * 
 */
public class permutation_for {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//원소 수
		int N = scan.nextInt();
		
		int[] data = new int[N];
		for (int i = 0; i < N; i++) {
			data[i] = scan.nextInt();
		}
		
		/*
		 * 중복 순열 : 중복해서 원소를 선택		n파이r의 시간복잡도
		 */
		int cnt = 0;
		for (int i = 0; i < N; i++) { 			//첫번째 원소를 반복
			for (int j = 0; j < N; j++) { 		//두번째 원소를 반복
				for (int k = 0; k < N; k++) { 	//세번째 원소를 반복
					cnt++;
					System.out.printf("%d %d %d%n",data[i],data[j],data[k]);
				}
			}
		}
		
		//for문의 깊이를 정해놨기때문에 %d는 받아온 값으로 가능하나 파이3의 3은 변경 불가능
		//이후 재귀함수로 변경해서 depth반복을 한다!!!여기서는 깊이 설정 불가능
		
		System.out.printf("%dTT파이3의 중복 순열의 개수 %d%n",N, N, cnt);
		System.out.println("===================순열========================");
		
		cnt = 0;
		for (int i = 0; i < N; i++) { 			//첫번째 원소를 반복 (중복이 없으니 다 뽑아!)
			for (int j = 0; j < N; j++) { 		//두번째 원소를 반복 (if로 중복을 거른다)
				if(i != j) { //두번째 원소는 첫번째 원소와 같으면 안됨
					for (int k = 0; k < N; k++) { 	//세번째 원소를 반복 (if로 중복을 거른다)
						if (i != k && j != k) { //세번째 원소는 첫번째, 두번째와 같으면 안됨
							cnt++;
							System.out.printf("%d %d %d%n",data[i],data[j],data[k]);
						}
					}
				}
			}
		}
		System.out.printf("%dP3 순열개수 :%d",N,cnt);  
	}
// 3 1 2 3 스캐너에 입력 = 3개 원소 1 2 3
}
