/*
* 연쇄 사이클
* 1. 연결된 친구들 있나 체크
* 2. 4개 이상 연결된 친구들 터짐
* 3. 공백 채우려고 내려옴
* 반복
* if(1번이 해당 하는 친구들이 없음) -> 사이클 종료
* 
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
	static String[][] arr;
	static boolean[][] remove, flag;
	static int[][] delta = {{1,0}, {0,1},{-1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new String[12][6];
		remove = new boolean[12][6];

		for(int i = 0; i < 12; i++) {
			arr[i] = br.readLine().split("");
		}

		int ans = 0;
		while(true) {
			boolean boom = false;
			for(int i = 0; i < arr.length; i++) {
				for(int j = 0; j < arr[0].length; j++) {
					if(!arr[i][j].equals(".")) {
						int count = bfs(i,j);
						if(count >= 4) {
							remove();
							boom = true;
						}
					}
				}
			}
			if(!boom) break;
			down();
			ans++;
		}
        System.out.println(ans);
	}

	static int bfs(int sx, int sy) {
		flag = new boolean[12][6];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(sx, sy));
		flag[sx][sy] = true;
		String word = arr[sx][sy];
		int count = 1;

		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();

			for(int i = 0; i < delta.length; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];

				if(dx < 0 || dx >= 12 || dy < 0 || dy >= 6 || flag[dx][dy] || !arr[dx][dy].equals(word)) continue;

				count++;
				flag[dx][dy] = true;
				q.add(new Node(dx,dy));
			}
		}
		return count;
	}

	static void remove() {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				if(flag[i][j]) {
					arr[i][j] = ".";
					flag[i][j] = false;
				}
			}
		}
	}

	static void down() {
		for(int j = 0; j < arr[0].length; j++) {
			for(int i = arr.length - 1; i > 0; i--) {
				if(arr[i][j].equals(".")) {
					for(int k = i - 1; k >= 0; k--) {
						if(!arr[k][j].equals(".")) {
							arr[i][j] = arr[k][j];
							arr[k][j] = ".";
							break;
						}
					}
				}
			}
		}
	}
	
}