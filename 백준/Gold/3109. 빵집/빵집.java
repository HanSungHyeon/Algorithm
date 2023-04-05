import java.io.*;
import java.util.*;

public class Main {
	static int r, c;
	static String[][] arr;
	static int[][] delta = { { -1, 1 }, { 0, 1 }, { 1, 1 } };
	static boolean flag;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = new String[r][c];
		for (int i = 0; i < r; i++)
			arr[i] = br.readLine().split("");
		
		for(int i = 0; i < r; i++) {
			if(arr[i][0].equals(".")){
             flag = false; //초기화
             setPipe(i,0);   
            }
		}
		System.out.println(count());
//		print();
		
	}
	private static int count() {
		int count = 0;
		for(int i = 0; i < r; i++) {
			if(arr[i][c - 1].equals("o")) count++;
		}
		return count;
	}

	private static void print() {
		for(int i = 0;i < r; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
	}

	private static void setPipe(int x, int y) {
		arr[x][y] = "o";

		if (y == c - 1) {
			flag = true;
			return;
		}

		for (int i = 0; i < 3; i++) {
			int dx = x + delta[i][0];
			int dy = y + delta[i][1];

			if (dx < 0 || dy < 0 || dx >= r || dy >= c || !arr[dx][dy].equals("."))
				continue;

			setPipe(dx, dy);
			// 여기서 끝내야함
			if (flag)
				return;
		}
	}
}