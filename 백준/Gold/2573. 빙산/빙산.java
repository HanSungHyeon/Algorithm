/*
* 3 <= n , m <= 300
* */

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
	static int n, m;
	static int[][] arr, copy, delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][] flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		copy = new int[n][m];

		for(int i = 0 ; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		flag = new boolean[n][m];
		//초기 빙산 갯수 구하기
		int init = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!flag[i][j] && arr[i][j] != 0) {
					counting(i, j);
					init++;
				}
			}
		}

		int year = 0;
		while(true) {
			year++;
			copy();
			//1년 흐름
			bfs();
			//빙산 갯수 다시 세기
			flag = new boolean[n][m];
			int count = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(!flag[i][j] && arr[i][j] != 0) {
						counting(i, j);
						count++;
					}
				}
			}
            
			if(count == 0) {
				year = 0;
				break;
			}
			else if(count > init) {
				break;
			}
		}
		System.out.println(year);
	}

	static void bfs() {
		Queue<Node> q = new LinkedList<>();

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(arr[i][j] != 0) q.add(new Node(i,j));
			}
		}

		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int count = 0;
			q.poll();

			for(int i = 0; i < delta.length; i++) {
				int dx = delta[i][0] + x;
				int dy = delta[i][1] + y;

				if(dx < 0 || dx >= n || dy < 0 || dy >= m || copy[dx][dy] != 0) continue;

				count++;
			}

			arr[x][y] -= count;
			if(arr[x][y] < 0) arr[x][y] = 0;
		}
	}

	static void counting(int sx, int sy) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sx, sy));
		flag[sx][sy] = true;

		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();

			for(int i = 0; i < delta.length; i++) {
				int dx = delta[i][0] + x;
				int dy = delta[i][1] + y;

				if(dx < 0 || dx >= n || dy < 0 || dy >= m || flag[dx][dy] || arr[dx][dy] == 0) continue;

				flag[dx][dy] = true;
				q.add(new Node(dx, dy));
			}
		}
	}

	static void copy() {
		for(int i = 0; i < n; i++) {
			copy[i] = arr[i].clone();
		}
	}
}