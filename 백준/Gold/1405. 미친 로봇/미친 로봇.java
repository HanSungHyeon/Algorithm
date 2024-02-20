/*
로봇은 N번 움직이고
동서남북은 확률이 있음
단순할 확률을 찾아야함
일단 움직이고
확률을 어떻게 계산할건지 생각해야함
2번을 움직일 때
동 동이 나올 확률 -> 25% * 25% -> (0.25 * 0.25) * 100 = 6.25
동 서 나올 확률 = 6.25
옳은 방향일 때의 확률을 전부 더한다
소수로 나타내기 때문에 * 100하지 않음
로봇의 map의 크기는?
1 <= N <= 14 -> 최대 14번까지 움직일 수 있음
-> (동, 서) (서, 동)으로 움직 일 수 있음
맵의 중앙에서 시작하는게 제일 베스트
14에서 시작 끊을 때 -> 서쪽으로 14번 움직이면 0, 동쪽으로 14번 움직이면 28
map 크기 14 + 14 + 1(처음에 서 있는 위치)
 */

import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static double ans = 0;
	static int[][] delta = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}, arr;
	static double[] percent = new double[4];
	static boolean[][] flag;


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 4; i++) {
			percent[i] = Integer.parseInt(st.nextToken()) * 0.01;
		}
		arr = new int[29][29];
		flag = new boolean[29][29];
		flag[14][14] = true;
		dfs(14, 14, 1, 0);
		System.out.println(ans);
	}

	static void dfs(int x, int y, double num, int count) {
		if (count == n) {
			ans += num;
			return;
		}

		for (int i = 0; i < delta.length; i++) {
			int dx = x + delta[i][0];
			int dy = y + delta[i][1];

			if (percent[i] == 0) continue;

			if (dx < 0 || dx >= arr.length || dy < 0 || dy >= arr.length || flag[dx][dy]) continue;

			flag[dx][dy] = true;
			dfs(dx, dy, num * percent[i], count + 1);
			flag[dx][dy] = false;
		}
	}
}