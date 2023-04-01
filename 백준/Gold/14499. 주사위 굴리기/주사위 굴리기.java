import java.io.*;
import java.util.*;

/*
 * 주사위가 구를 때 규칙 찾기
 * (동,1) (서,2) (북,3) (남,4)
 *  */
public class Main {
	// 주사위 클래스
	static class Dice {
		int floor, ceiling, bottom, top, left, right;

		public Dice(int floor, int ceiling, int bottom, int top, int left, int right) {
			this.floor = floor;
			this.ceiling = ceiling;
			this.bottom = bottom;
			this.top = top;
			this.left = left;
			this.right = right;
		}
	}

	static int n, m, x, y, k;
	static int[][] arr, delta = { { 0, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 0 } };
	static Dice dice = new Dice(0, 0, 0, 0, 0, 0);

	// 지도 값, 주사위 값 갱신
	private static void replace() {
		if (arr[x][y] == 0)
			arr[x][y] = dice.floor;
		else {
			dice.floor = arr[x][y];
			arr[x][y] = 0;
		}
	}

	// 주사위 굴리기
	private static void move(int num) {
		int tmp = dice.floor;
		// 동쪽
		if (num == 1) {
			dice.floor = dice.right;
			dice.right = dice.ceiling;
			dice.ceiling = dice.left;
			dice.left = tmp;
		}
		// 서쪽
		else if (num == 2) {
			dice.floor = dice.left;
			dice.left = dice.ceiling;
			dice.ceiling = dice.right;
			dice.right = tmp;
		}
		// 북쪽
		else if (num == 3) {
			dice.floor = dice.top;
			dice.top = dice.ceiling;
			dice.ceiling = dice.bottom;
			dice.bottom = tmp;
		}
		// 남쪽
		else if (num == 4) {
			dice.floor = dice.bottom;
			dice.bottom = dice.ceiling;
			dice.ceiling = dice.top;
			dice.top = tmp;
		}

	}

	// 주사위 굴리기가 가능한지 판단
	// 이동 가능하면 좌표 이동
	private static boolean isCheck(int num) {
		int dx = x + delta[num][0];
		int dy = y + delta[num][1];
		
		if(dx < 0 || dy < 0 || dx >= n || dy >= m) return false;
		
		x = dx;
		y = dy;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		arr = new int[n][m];
		for (int i = 0; i < n; i++)
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		st = new StringTokenizer(br.readLine());
		int size = st.countTokens();
		for (int i = 0; i < size; i++) {
			int num = Integer.parseInt(st.nextToken());

			if (isCheck(num)) {
				move(num);
				replace();
				System.out.println(dice.ceiling);
			}
		}
	}
}