import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int x;
		int y;
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int[][] arr;
	static boolean[][] flag;
	static Queue<Node> q = new LinkedList<>();
	static int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
	static int n;
	static List<Integer> complex = new ArrayList<>();
	
	public static int bfs(int x,int y) {
		q.add(new Node(x,y));
		flag[x][y] = true;
		int count = 0;
		
		while(!q.isEmpty()) {
			int x2 = q.peek().x;
			int y2 = q.peek().y;
			q.poll();
			count++;
			
			for(int i = 0; i < delta.length; i++) {
				int dx = x2 + delta[i][0];
				int dy = y2 + delta[i][1];
				
				if(dx < 0 || dy < 0 || dx >= n || dy >= n) continue;
				
				if(!flag[dx][dy] && arr[dx][dy] == 1) {
					flag[dx][dy] = true;
					q.add(new Node(dx,dy));
				}
			}
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		flag = new boolean[n][n];
		for(int i = 0; i < n; i ++) {
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
		}		
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(!flag[i][j] && arr[i][j] == 1)
					complex.add(bfs(i,j));
			}
		}
		Collections.sort(complex);
		sb.append(complex.size() + "\n");
		complex.stream().forEach(v -> sb.append(v + "\n"));
		
		System.out.println(sb);
	}
}