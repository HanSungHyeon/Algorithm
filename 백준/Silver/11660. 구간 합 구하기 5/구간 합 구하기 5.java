import java.io.*;
import java.util.*;

public class Main {
	static int[][] d;
	static int n, x1, y1, x2, y2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		d = new int[n + 1][n + 1];
		
		// 숫자 입력
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int temp = Integer.parseInt(st.nextToken());
				d[i][j] = d[i - 1][j] + d[i][j - 1] - d[i - 1][j - 1] + temp;
			}
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			sb.append(get() + "\n");
		}
		System.out.println(sb);

//		for (int i = 0; i < d.length; i++)
//			System.out.println(Arrays.toString(d[i]));
	}

	public static int get() {
		return d[x2][y2] - d[x1 - 1][y2] - d[x2][y1 - 1]+d[x1 - 1][y1 - 1];
	}
}
