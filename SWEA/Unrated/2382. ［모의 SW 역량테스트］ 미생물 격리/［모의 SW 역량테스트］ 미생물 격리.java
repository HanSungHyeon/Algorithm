import java.io.*;
import java.util.*;

/*
 * 미생물 상하좌우로 움직임
 * 배열의 가장 자리 (row : 0, row : n - 1, col : 0, col : n -1)
 * -> 약품이 칠해져 있음
 * 약품에 닿으면  미생물 / 2
 * 미생물이 전부 움직이고 나서 같은 위치에 있는 미생물은 합쳐짐
 * -> 방향: 합쳐지기 전에 가장 많은 미생물을 가지고 있던 군집의 방향
 *
 * 큐 생성 -> 입력 받는 거 큐에 담음
 * 큐에서 빼서 이동 시킨거 담음 -> 미생물 기준 오름차순 우선순위 큐
 * 2차원 배열 만듬
 * 배열에 미생물 넣음 -> 해당 배열 좌표에 미생물이 없으면?? 미생물 방향을 정하고
 *             -> 만약 미생물이 있으면?? 이미 본인보다 사이즈가 큰 미생물이 있는 거임 -> 본인 방향 무시하고 배열 방향을 따라감
 * 배열에 들어있는 미생물 정보 다시 큐로 들어감
 * 해당 과정 m번 반복
 * 
 * (상,1) (하,2) (좌,3) (우,4)
 */
public class Solution {
	static class Info {
		int d, size;

		public Info(int d, int size) {
			this.d = d;
			this.size = size;
		}
	}

	static class Node {
		int x, y, d, size;

		public Node(int x, int y, int size, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.size = size;
		}
	}

	static int n, m, k;
	static int[][] delta = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	static Info[][] arr;
	static Queue<Node> q;
	static PriorityQueue<Node> pq;
	
	private static int count() {
		int sum = 0;
		for(int i =0 ; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(arr[i][j] != null)
					sum += arr[i][j].size;
			}
		}
		return sum;
	}

	// 이동이 완료된 미생물 -> 다음 이동을 위해 q에 넣어둠
	private static void put() {
		for(int i =0 ; i < n; i++) {
			for(int j = 0 ; j < n; j++) {
				if(arr[i][j] != null) {
					q.add(new Node(i,j,arr[i][j].size,arr[i][j].d));
				}
			}
		}
	}

	// 배열에 미생물 놓으면서 합치기 - 이동완료
	private static void merge() {
		arr = new Info[n][n];
		while (!pq.isEmpty()) {
			int x = pq.peek().x;
			int y = pq.peek().y;
			int d = pq.peek().d;
			int size = pq.peek().size;
			pq.poll();

			// arr 배열에는 미생물 갯수만 넣을거임
			// 값이 0이 아니면 이미 본인보다 큰 미생물이 있다는 것으로 기존에 박힌 방향을 따라감
			// 방향이 있어야함
			if (arr[x][y] == null) {
				arr[x][y] = new Info(d, size);
			} else
				arr[x][y].size += size;
		}
	}

	// 미생물 이동시킴 - 이동시키고 아직 배열에는 넣지 않았음
	private static void move() {
		pq = new PriorityQueue<>((o1, o2) -> o2.size - o1.size);

		while (!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			int d = q.peek().d;
			int size = q.peek().size;
			q.poll();
			
//			System.out.println("x : " + x + " y : " + y + " d : " + d + " size : " + size);
			int dx = x + delta[d][0];
			int dy = y + delta[d][1];
			// 약품에 닿았으면?
			if (!edge(dx, dy, d)) {
				if (d == 1)
					d = 2;
				else if (d == 2)
					d = 1;
				else if (d == 3)
					d = 4;
				else
					d = 3;
				size /= 2;
			}
//			System.out.println("dx : " + dx + " dy : " + dy + " d : " + d + " size : " + size);
			pq.add(new Node(dx, dy, size, d));
		}
	}

	// 미생물이 이동한 위치가 약품 위치인지
	private static boolean edge(int dx, int dy, int d) {
		if (dx == 0 || dy == 0 || dx == n - 1 || dy == n - 1)
			return false;
		return true;
	}
	
	private static void print() {
		for(int i =0; i < n; i++)
			System.out.println(Arrays.toString(arr[i]));
		System.out.println("---------------------");
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		for (int t = 1; t <= tc; t++) {
			q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());

			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				q.add(new Node(x, y, size, d));
			}
			while(m-- > 0) {
				move();
//				System.out.println("move 완");
				merge();
//				System.out.println("merger 완");
				put();
			}
			int ans = count();
			System.out.println("#" + t + " " + ans);
//			print();
		}
	}
}