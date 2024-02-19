import java.io.*;
import java.util.*;

public class Main {
	static int n, count = 0;
	static int[][] arr;
	static int[][] delta = { { 1, -1 }, { 1, 0 }, { 1, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		back(0);
		System.out.println(count);
	}
	private static void print() {
		for(int i =0 ;i < n; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("-----------------------------");
	}

	private static void back(int row) {
		if(row == n) {
			count++;
//			print();
			return;
		}
		
		for (int i = 0; i < n; i++) {
			// 퀸 놓을 수 있음
			if (arr[row][i] == 0) {
				arr[row][i]++;
				// 공격로 표시
				for (int d = 0; d < 3; d++) {
					int dx = row;
					int dy = i;
					while (true) {
						dx += delta[d][0];
						dy += delta[d][1];

						if (dx < 0 || dy < 0 || dx >= n || dy >= n)
							break;

						arr[dx][dy]++;
					}
				}
				back(row + 1);
				// 공격로 제거
				arr[row][i]--;
				for (int d = 0; d < 3; d++) {
					int nx = row;
					int ny = i;
					while (true) {
						nx += delta[d][0];
						ny += delta[d][1];

						if (nx < 0 || ny < 0 || nx >= n || ny >= n)
							break;

						arr[nx][ny]--;
					}
				}
			}
		}
	}
}