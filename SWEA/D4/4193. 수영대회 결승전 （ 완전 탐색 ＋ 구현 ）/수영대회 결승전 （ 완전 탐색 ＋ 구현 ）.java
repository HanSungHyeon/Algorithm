import java.io.*;
import java.util.*;

/*
 * 소용돌이는 0 1 유지 2초에 사라짐
 *        3 4 유지 5초에 사라짐
 *        6 7 유지 8초에 사라짐
 * -> time % 3 = 2
 */
public class Solution {
	static class Node {
		int x, y, time;

		public Node(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}

	static int n, sr, sc, er, ec,ans;
	static int[][] arr, delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] flag;

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sr, sc, 0));

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int time = q.peek().time;
			q.poll();
//			System.out.println(x + " " + y + " " + time);
			if(x == er && y == ec) {
				ans = time;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= n || flag[dx][dy])
					continue;
				
				//소용돌이 지역일  때
				if(arr[dx][dy] == 2) {
					//건널 수 있다면 건넌다
					if(time % 3 == 2) {
						flag[dx][dy] = true;
						q.add(new Node(dx,dy,time + 1));
					}
					//건널 수 없다면 건너지 않고 시간이 흐름
					else {
						flag[x][y] = true;
						q.add(new Node(x,y,time + 1));
					}
				}
				//길이고 방문 한 적이 없을 때
				else if(arr[dx][dy] == 0 && !flag[dx][dy]) {
					//건넌다
					q.add(new Node(dx,dy,time + 1));
					flag[dx][dy] = true;
				}
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			flag = new boolean[n][n];
            ans = -1;
			for (int i = 0; i < n; i++)
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			StringTokenizer st = new StringTokenizer(br.readLine());
			sr = Integer.parseInt(st.nextToken());
			sc = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			er = Integer.parseInt(st.nextToken());
			ec = Integer.parseInt(st.nextToken());
			
			bfs();
			System.out.println("#" + t + " " + ans);
		}
	}
}