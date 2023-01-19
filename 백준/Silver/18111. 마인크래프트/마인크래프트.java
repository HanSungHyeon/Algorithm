import java.io.*;
import java.util.*;

public class Main {
	public static int[][] land;
	public static int n;
	public static int m;
	public static int b;
	public static int sec = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		int max = 0;
		int min = 256;
		sec = Integer.MAX_VALUE;
		land = new int[n][m];

		for (int i = 0; i < n; i++)
			land[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		// 블럭 최대 높이 = ?, 블럭 최소높이 = 0
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				max = Math.max(max, land[i][j]);
				min = Math.min(min, land[i][j]);
			}
		}
		int result = solution(max, min);
		System.out.printf("%d %d", sec, result);
	}

	public static int solution(int max, int min) {
		int tmpH = 0;
		for (int k = min; k <= max; k++) {
			int time = 0;
			int tmpB = b;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (land[i][j] > k) {
						time += (Math.max(land[i][j], k) - Math.min(land[i][j], k)) * 2;
						tmpB += land[i][j] - k;
					} else if (land[i][j] < k) {
						time += (Math.max(land[i][j], k) - Math.min(land[i][j], k));
						tmpB -= k - land[i][j];
					}
				}
			}
			if (tmpB >= 0) {
				if (Math.min(time, sec) == time) {
					sec = time;
					tmpH = k;
				}
			}
		}
		return tmpH;
	}
}