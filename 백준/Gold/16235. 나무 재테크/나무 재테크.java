import java.io.*;
import java.util.*;

/*
 * 봄 - 나무가 자신의 나이만큼 양분 먹고 나이 1증가
 *     -> 같은 칸에 여러 개 있으면 나이가 어린 나무부터 양분 먹음
 *     -> 양분이 부족해서 나이만큼 못 먹으면 그 자리에서 죽음
 * 여름 - 죽은 나무가 양분으로 변하게 됨
 *    -> 죽은 나무의 나이를 2로 나눈 값이 해당 칸의 양분
 * 가을 - 나무 번식
 *    -> 나무 나이가 5배수여야 번식 가능
 *    -> 인접한 8개 칸에 나이가 1인 나무 생성
 *    -> 범위 벗어나면 안 생김
 * 겨울 - 양분 추가
 *    -> 입력으로 들어온 값
 *    
 * 큐, 우선순위 큐 사용
 */
public class Main {
	static class Tree {
		int x, y, age;

		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}
	}

	static int[][] arr, energy;
	static int[][] delta = { { -1, 0 }, { -1, 1 }, { -1, -1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { 0, 1 } };
	static int n, m, k;
	static Queue<Tree> death = new LinkedList<>();
	static Queue<Tree> q = new LinkedList<>();
	static PriorityQueue<Tree> pq = new PriorityQueue<>((t1, t2) -> t1.age - t2.age);

	private static void put() {
		while (!q.isEmpty()) {
			pq.add(q.poll());
		}
	}

	private static void spring() {
		while (!pq.isEmpty()) {
			int x = pq.peek().x;
			int y = pq.peek().y;
			int age = pq.peek().age;
			pq.poll();
			// 나무가 양분을 먹을 수 있으면
			if (arr[x][y] >= age) {
				arr[x][y] -= age;
				q.add(new Tree(x, y, age + 1));
			} else
				death.add(new Tree(x, y, age));
		}
	}

	private static void summer() {
		while (!death.isEmpty()) {
			int x = death.peek().x;
			int y = death.peek().y;
			int age = death.peek().age;
			death.poll();
			arr[x][y] += age / 2;
		}
	}

	private static void fall() {
		int size = q.size();
//		System.out.println(size);
		for (int s = 0; s < size; s++) {
			int x = q.peek().x;
			int y = q.peek().y;
			int age = q.peek().age;
			q.poll();
			q.add(new Tree(x, y, age));

			if (age % 5 != 0)
				continue;
			
			for (int i = 0; i < 8; i++) {
				int dx = x + delta[i][0];
				int dy = y + delta[i][1];

				if (dx <= 0 || dy <= 0 || dx > n || dy > n)
					continue;
				
				q.add(new Tree(dx, dy, 1));
			}
		}
	}

	private static void winter() {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] += energy[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		arr = new int[n + 1][n + 1];
		energy = new int[n + 1][n + 1];
		// 초기 양분
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				arr[i][j] = 5;
			}
		}
		// 겨울에 넣을 양분 입력
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				energy[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 나무 정보
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			pq.add(new Tree(x, y, k));
		}
		while (k-- > 0) {
			spring();
			summer();
			fall();
			winter();
			put();
		}
		System.out.println(pq.size());
	}
}