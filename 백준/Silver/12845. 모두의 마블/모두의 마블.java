//크다 합쳤을 때 베이스의 레벨은 계속 해서 유지 됨
//두 카드의 레벨 합만큼 골드를 얻을 수 잇음
//골드를 가장 많이 얻고 싶음
//카드 뭉치 중에 가장 큰 놈이 누군지 먼저 찾아야함 -> 레벨은 변하지 않기 때문
//제일 큰 친구 양 옆을 계속해서 제거해 나감

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int max = Integer.MIN_VALUE;
		int idx = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (max < arr[i]) {
				max = arr[i];
				idx = i;
			}
		}
		int sum = 0;
		for (int i = idx + 1; i < n; i++) {
			sum += (arr[idx] + arr[i]);
		}

		for (int i = idx - 1; i >= 0; i--) {
			sum += (arr[idx] + arr[i]);
		}
		System.out.println(sum);
	}
}