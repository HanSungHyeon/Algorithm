import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int x;
		int y;
		public Node(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	static Queue<Node> q = new LinkedList<>();
	static int[][] arr;
	static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean[][] flag;
	static int m,n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			 m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int cabbage = Integer.parseInt(st.nextToken());
			int result = 0;
			arr = new int[n][m];
			flag = new boolean[n][m];
			for(int i = 0 ;i < cabbage; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				
				arr[x][y] = 1;
			}
			for(int i = 0; i< n; i++) {
				for(int j = 0; j <m; j++) {
					if(!flag[i][j] && arr[i][j] == 1) {
						bfs(i,j);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}
	public static void bfs(int x, int y) {
		q.add(new Node(x, y));
		flag[x][y] = true;
		
		while(!q.isEmpty()) {
			int x1 = q.peek().x;
			int y1 = q.peek().y;
			q.poll();
			
			for(int i = 0 ;i < delta.length; i++) {
				int dx = x1 + delta[i][0];
				int dy = y1 + delta[i][1];
				
				if(dx < 0 || dy < 0 || dx >= n || dy >= m) continue;
				
				if(!flag[dx][dy] && arr[dx][dy] == 1) {
					flag[dx][dy] = true;
					q.add(new Node(dx,dy));
				}
			}
		}
	}
}