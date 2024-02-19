import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int x,y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static String[][] arr;
	static List<Node> list = new ArrayList<>();
	static int[] pick = new int[7];
	static int[][] delta = {{1,0},{0,1},{-1,0},{0,-1}};
	static boolean[][] flag;
	static int ans = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new String[5][5];
		for(int i = 0; i < 5; i++) arr[i] = br.readLine().split("");

		init();
		combination(0,0);
		System.out.println(ans);
	}
	static void combination(int start, int count) {
		//7자리 뽑았음
		if(count == 7) {
			//7자리가 연결 되었는 지 확인
			if(bfs() && count()) {
				ans++;
			}
			return;
		}

		for(int i = start; i < 25; i++) {
			pick[count] = i;
			combination(i + 1, count + 1);
		}
	}
	static boolean count() {
		int count = 0;
		for(int i : pick) {
			Node node = list.get(i);
			if(arr[node.x][node.y].equals("S")) count++;
		}
		if(count >= 4) return true;
		return false;
	}
	static boolean bfs() {
		Queue<Node> q = new LinkedList<>();
		Node n = list.get(pick[0]);
		flag = new boolean[5][5];
		flag[n.x][n.y] = true;
		q.add(new Node(n.x, n.y));
		int count = 1;

		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();


			if(count == 7) return true;
			for(int i = 0; i < delta.length; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];

				if(dx < 0 || dx >= 5 || dy < 0 || dy >= 5 || flag[dx][dy]) continue;

				//방문처리 필요함
				for(int p : pick) {
					Node node = list.get(p);
					if(node.x == x && node.y == y) continue;
					if(node.x == dx && node.y == dy) {
						count++;
						flag[dx][dy] = true;
						q.add(new Node(dx,dy));
					}
				}
			}
		}
		return false;
	}
	//좌표 미리 정의
	static void init() {
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				list.add(new Node(i,j));
			}
		}
	}
}
