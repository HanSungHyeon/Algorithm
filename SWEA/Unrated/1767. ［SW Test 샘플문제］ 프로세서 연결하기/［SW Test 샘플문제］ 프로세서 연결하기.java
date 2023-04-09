import java.io.*;
import java.util.*;

/*
 * 코어 최대한 연결했을 때 전선 길이의 합
 * 테두리에 있는 코어는 선 연결할 필요 없음
 * 코어는 연결을 해도 되고 안해도 상관없음 -> 조합??
 * 코어 하나에 선 연결해 보고 다음 코어로 넘어가서 선 연결해보기
 * 모든 코어 다 확인해봤을 떄 
 *  -> 더 많은 코어가 연결이 되었을 때 -> 연결된 코어 값 갱신, ans 갱신
 * 쭉 진행해보고 선 지우고 다른 방향에 선 연결
 * ------------------------------
 * 리스트에 선 연결확인해봐야 하는 코어들 있음
 * 리스트에서 하나씩 선 연결 
 */
public class Solution {
	static class Node {
		int x, y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n, ans, coreCnt;
	static int[][] arr;
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static List<Node> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			n = Integer.parseInt(br.readLine());
			arr = new int[n][n];
			list = new ArrayList<>();
			ans = Integer.MAX_VALUE;
			coreCnt = Integer.MIN_VALUE;

			for (int i = 0; i < n; i++)
				arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (arr[i][j] == 1) {
						if (i == 0 || j == 0 || i == n - 1 || j == n - 1)
							continue;
						else
							list.add(new Node(i, j));
					}
				}
			}
			dfs(0,0,0);
			sb.append("#" + t + " " + ans + "\n");
		}
		System.out.println(sb);
	}
	private static void print() {
		for(int i =0 ;i < n; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	private static void dfs(int idx, int core, int line) {
		if(idx == list.size()) {
			if(coreCnt < core) {
				coreCnt = core;
				ans = line;
			}
			else if(coreCnt == core) {
				ans = Math.min(ans, line);
			}
//			print();
//			System.out.println("coreCnt : " + coreCnt);
//			System.out.println("ans : " + ans + " core : " + core + " line : " + line);
//			System.out.println("-------------------");
			return;
		}
		
		int x = list.get(idx).x;
		int y = list.get(idx).y;
		
		//방향 하나 잡음
		for(int i = 0 ; i < 4; i++) {
			int dx = x;
			int dy = y;
			int count = 0;
			
			while(true) {
				dx += delta[i][0];
				dy += delta[i][1]; 
				
				//선이 다 연결됨
				if(dx < 0 || dy < 0 || dx >= n || dy >= n) break;
				
				//선이 연결 될 수 없음
				if(arr[dx][dy] != 0) {
					count = 0;
					break;
				}
				count++;
			}
			
			dx = x;
			dy = y;
			//선 연결
			for(int j =0 ; j < count; j++) {
				dx += delta[i][0];
				dy += delta[i][1];
				arr[dx][dy] = -1;
			}
			
			if(count != 0) {
				dfs(idx + 1, core + 1, line + count);
				
				dx = x;
				dy = y;
				for(int j = 0; j < count; j++) {
					dx += delta[i][0];
					dy += delta[i][1];
					arr[dx][dy] = 0;
				}
			}
			
			else dfs(idx + 1, core, line);
		}
	}
}