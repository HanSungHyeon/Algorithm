import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int x, y, dir;
		public Node(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
	}
	static int tc,I,startx,starty,endx,endy,ans;
	static boolean[][] map;
	static int[][] delta = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
	private static void bfs(int startx, int starty) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(startx,starty,0));
		map[startx][starty] = true;
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int dir = q.peek().dir;
			q.poll();
			
			if(x == endx && y == endy) {
				ans = dir;
				break;
			}
			
			for(int i = 0; i < delta.length; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];
				
				if(dx < 0 || dy < 0 || dx >= I || dy >= I) continue;
				
				if(!map[dx][dy]) {
					map[dx][dy] = true;
					q.add(new Node(dx,dy,dir + 1));
				}
					
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		tc = Integer.parseInt(br.readLine());
		
		
		while(tc-- > 0) {
			I = Integer.parseInt(br.readLine());
			map = new boolean[I][I];
			StringTokenizer st = new StringTokenizer(br.readLine());
			startx = Integer.parseInt(st.nextToken());
			starty = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			endx = Integer.parseInt(st.nextToken());
			endy = Integer.parseInt(st.nextToken());
			
			bfs(startx, starty);
			sb.append(ans + "\n");
		}
		System.out.println(sb);
	}
}