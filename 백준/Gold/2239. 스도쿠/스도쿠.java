import java.io.*;
import java.util.*;

public class Main {
	static class Position {
		int x, y;

		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[][] arr;
	static List<Position> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		arr = new int[9][9];
		for (int i = 0; i < 9; i++)
			arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (arr[i][j] == 0)
					list.add(new Position(i, j));
			}
		}
		recur(0, 0);
	}

	// 가로
	private static boolean isRowCheck(int x, int num) {
		for (int i = 0; i < 9; i++) {
			if (arr[x][i] == num)
				return false;
		}
		return true;
	}

	// 세로
	private static boolean isColCheck(int y, int num) {
		for (int i = 0; i < 9; i++) {
			if (arr[i][y] == num)
				return false;
		}
		return true;
	}

	// 3x3 정사각형
	private static boolean isCheck(int x, int y, int num) {
		int r = sol(x);
		int c = sol(y);

		for (int i = r; i < r + 3; i++) {
			for (int j = c; j < c + 3; j++) {
				if (arr[i][j] == num)
					return false;
			}
		}
		return true;
	}

	// idx 가공
	private static int sol(int num) {
		if (num >= 0 && num <= 2)
			return 0;
		if (num >= 3 && num <= 5)
			return 3;
		else
			return 6;
	}

	private static void recur(int idx, int count) {
		if (count == list.size()) {
			
			for(int i =0 ;i < 9; i++) {
				Arrays.stream(arr[i]).forEach(x -> sb.append(x));
				sb.append("\n");
			}
				
			System.out.println(sb);
			System.exit(0);
			return;
		}

		Position p = list.get(idx);
		for (int i = 1; i < 10; i++) {
			if (isRowCheck(p.x, i) && isColCheck(p.y, i) && isCheck(p.x, p.y, i)) {
				arr[p.x][p.y] = i;
				recur(idx + 1, count + 1);
				arr[p.x][p.y] = 0;
			}
		}
	}
}