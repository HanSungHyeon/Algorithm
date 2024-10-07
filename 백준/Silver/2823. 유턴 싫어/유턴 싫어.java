/*
* 막다른 길 = 갈 수 있는 길이 단 하나
* */

import java.io.*;
import java.util.*;

class Main {
	static int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		String[][] arr = new String[r][c];

		for(int i = 0; i < r; i++) {
			arr[i] = br.readLine().split("");
		}
		boolean flag = true;
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(arr[i][j].equals(".") && flag) {
					int count = 0;
					for(int k = 0; k < delta.length; k++) {
						int dx = i + delta[k][0];
						int dy = j + delta[k][1];

						if(dx < 0 || dx >= r || dy < 0 || dy >= c) continue;

						if(arr[dx][dy].equals(".")) count++;
					}
					if(count < 2) {
						flag = false;
					}
				}
			}
		}

		int ans = flag ? 0 : 1;

		System.out.println(ans);
	}
}
