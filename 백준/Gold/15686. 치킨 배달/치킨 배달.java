import java.io.*;
import java.util.*;

public class Main {
	static List<int[]> list;
	static List<int[]> ckList;
	static int[][] arr, result;
	static int m, answer = Integer.MAX_VALUE, sum, n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		ckList = new ArrayList<>();
		result = new int[m][2];
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2) {
					list.add(new int[] { i, j });
				}
			}
		}
		store(0, 0);
		System.out.println(answer);
	}

	public static int dir(int r, int c) {
		int dir = Integer.MAX_VALUE;

		for (int i = 0; i < ckList.size(); i++) {
			int x = ckList.get(i)[0];
			int y = ckList.get(i)[1];

			if (Math.abs(r - x) + Math.abs(c - y) <= dir) {
				dir = Math.min(dir, Math.abs(r - x) + Math.abs(c - y));
			}
		}
		return dir;
	}

	public static void store(int count, int start) {
		if (count == m) {
			for (int i = 0; i < m; i++) {
				ckList.add(new int[] { result[i][0], result[i][1] });
			}
			sol();
			ckList = new ArrayList<>();
			return;
		}

		for (int i = start; i < list.size(); i++) {
			result[count][0] = list.get(i)[0];
			result[count][1] = list.get(i)[1];
			store(count + 1, i + 1);
		}

	}

	public static void sol() {
		int tmp = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1)
					tmp += dir(i, j);
			}
		}
		answer = Math.min(answer, tmp);
	}

}