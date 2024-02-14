import java.io.*;
import java.util.*;

/*
 * 1. 낚시왕이 오른쪽으로 한 칸 이동
 * 2. 낚시왕이 있는 열에서 가장 가까운 상어 잡음
 *    -> 상어를 잡으면 해당 상어 제거
 * 3. 상어 이동
 *    -> 상어는 속도만큼 해당 칸 이동
 *    -> 경계를 넘는 경우 반대로 돌아서 이동
 * 4. 두 마리 이상 있을 경우 가장 큰 상어가 나머지 다 먹음
 * --------
 * 상어 정보 2차원 배열에 표시
 * 낚시왕이 이동한 열에서 가장 가까운 상어가 있으면 제외하고 모든 상어들 큐에 넣음
 * 큐에서 상어를 꺼내서 이동 시킨 뒤 우선순위 큐에 넣음 -> 크기별 내림차순
 * 우선순위 큐에서 꺼내서 2차원 배열에 상어 배치
 *  -> 배치할 칸에 이미 상어가 있는 경우 꺼낸 상어 버림
 *  낚시왕 이동
 *  반복
 */
public class Main {
	static class Shark {
		// 위치, 속력, 이동방향, 크기
		int r, c, s, d, z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}

	static int x, y, m, king = 0, ans = 0;
	static Shark[][] arr;
	static int[][] delta = { { 0, 0 }, { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
	static Queue<Shark> q = new LinkedList<>();
	static PriorityQueue<Shark> pq = new PriorityQueue<>((s1, s2) -> s2.z - s1.z);
	
	private static void print() {
		for(int i =0 ; i < x; i++) {
			for(int j = 0; j < y; j++) {
				if(arr[i][j] != null)
					System.out.print(arr[i][j].z + " ");
				else
					System.out.print("빈칸 ");
			}
			System.out.println();
		}
	}
	
	// 낚시왕 이동 후 가장 가까운 상어 제거
	private static void move(int king) {
		for (int i = 0; i < x; i++) {
			if (arr[i][king] != null ) {
				ans += arr[i][king].z;
//				System.out.println("잡은 상어 크기" + arr[i][king].z);
				arr[i][king] = null;
				break;
			}
		}
	}

	//낚시왕이 잡은 상어 제외하고 큐에 담음
	private static void put() {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if(arr[i][j] != null) {
					q.add(new Shark(i,j,arr[i][j].s,arr[i][j].d,arr[i][j].z));
				}
			}
		}
	}
	
	//상어 이동 후 우선순위 큐에 삽입
	//그냥 반복문으로 이동
	private static void sharkMove() {
		for(int i =0; i < x; i++) {
			for(int j = 0; j < y; j++) {
				if(arr[i][j] != null) {
					int r = arr[i][j].r;
					int c = arr[i][j].c;
					int s = arr[i][j].s;
					int d = arr[i][j].d;
					int z = arr[i][j].z;
//					q.poll();
					
					int dr = r, dc = c;
					for(int k = 0; k < s; k++) {
						//상어 이동 바꾸기
						if(d == 1 && dr ==0) d = 2;
						else if(d == 2 && dr == x - 1) d = 1;
						else if(d == 3 && dc == y - 1) d = 4;
						else if(d == 4 && dc == 0) d =3;
						
						dr = dr + delta[d][0];
						dc = dc + delta[d][1];
					}
//					System.out.println("dr : " + dr + " dc : " + dc + " z : " + z);
					pq.add(new Shark(dr,dc,s,d,z));
				}
			}
		}
		
//		while(!q.isEmpty()) {
//			int r = q.peek().r;
//			int c = q.peek().c;
//			int s = q.peek().s;
//			int d = q.peek().d;
//			int z = q.peek().z;
//			q.poll();
//			
//			int dr = r, dc = c;
//			for(int i = 0; i < s; i++) {
//				//상어 이동 바꾸기
//				if(d == 1 && dr ==0) d = 2;
//				else if(d == 2 && dr == x - 1) d = 1;
//				else if(d == 3 && dc == y - 1) d = 4;
//				else if(d == 4 && dc == 0) d =3;
//				
//				dr = dr + delta[d][0];
//				dc = dc + delta[d][1];
//				
//				
//			}
//			System.out.println("dr : " + dr + " dc : " + dc + " z : " + z);
//			pq.add(new Shark(dr,dc,s,d,z));
//		}
	}
	
	//상어 싸움
	private static void eat() {
		arr = new Shark[x][y];
		while(!pq.isEmpty()) {
			int r = pq.peek().r;
			int c = pq.peek().c;
			int s = pq.peek().s;
			int d = pq.peek().d;
			int z = pq.peek().z;
			pq.poll();
			
			if(arr[r][c] == null) arr[r][c] = new Shark(r,c,s,d,z);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new Shark[x][y];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());

			arr[r][c] = new Shark(r, c, s, d, z);
		}
		
		for(int i = 0; i < y; i++) {
			move(i);
//			put();
			sharkMove();
//			print();
			eat();
//			System.out.println("----------------------");
			
		}
		System.out.println(ans);
	}
}