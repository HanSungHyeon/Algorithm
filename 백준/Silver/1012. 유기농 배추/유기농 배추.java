import java.io.*;
import java.util.*;

public class Main {
	static boolean[][] flag;
	static int[][] board;
	static int n,m;
	static int[][] delta = {{1,0},{-1,0},{0,-1},{0,1}};
	
	public static void dfs(int x, int y) {
		flag[x][y] = true;
		
		for(int i = 0; i < delta.length; i++) {
			int dx = x + delta[i][0];
			int dy = y + delta[i][1];
			
			if(dx < 0 || dy < 0 || dx >= n || dy >= m) continue;
			
			if(!flag[dx][dy] && board[dx][dy] == 1) {
				dfs(dx,dy);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		while (tc-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			int result = 0;

			board = new int[n][m];
			flag = new boolean[n][m];

			for (int i = 0; i < count; i++) {
				st = new StringTokenizer(br.readLine());

				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());

				board[x][y] = 1;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (!flag[i][j] && board[i][j] == 1) {
						dfs(i, j);
						result++;
					}
						
				}
			}
			System.out.println(result);
		}
	}
}