import java.io.*;
import java.util.*;

/*
 * 1 : 익은 토마토
 * 0 : 익지 않은 토마토
 * -1 : 빈칸
 * 
 */
public class Main {
	static class Tomato {
		int x, y, level, time;

		public Tomato(int x, int y, int level, int time) {
			this.x = x;
			this.y = y;
			this.level = level;
			this.time = time;
		}
	}

	static int r, c, h, ans = Integer.MIN_VALUE, count0;
	static int[][][] arr;
	static int[][] delta = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, -1 }, { 0, 0, 1 } };
	static Queue<Tomato> q = new LinkedList<>();

	private static void bfs() {
		// tmp : 안 익은 토마토 갯수를 세줄 변수
		// 토마토를 익힐 때마다 갯수 증가시킴
		// 익혀버림 토마토와 처음에 받은 안익은 토마토 갯수가 같으면 다 익힌거임
		int tmp = 0;
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int level = q.peek().level;
			int time = q.peek().time;
			q.poll();

			//System.out.println("x : " + x + " y : " + y + " level : " + level + " time : " + time);

			ans = Math.max(time, ans);

			for (int i = 0; i < 6; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];
				int dlevel = level + delta[i][2];

				// 같은 층에서 범위 벗어날 경우
				if (dx < 0 || dy < 0 || dx >= r || dy >= c)
					continue;

				// 층 범위를 벗어날 경우
				if (dlevel < 0 || dlevel >= h)
					continue;

				// 안익은 토마토가 있을 때 -> 토마토 익혀버림
				if (arr[dx][dy][dlevel] == 0) {
					tmp++;
					arr[dx][dy][dlevel] = 1;
					q.add(new Tomato(dx, dy, dlevel, time + 1));
				}
			}
		}
//		System.out.println("tmp : " + tmp);
		if (tmp != count0)
			ans = -1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		arr = new int[r][c][h];
		int count1 = 0;
		count0 = 0;
		int noTomato = 0;
		// 토마토 정보 입력
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < r; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < c; k++) {
					arr[j][k][i] = Integer.parseInt(st.nextToken());
					if (arr[j][k][i] == -1)
						noTomato++;
					else if (arr[j][k][i] == 0)
						count0++;
					else {
						count1++;
						q.add(new Tomato(j, k, i, 0));
					}
				}
			}
		}

		if (count1 + noTomato == r * c * h)
			ans = 0;
		else
			bfs();
		System.out.println(ans);
	}
}