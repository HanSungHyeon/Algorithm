import java.io.*;
import java.util.*;

/*
 * 왼 -> 오
 * 오르막길만 확인 올라갈 수 없으면 false
 * 내리막길 등장시 걍 무시하고 count 갱신
 * 
 * 오 -> 왼
 * 왼쪽에서 오른쪽 확인 올라갈 수 없으면 false
 * 내리막길 등장시 걍 무시하고 count 갱신
 */
public class Solution {
	static int n, x;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			arr = new int[n][n];

			for (int i = 0; i < n; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			int ans = 0;
			for(int i = 0; i < n; i++) {
				if(colLtoR(i) && colRtoL(i)) {
//					System.out.println("가로탐색 : " + i);
					ans++;
				}
				if(rowDtoU(i) && rowUtoD(i)) {
//					System.out.println("세로 탐색 : " + i);
					ans++;
				}
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	private static boolean colLtoR(int row) {
		// 왼쪽에서 오른쪽 탐색
		int num = arr[row][0];
		int count = 1;
		for (int i = 1; i < n; i++) {
			// 번호가 같으면 count + 1
			if (arr[row][i] == num)
				count++;

			// 오르막길 등장
			else if (arr[row][i] - num == 1) {
				//경사로를 사용할 수 있으면
				if(count >= x) {
					count = 1;
					num = arr[row][i];
				}
				else return false;
			}
			// 내리막길 등장
			else if(num > arr[row][i]) {
				count = (-1 * x) + 1;
				num = arr[row][i];
			}
			//경사로 설치가 불가능할 때
			else {
				return false;
			}
		}
		return true;
	}
	
	private static boolean colRtoL(int row) {
		// 오른쪽에서 왼쪽 탐색
		int num = arr[row][n - 1];
		int count = 1;
		for (int i = n - 2; i >= 0; i--) {
			// 번호가 같으면 count + 1
			if (arr[row][i] == num)
				count++;

			// 오르막길 등장
			else if (arr[row][i] - num == 1) {
				//경사로를 사용할 수 있으면
				if(count >= x) {
					count = 1;
					num = arr[row][i];
				}
				else return false;
			}
			// 내리막길 등장
			else if(num > arr[row][i]) {
				count = (-1 * x) + 1;
				num = arr[row][i];
			}
			//경사로 설치가 불가능할 때
			else {
				return false;
			}
		}
		return true;
	}
	
	private static boolean rowUtoD(int col) {
		// 위에서 아래로
		int num = arr[0][col];
		int count = 1;
		for (int i = 1; i < n; i++) {
			// 번호가 같으면 count + 1
			if (arr[i][col] == num)
				count++;

			// 오르막길 등장
			else if (arr[i][col] - num == 1) {
				//경사로를 사용할 수 있으면
				if(count >= x) {
					count = 1;
					num = arr[i][col];
				}
				else return false;
			}
			// 내리막길 등장
			else if(num > arr[i][col]) {
				count = (-1 * x) + 1;
				num = arr[i][col];
			}
			//경사로 설치가 불가능할 때
			else {
				return false;
			}
		}
		return true;
	}
	
	private static boolean rowDtoU(int col) {
		// 위에서 아래로
		int num = arr[n - 1][col];
		int count = 1;
		for (int i = n - 2; i >= 0; i--) {
			// 번호가 같으면 count + 1
			if (arr[i][col] == num)
				count++;

			// 오르막길 등장
			else if (arr[i][col] - num == 1) {
				//경사로를 사용할 수 있으면
				if(count >= x) {
					count = 1;
					num = arr[i][col];
				}
				else return false;
			}
			// 내리막길 등장
			else if(num > arr[i][col]) {
				count = (-1 * x) + 1;
				num = arr[i][col];
			}
			//경사로 설치가 불가능할 때
			else {
				return false;
			}
		}
		return true;
	}
}