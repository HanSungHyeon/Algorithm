import java.io.*;
import java.util.*;

/*
 * dfs로 했을 경우 시간초과
 * 최소 시간을 구하는 문제이기 때문에 bfs로 풀이
 * 고려해야할 점
 * bfs 안에서
 * 원숭이가 할 수 있는 점프 횟수가 남았을 경우 점프하거나 그냥 가거나 둘 중 하나
 * 점프횟수가 남지 않았을 경우 무조건 그냥 감
 * 3가지 경우 다 작성해보기
 */
public class Main {
	static class Node {
		int x, y, jump, move;

		public Node(int x, int y, int jump, int move) {
			this.x = x;
			this.y = y;
			this.jump = jump;
			this.move = move;
		}
	}

	static int k, row, col, ans = Integer.MAX_VALUE;
	static int[][] arr;
	static boolean[][][] flag;
	// 점프
	static int[][] jumping = { { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 }, { -2, -1 } };
	// 그냥
	static int[][] walk = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	// 범위 안에 들어왔는지
	private static boolean isIn(int dx, int dy, int jump) {
		if (dx < 0 || dy < 0 || dx >= row || dy >= col || flag[dx][dy][jump] || arr[dx][dy] == 1)
			return false;
		return true;
	}

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, k, 0));
		
		for(int i = 0; i < k; i++)
			flag[0][0][i] = true;

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int jump = q.peek().jump;
			int move = q.peek().move;
			q.poll();
			
//			System.out.println("x : " + x + " y : " + y + " jump : " + jump + " move : " + move);
			if(x == row - 1 && y == col - 1) {
				ans = move;
				break;
			}

			// 점프 횟수가 있는 경우
			if (jump > 0) {
				for (int i = 0; i < jumping.length; i++) {
					int dx = x + jumping[i][0];
					int dy = y + jumping[i][1];

					if (!isIn(dx, dy,jump - 1))
						continue;

					flag[dx][dy][jump - 1] = true;
					q.add(new Node(dx, dy, jump - 1, move + 1));
				}
				// 점프 횟수는 있지만 그냥 한 칸 넘어갈 경우
				for (int i = 0; i < walk.length; i++) {
					int dx = x + walk[i][0];
					int dy = y + walk[i][1];

					if (!isIn(dx, dy,jump))
						continue;

					flag[dx][dy][jump] = true;
					q.add(new Node(dx, dy, jump, move + 1));
				}
			}
			// 점프 횟수가 없어서 그냥 한 칸 넘어가는 경우
			if (jump == 0) {
				for (int i = 0; i < walk.length; i++) {
					int dx = x + walk[i][0];
					int dy = y + walk[i][1];

					if (!isIn(dx, dy,jump))
						continue;

					flag[dx][dy][jump] = true;
					q.add(new Node(dx, dy, jump, move + 1));
				}
			}

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		k = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());

		flag = new boolean[row][col][k + 1];
		arr = new int[row][col];
		for (int i = 0; i < row; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		bfs();
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}
}