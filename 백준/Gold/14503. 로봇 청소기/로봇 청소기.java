import java.io.*;
import java.util.*;

public class Main {
	static int n, m, d, r, c,ans = 0;
	static int[][] arr, delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for (int i = 0; i < n; i++)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			
		while (true) {
			if (arr[r][c] == 0) {
				arr[r][c] = -1;
				ans++;
			}
		
			if (isBlank(r, c)) {
				turn();
			} else {
				if (!isBack())
					break;
			}
		}
		System.out.println(ans);
	}

	public static boolean isBlank(int r, int c) {
		for (int i = 0; i < delta.length; i++) {
			int dr = r + delta[i][0];
			int dc = c + delta[i][1];

			if (dr < 0 || dc < 0 || dr >= n && dr >= m)
				continue;

			if (arr[dr][dc] == 0)
				return true;
		}
		return false;
	}

	public static void turn() {
		switch (d) {
		// 북 -> 서
		case 0:
			d = 3;
			if (c - 1 >= 0 && arr[r][c - 1] == 0)
				c--;
			break;
		// 동 -> 북
		case 1:
			d = 0;
			if (r - 1 >= 0 && arr[r - 1][c] == 0)
				r--;
			break;
		// 남 -> 동
		case 2:
			d = 1;
			if (c + 1 < m && arr[r][c + 1] == 0)
				c++;
			break;
		// 서 -> 남
		case 3:
			d = 2;
			if (r + 1 < n && arr[r + 1][c] == 0)
				r++;
			break;
		}
	}

	public static boolean isBack() {
		switch (d) {
		// 동 1
		case 1:
			if (c - 1 >= 0 && arr[r][c - 1] != 1)
				c--;
			else
				return false;
			break;
		// 서 3
		case 3:
			if (c + 1 < m && arr[r][c + 1] != 1)
				c++;
			else
				return false;
			break;
		// 남 2
		case 2:
			if (r - 1 >= 0 && arr[r - 1][c] != 1)
				r--;
			else
				return false;
			break;
		// 북 0
		case 0:
			if (r + 1 < n && arr[r + 1][c] != 1)
				r++;
			else
				return false;
			break;
		}
		return true;
	}
}