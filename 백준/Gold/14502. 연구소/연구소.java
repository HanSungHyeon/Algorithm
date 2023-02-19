import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] arr, tmp;
	static int n, m, answer = Integer.MIN_VALUE;
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][m];

		for (int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		wall(0);
		System.out.println(answer);

	}

	// 벽 세우기 - 백트래킹
	public static void wall(int num) {
		if (num == 3) {
			// 벽 3개 다 세웠으면은 바이러스 퍼뜨리면서 안전영역 계산
			bfs();
			safe();
//			System.out.println(answer);
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					wall(num + 1);
					// 벽 다 세웠으면 이전꺼 지우고 다음 벽
					// ex) (1 1 1) -> (1 1 0 1)
					arr[i][j] = 0;
				}
			}
		}
	}

	// 바이러스 퍼뜨리기
	public static void bfs() {
		copy();
		virusPut();
		
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();
			
			for (int i = 0; i < delta.length; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= m)
					continue;

				if (tmp[dx][dy] == 0) {
					tmp[dx][dy] = 2;
					q.add(new Node(dx, dy));
				}
			}
		}
	}

	// 큐에 바이러스 넣기
	public static void virusPut() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (tmp[i][j] == 2) {
					q.add(new Node(i, j));
				}
			}
		}
	}

	public static void copy() {
		tmp = new int[n][m];

		for (int i = 0; i < n; i++) {
			tmp[i] = arr[i].clone();
		}
	}
	public static void safe() {
		int num = 0;
		for(int i =0 ; i< n; i++) {
			for(int  j = 0 ; j < m; j++) {
				if(tmp[i][j] == 0) {
					num++;
				}
			}
		}
		answer = Math.max(answer,num);
	}
}