import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int m, n, k;
	static boolean[][] arr;
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new boolean[m][n];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			paper(x, y, x2, y2);
		}
		
//		print();
		
		List<Integer> list = new ArrayList<>();
		int ans = 0;
		for (int c = 0; c < n; c++) {
			for (int r = m - 1; r >= 0; r--) {
				if (!arr[r][c]) {
					ans++;
					list.add(bfs(r,c));
				}
					
			}
		}
		Collections.sort(list);
		for(int i : list) sb.append(i + " ");
		
		System.out.println(ans);
		System.out.println(sb);
	}

	// 영역 크기 구하기
	private static int bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		arr[x][y] = true;
		int count = 1;

		while (!q.isEmpty()) {
			int r = q.peek().x;
			int c = q.peek().y;
			q.poll();

			for (int i = 0; i < 4; i++) {
				int dr = r + delta[i][0];
				int dc = c + delta[i][1];

				if (dr < 0 || dc < 0 || dr >= m || dc >= n || arr[dr][dc])
					continue;

				q.add(new Node(dr, dc));
				arr[dr][dc] = true;
				count++;
			}
		}
		return count;
	}

	// 모눈 종이 붙이기
	private static void paper(int x, int y, int x2, int y2) {
		for (int i = x; i < x2; i++) {
			for (int j = y; j < y2; j++) {
				arr[j][i] = true;
			}
		}
	}

	private static void print() {
		for (int i = 0; i < m; i++)
			System.out.println(Arrays.toString(arr[i]));
	}
}