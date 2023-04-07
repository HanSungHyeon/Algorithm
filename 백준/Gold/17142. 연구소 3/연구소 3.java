import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int x, y, count;

		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}

	static int n, m, ans = Integer.MAX_VALUE;
	static int[][] arr, delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static List<Node> list = new ArrayList<>();
	static boolean[] pick;
	static Queue<Node> q;
	static boolean[][] flag;

	// 조합
	private static void combination(int start, int num) {
		if (num == 0) {
//			System.out.println(Arrays.toString(pick));
			ready();
			ans = Math.min(ans, bfs());
//			System.out.println("답 찾는 중 : " + ans);
			
			return;
		}

		for (int i = start; i < list.size(); i++) {
			pick[i] = true;
			combination(i + 1, num - 1);
			pick[i] = false;
		}
	}

	// 조합으로 뽑은 바이러스 q에 넣기
	private static void ready() {
		q = new LinkedList<>();
		for (int i = 0; i < pick.length; i++) {
			if (pick[i])
				q.add(list.get(i));
		}
	}

	// 뽑은 애들로 바이러스 터뜨리면서 최소 시간 갱신
	private static int bfs() {
		flag = new boolean[n][n];
		int tmp = 0;
		boolean flag2 = true;
		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int count = q.peek().count;
			q.poll();
//			System.out.println("x : " + x + " y : " + y + " count : " + count);
			flag[x][y] = true;
			

			tmp = Math.max(tmp, count);
			if(count >= ans) {
				flag2 = false;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];

				if (dx < 0 || dy < 0 || dx >= n || dy >= n || flag[dx][dy])
					continue;

				if (arr[dx][dy] == 0) {
					flag[dx][dy] = true;
					q.add(new Node(dx, dy, count + 1));
				}
				if(arr[dx][dy] == 2) {
					if(bfs2(dx,dy)) q.add(new Node(dx,dy, count + 1));
				}
			}
		}
		if(!isCheck()) return Integer.MAX_VALUE;
		if(flag2) return tmp;
		return Integer.MAX_VALUE;
	}
	
	//비활성 바이러스를 만났을 때 -> 비활성 바이러스 주변에 탐색 가능한 지역이 있다면??
	//비활성 바이러스 주변에 비활성이 있고  그 너머에 빈 지역이 있다면?
	private static boolean bfs2(int x, int y) {
		boolean[][] flag2 = new boolean[n][n];
		for(int i = 0 ; i <n; i++)
			flag2[i] = flag[i].clone();
		
		Queue<Node> q2 = new LinkedList<>();
		q2.add(new Node(x,y,0));
		flag2[x][y] = true;
		
		while(!q2.isEmpty()) {
			int r = q2.peek().x;
			int c = q2.peek().y;
//			System.out.println("r : " +r + " c : " + c);
			q2.poll();
			
			for(int i =0 ; i < 4; i++) {
				int dr = r + delta[i][0];
				int dc = c + delta[i][1];
				
				if(dr <  0 || dc < 0 || dr >= n || dc >= n || flag2[dr][dc]) continue;
				
				if(arr[dr][dc] == 2) {
					flag2[dr][dc] = true;
					q2.add(new Node(dr,dc,0));
				}
				
				if(arr[dr][dc] == 0) return true;
			}
		}
		return false;
	}
	
	//바이러스를 다 퍼뜨린건지 확인
	private static boolean isCheck() {
		for(int i =0 ; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				if(!flag[i][j] && arr[i][j] == 0) return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 2)
					list.add(new Node(i, j, 0));
			}
		}
		// 조합 담을 배열
		pick = new boolean[list.size()];
//		System.out.println("pick 사이즈 : " + pick.length);
		combination(0, m);
		
		if(ans == Integer.MAX_VALUE) ans = -1;
		System.out.println(ans);
	}
}