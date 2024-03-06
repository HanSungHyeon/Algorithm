/*
이미 최단거리를 다 구한 상태임
플로이드 한 번 더 돌려서
만약 갱신되는 경로가 있다면
최단 거리 잘 못 구한거임 -> -1 리턴
최단 거리를 제대로 잘 구했다면 -> 즉 플로이드 갱신이 이루어졌다면 -> 그거 걍 지워버림
주의 -> 경로를 거치지 않고 다이렉트로 연결된 간선은 지우면 안됨
ex) 1 -> 2 -> 3 이런거는 지우는게 맞고
1 -> 2 이런거는 지우면 안됨 -> i == j || i == k || j == j
 */
import java.io.*;
import java.util.*;

public class Main {
	static int n, INF = 2500 * 20 + 1;
	static int[][] arr, origin;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n + 1][n + 1];
		origin = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			for(int j = 1; j <= n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				origin[i][j] = arr[i][j];
			}
		}

		int ans = -1;
		if(floyd()) {
			ans = 0;
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(origin[i][j] == INF) continue;

					ans += origin[i][j];
				}
			}
			ans /= 2;
		}
		System.out.println(ans);
	}
	static boolean floyd() {
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(i == j || i == k || j == k) continue;

					if(arr[i][j] > arr[i][k] + arr[k][j]) return false;

					if(arr[i][j] == arr[i][k] + arr[k][j]) origin[i][j] = INF;
				}
			}
		}
		return true;
	}
}