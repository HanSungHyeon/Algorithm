import java.io.*;
import java.util.*;

public class Solution {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int max = Integer.MIN_VALUE,n,tmpNum,idx;
	static boolean[][] flag;
	static int[][] board;
	static int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			 n = Integer.parseInt(br.readLine());

			board = new int[n][n];
			idx = 0;
			max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			}
			
			for(int i = 0 ; i< n; i++) {
				for(int j = 0 ; j < n; j++) {
					flag = new boolean[n][n];
					tmpNum = 0;
					bfs(i,j);
					if(tmpNum > max) {
						max= tmpNum;
						idx = board[i][j];
					}
					else if(tmpNum == max) {
						idx = Math.min(board[i][j],idx);
					}
				}
			}
			System.out.println("#" + t + " " + idx + " " + max);
		}
	}

	public static void bfs(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x,y));
		flag[x][y] = true;
		while(!q.isEmpty()) {
			int tmpX = q.peek().x;
			int tmpY = q.peek().y;
			q.poll();
			tmpNum++;
			for(int i = 0 ;i < delta.length; i++) {
				int dx = tmpX + delta[i][0];
				int dy = tmpY + delta[i][1];
				
				if(dx >= 0 && dy >= 0 && dx < n && dy < n)			
				if(board[dx][dy] - board[tmpX][tmpY] == 1 && !flag[dx][dy]) {
//					flag[dx][dy] = true;
					q.add(new Node(dx,dy));
				}
			}
		}
	}
}