import java.io.*;
import java.util.*;

/*
 * 벽은 총 1번만 부술 수 있음
 * 끝까지 가는 최소시간을 구하는 문제 -> bfs
 * 벽은 부술 수 있고 부수지 않을 수 도 있음
 * 벽을 언제 부술 것인지가 문제
 * 부순 벽을 저장할 공간 -> 3차원 배열
 * 
 */
public class Main {
	static class Node {
		int x, y, l, count;

		public Node(int x, int y, int l, int count) {
			this.x = x;
			this.y = y;
			this.l = l;
			this.count = count;
		}
	}

	static int n, m,ans = Integer.MAX_VALUE;
	static int[][] arr, delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	// 벽을 부쉈는지 확인할 flag 배열
	// 0 -> 안부숨, 1 -> 부숨
	static boolean[][][] flag;

	private static void bfs() {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0, 0, 0, 1));
		flag[0][0][0] = true;
		flag[0][0][1] = true;
		
		
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int l = q.peek().l;
			int count = q.peek().count;
			q.poll();
//			System.out.println("x : " + x + " y : " + y + " l : " + l + " count : " + count);
			if(x == n - 1 && y == m - 1) {
				ans = count;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];
				
				if(dx < 0 || dy < 0 || dx >= n || dy >= m) continue;
				
				//벽을 부순 적이 있을 때
				if(l == 0) {
					//앞에 벽이 있어서 부수고 가는 경우 && 해당 벽을 부순 적이 없는 경우
					if(arr[dx][dy] == 1 && !flag[dx][dy][1]) {
						flag[dx][dy][1] = true;
						q.add(new Node(dx,dy,1,count + 1));
					}
					//앞에 빈땅이어서 그냥 가는 경우 && 방문한적이 없는 경우
					if(arr[dx][dy] == 0 && !flag[dx][dy][0]) {
						flag[dx][dy][0] = true;
						q.add(new Node(dx,dy,l,count + 1));
					}
					else continue;
				}
				
				//벽을 부순 적이 없을 때
				if(l == 1) {
					//빈땅이고 방문한적이 없을 경우
					if(arr[dx][dy] == 0 && !flag[dx][dy][l]) {
						flag[dx][dy][l] = true;
						q.add(new Node(dx,dy,l,count + 1));
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		flag = new boolean[n][m][2];
		arr = new int[n][m];
		for (int i = 0; i < n; i++)
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

		bfs();
		
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}

}