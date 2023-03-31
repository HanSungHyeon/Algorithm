import java.io.*;
import java.util.*;

/*
 * bfs 한 번 쓱 돌고 나오면 time++
 * 치즈 바로 녹여도 괜찮음
 * -> 치즈 녹이고 해당 부분 방문 처리를 해버리면
 * 	     뒷 공간 어차피 못 들어감
 *    bfs 다시 돌 때 방문배열도 초기화 해주어야 야무지게 돌 수 있음
 * 
 */
public class Main {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static long cheese;
	static int n, m;
	static int[][] arr, delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		flag = new boolean[n][m];

		for (int i = 0; i < n; i++)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		cheese = count();

		int time = 0;
		long ans = 0;

		while (true) {
			if (cheese == 0)
				break;
			ans = cheese; //bfs 돌기 직전 치즈 갯수
			//방문 배열 초기화
			for (int i = 0; i < n; i++)
				Arrays.fill(flag[i], false);
			bfs();
			time++;
		}
		System.out.println(time);
		System.out.println(ans);
	}

	// 처음에 받아온 치즈 갯수 count
	private static long count() {
		long count = 0;
		for (int i = 0; i < n; i++)
			count += Arrays.stream(arr[i]).filter(x -> x == 1).count();

		return count;
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0));
		flag[0][0] = true;

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();

			for (int i = 0; i < delta.length; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= m || flag[dx][dy])
					continue;

				if (arr[dx][dy] == 0) {
					flag[dx][dy] = true;
					q.add(new Node(dx, dy));
				} else if (arr[dx][dy] == 1) {
					flag[dx][dy] = true;
					arr[dx][dy] = 0;
					cheese--;
				}
			}
		}
	}
}