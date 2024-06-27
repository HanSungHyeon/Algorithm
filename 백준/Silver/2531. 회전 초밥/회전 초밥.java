/*
* K개를 연속해서 먹을 경우 할인된 가격 제공
*
* */

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		int[] sushi = new int[d + 1];

		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		//현재 먹은 종류
		int cur = 0;
		for(int i = 0; i < k; i++) {
			if(sushi[arr[i]] == 0) cur++;

			sushi[arr[i]]++;
		}

		int max = cur;
		//(i + k - 1) % n
		for(int i = 0; i < n; i++) {
			if(max <= cur) {
				//쿠폰 아직 안 먹음
				if(sushi[c] == 0) max = cur + 1;

				else max = cur;
			}

			//시선 옮기기 먹기
			int idx = (i + k) % n;
			if(sushi[arr[idx]] == 0) {
				//새 거 안먹었으면?
				cur++;
			}
			sushi[arr[idx]]++;

			//현재 자리 안먹은거 취급
			sushi[arr[i]]--;
			if(sushi[arr[i]] == 0) {
				//지금 종류 안먹음
				cur--;
			}
		}
		System.out.println(max);
	}
}