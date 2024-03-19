/*
육각형 벌집 모양을 하고 있음 -> 2차원 배열으로 가정 했을 때
//외벽을 만들거임

-> (3, 2) 기준으로 봤을 때 = 상 좌 하 우상, 우, 우하
-> (2, 2) 기준으로 봤을 때 = 상 좌 좌하, 하, 우, 좌상

추측 : row 홀수 기준으로 우상, 우하~
추측 : row 짝수 기준으로 좌상, 좌하~
배열 빈공간 한 줄 씩 만들고
빈공간에서 시작해서 외벽을 만나면 count진행
 */
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
	static int w,h, ans = 0;
	static int[][] arr, delta = {{0,1},{1,0},{-1,0},{0,-1}};
	//even 짝수 odd 홀수
	static int[][] even = {{1,0},{0,1},{-1,0},{0,-1},{1,-1},{-1,-1}}, odd = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,1}};
	static boolean[][] flag;
	static Queue<Node> q;

	static void bfs() {
		q = new LinkedList<>();
		q.add(new Node(0,0));
		flag[0][0] = true;

		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.poll();

			//row 짝수
			if(x % 2 == 0) {
				move(even,x,y);
			}
			
			//row 홀수
			else {
				move(odd,x,y);
			}
		}
	}

	static void move(int[][] delta, int x, int y) {
		for(int i = 0; i < delta.length; i++) {
			int dx = x + delta[i][0];
			int dy = y + delta[i][1];

			if(dx < 0 || dx >= h + 2 || dy < 0 || dy >= w + 2 || flag[dx][dy]) continue;
			
			//외벽 아닐 경우
			if(arr[dx][dy] == 0) {
				q.add(new Node(dx,dy));
				flag[dx][dy] = true;
			}
			
			//외벽일 경우
			else
				ans++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[h + 2][w + 2];
		flag = new boolean[h + 2][w + 2];

		for(int i = 1; i <= h; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j <= w; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		System.out.println(ans);
	}
}