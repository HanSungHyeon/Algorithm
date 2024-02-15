/*
업그레이드가 된 카드의 레벨은 변하지 않음 -> 베이스의 레벨 유지
서로 인접한 카드만 합성 가능
합성 할 때 두 카드의 레벨 합 만큼 골드 획득 ex) A B 합성 -> A + B 골드 획득
가장 큰 수를 베이스로 두고 주변 친구들을 합성 재료로 사용
 */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int idx = 0;
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if (max <= arr[i]) {
				max = arr[i];
				idx = i;
			}
		}

		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (i == idx) continue;
			ans += (arr[idx] + arr[i]);
		}
		System.out.println(ans);
	}
}
