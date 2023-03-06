import java.io.*;
import java.util.*;

public class Solution {
	static int d, w, k, ans;
	static int[][] arr, tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			d = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			ans = Integer.MAX_VALUE;
			arr = new int[d][w];
			for (int i = 0; i < d; i++) {
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}

			tmp = new int[d][w];
			for (int i = 0; i < d; i++)
				tmp[i] = arr[i].clone();
			
			ss(0,0);
			
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}

	private static boolean solution() {
		for (int c = 0; c < w; c++) {
			int num = tmp[0][c];
			int count = 1;
			for (int r = 1; r < d; r++) {
				if (num == tmp[r][c])
					count++;
				else {
					count = 1;
					num = tmp[r][c];
				}
				if (count == k)
					break;
			}
			if (count < k)
				return false;
		}
		return true;
	}

	/**
	 * @param row   - 바꿀 행
	 * @param count - 사용한 약품
	 */
	private static void ss(int idx, int row) {
		if(idx >= ans) return;
		
		if (row == d || k <= 1) {
			if (solution())
				ans = Math.min(ans, idx);
			return;
		}

		// 바꾸지 않았을 때
		ss(idx, row + 1);
		// a로
		for (int i = 0; i < w; i++)
			tmp[row][i] = 0;

		ss(idx + 1, row + 1);
		// b로
		for (int i = 0; i < w; i++)
			tmp[row][i] = 1;

		ss(idx + 1, row + 1);

		// 원래대로
		for (int i = 0; i < w; i++)
			tmp[row][i] = arr[row][i];
	}
}