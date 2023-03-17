import java.io.*;
import java.util.*;

public class Main {
	static List<Integer>[] list;
	static int node,edge,ans;
	static boolean[] flag;
	
	private static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		flag[node] = true;
		
		while(!q.isEmpty()) {
			int com = q.peek();
			q.poll();
			
			for(int i : list[com]) {
				if(!flag[i]) {
					ans++;
					flag[i] = true;
					q.add(i);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		node = Integer.parseInt(br.readLine());
		edge = Integer.parseInt(br.readLine());
		//방문 배열
		flag = new boolean[node + 1];
		//인접리스트 사용
		list = new ArrayList[node + 1];
		for(int i = 1; i <= node; i++)
			list[i] = new ArrayList<>();
		
		for(int i = 0; i < edge; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			//from -> to 이동 가능 
			//to -> from 이동 가능 => 양방향
			list[from].add(to);
			list[to].add(from);
		}
		bfs(1);
		System.out.println(ans);
	}
}