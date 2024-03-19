/*
3차원 방문 배열 사용
검이 있는지, 없는지
검이 있으면 걍 다 뚫고 지나가버림
도착지는 우측 하단
검이 있을 땐 좌, 상 으로 가야할 이유가 없음 걍 다 뚫고 가면댐
 */

import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int x, y, d;
		boolean gram;
		public Node(int x, int y, int d, boolean gram) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.gram = gram;
		}
	}
	static int n,m,t, ans = Integer.MAX_VALUE;
	static int[][] arr, delta = {{-1,0},{0,-1},{1,0},{0,1}};
	static boolean[][][] flag;

	static void bfs() {
		Queue<Node> q = new LinkedList<>();
		if(arr[0][0] == 2) q.add(new Node(0,0,0,true));
		else q.add(new Node(0,0,0,false));
		flag[0][0][1] = flag[0][0][0] = true;

		while(!q.isEmpty()) {
			Node node = q.poll();
			int x = node.x;
			int y = node.y;
			int d = node.d;

			if(x == n - 1 && y == m - 1) ans = Math.min(ans, d);

			for(int i = 0; i < delta.length; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];

				if(dx < 0 || dx >= n || dy < 0 || dy >= m) continue;

				boolean gram = node.gram;
				if(arr[dx][dy] == 2) gram = true;

				//칼 있으면 다 뿌셔
				if(gram && !flag[dx][dy][1]) {
//					System.out.println("dx : " + dx + " dy : " + dy + " d: " + d);
					q.add(new Node(dx,dy, d + 1, gram));
					flag[dx][dy][1] = true;
				}

				//칼 없으면 돌아가쟈
				else if(!gram && !flag[dx][dy][0]){
					if(arr[dx][dy] == 0 && !flag[dx][dy][0]) {
						q.add(new Node(dx,dy,d + 1, gram));
						flag[dx][dy][0] = true;
					}
				}
			}
		}

	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		flag = new boolean[n][m][2];

		for(int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		bfs();

		if(ans > t) System.out.println("Fail");
		else System.out.println(ans);
	}
}