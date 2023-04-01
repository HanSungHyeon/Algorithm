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

	static int n, L, R;
	static int[][] arr, delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static boolean[][] flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		arr = new int[n][n];
		flag = new boolean[n][n];
		for (int i = 0; i < n; i++)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int day = 0;
		
		while (true) {
			int count = 0;
			//국경선 열고 인구 이동
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!flag[i][j]) {
						if(!isCheck(i,j)) count++;
						else bfs(i,j);
					}
				}
			}
//			System.out.println(count);
			if(count == n * n) break;
			//첫 번째 이동이 끝난 후 방문 배열 초기화
			for(int i =0; i < n; i ++) Arrays.fill(flag[i],false);
			day++;
		}
		System.out.println(day);
	}

	private static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		List<Node> list = new ArrayList<>();
		q.add(new Node(x, y));
		int sum = arr[x][y];
		flag[x][y] = true; 
		list.add(new Node(x,y));
		int count = 1;
		
		while (!q.isEmpty()) {
			int r = q.peek().x;
			int c = q.peek().y;
			q.poll();
//			System.out.println(r + " " + c);
			
			for(int i = 0; i < 4; i++) {
				int dr = r + delta[i][0];
				int dc = c + delta[i][1];
				
				if(dr < 0 || dc < 0 || dr >= n || dc >= n || flag[dr][dc]) continue;
				
				//인구수 차이
				int num = Math.abs(arr[dr][dc] - arr[r][c]);
				
				if(L <= num && num <= R) {
					count++;
					sum += arr[dr][dc];
					flag[dr][dc] =true;
					q.add(new Node(dr,dc));
					list.add(new Node(dr,dc));
				}
			}
		}
		
		move(sum, count,list);
	}
	
	//인구수 갱신
	private static void move(int sum, int count, List<Node> list) {
		int num = sum / count;
		
		for(Node n : list) {
			arr[n.x][n.y] = num;
		}
		
	}
	//현재 칸에서 국경선을 열 수 있는지 체크
	private static boolean isCheck(int x, int y) {
		int count = 0;
		for(int i =0 ; i < 4; i++) {
			int dx = x + delta[i][0];
			int dy = y + delta[i][1];
			
			if(dx < 0 || dy < 0 || dx >= n || dy >= n || flag[dx][dy]) continue; 
			
			int num = Math.abs(arr[x][y] - arr[dx][dy]);
			
			if(L <= num && num <= R) {
				count++;
			}
		}
		if(count == 0) return false;
		else return true;
	}
}