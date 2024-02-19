//퀸을 N개 놓아야 함
import java.io.*;
import java.util.*;

public class Main {
	static int n, ans = 0;
	static int[][] arr, delta = {{1,0},{1,1},{1,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		dfs(0);
		System.out.println(ans);
	}

	static void dfs(int row) {
		if(row == n) {
			ans++;
			return;
		}

		for(int i = 0; i < n; i++) {
			//퀸 놓을 수 있음
			if(arr[row][i] == 0) {
				//공격로 표시
				addAttack(row, i);
				//다음 말 놓으러 감
				dfs(row + 1);
				//공격로 제거
				removeAttack(row,i);
			}
		}

	}
	static void removeAttack(int row, int col) {
		arr[row][col]--;
		for(int i = 0; i < delta.length; i++) {
			int dx = row + delta[i][0];
			int dy = col + delta[i][1];

			while(isCheck(dx, dy)) {
				arr[dx][dy]--;
				dx += delta[i][0];
				dy += delta[i][1];
			}
		}
	}

	static void addAttack(int row, int col) {
		arr[row][col]++;
		//공격 방향 고르고
		for(int i = 0; i < delta.length; i++) {
			int dx = row + delta[i][0];
			int dy = col + delta[i][1];

			//해당 방향으로 공격로 쭈욱 그음
			while(isCheck(dx,dy)) {
				arr[dx][dy]++;
				dx += delta[i][0];
				dy += delta[i][1];
			}
		}
	}
	static boolean isCheck(int dx, int dy) {
		return dx >= 0 && dx < n && dy >= 0 && dy < n;
	}


}
