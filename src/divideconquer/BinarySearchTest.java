package divideconquer;
import java.util.Arrays;
/*
 * 탐색하려는 데이타가 배열 내에 있는지 확인하기 위해 
 * 1. 배열의 중간 값과 비교해서 작으면 왼쪽 크면 오른쪽으로 이동한다. 
 * 2. 찾을 때까지 1번을 반복후 찾은 위치의 index를 반환한다. 못찾은 경우 -1을 반환한다.  
 */
public class BinarySearchTest {
	private static int[] values= {20,3,45, 11, 15,  21, 29, 72,  59, 65};	
	static int mid;
	public static void main(String[] args) {
		//step0.정렬하기 : 이진 탐색은 정렬된 데이타만 탐색할 수 있다. 
		Arrays.sort(values);
		System.out.println(Arrays.toString(values));
		System.out.println(binarySearch1(65));
		System.out.println(binarySearch1(2));
		System.out.println("===================================");
		System.out.println(binarySearch2(65,0,values.length-1));
		System.out.println(binarySearch2(2,0,values.length-1));
		System.out.println("===================================");
		// 못찾으면 -insertion point-1 값 리턴(0인덱스와 구분하기 위해 음수화시키고 -1)
		System.out.println(Arrays.binarySearch(values, 65));
		System.out.println(Arrays.binarySearch(values, 12)); //-3이 나옴
		//[3, 11, 15, 20, 21, 29, 45, 59, 65, 72] 에 12가 3, 11, 12로 들어갈만하니까
		//2번 인덱스에 들어갈것 같아~ 라고 하면서 2인덱스를 던지지만, 12는 배열에 없어서 음수를 던지고
		//기본적으로 -1을 가지고 있어서 -3을 줌!
		//이미 -1을 줬기때문에 2번째 위치에 넣을래도 -3을 반환. 절대값 변환 후 -1 해줘야 해당
		//인덱스가 들어갈만한 위치가 나옴
		//추후 해당 위치에 데이타를 추가할 때에는 Math.abs(idx)-1;
	}
	//반복문으로 짜기
	private static int binarySearch1(int key) {
		//찾으려는 범위의 시작 위치, 끝 위치, 중간 위치를 위한 변수를 선언한다. 
		int start = 0;
		int end = values.length-1;
		int count =0;
		
		// 데이타를 찾을 때 까지 반복 하면서 
		while (start <= end) {
			// 주어진 범위를 이용해서 mid값을 구한다. 
			mid = (start+end)>>1;
			count++;
			// mid 위치에 데이타와 탐색하려는 데이타가 같으면 mid 위치를 반환한다.
			if (key == values[mid]) {
				System.out.printf("%d번만에 %d를 찾았습니다! values[%d]에 있습니다.\n",count, key,mid);
				return mid;
			} else if (key > values[mid]) {
				// mid 위치의 데이타 보다 탐색하려는 데이타가 크면 start 위치를 mid_1로 바꾼다. 
				System.out.printf("%d보다 높은수를 찾으세요!\n",values[mid]);
				start = mid +1;
			} else {
				// mid 위치의 데이타 보다 탐색하려는 데이타가 작으면 end 위치를 mid-1로 바꾼다. 
				System.out.printf("%d보다 낮은수를 찾으세요!\n",values[mid]);
				end = mid -1;
			} 
		}
		// 데이타를 못 찾은 경우 -1을 리턴
		System.out.printf("%d 숫자는 찾지 못했습니다..!\n",key);
		return -1;
	}
	
	//재귀로 짜기
	static int count = 0;
	private static int binarySearch2(int key,int start,int end) {
		if (start > end) {
			// 데이타를 못 찾은 경우 -1을 리턴
			System.out.printf("%d 숫자는 찾지 못했습니다..!\n",key);
			return -1;
		}
		mid = (start+end)>>1;
		count++;
		if (key == values[mid]) {
			System.out.printf("%d번만에 %d를 찾았습니다! values[%d]에 있습니다.\n",count, key,mid);
			return mid;
		} else if (key > values[mid]) {
			// mid 위치의 데이타 보다 탐색하려는 데이타가 크면 start 위치를 mid_1로 바꾼다. 
			System.out.printf("%d보다 높은수를 찾으세요!\n",values[mid]);
			start = mid +1;
			binarySearch2(key, mid + 1, end);
		} else {
			// mid 위치의 데이타 보다 탐색하려는 데이타가 작으면 end 위치를 mid-1로 바꾼다. 
			System.out.printf("%d보다 낮은수를 찾으세요!\n",values[mid]);
			end = mid -1;
			binarySearch2(key,start, mid-1);
		} 
		return -1;
	}	
}
