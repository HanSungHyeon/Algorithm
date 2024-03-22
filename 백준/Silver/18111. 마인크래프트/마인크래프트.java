/*
블록 최소 높이, 블록 최대 높이 구함
최소 ~ 최대로 높이 하나씩 확인해 보면 됨
기존 높이 -> 확인할 높이로 만듬
기존 높이 > 확인 높이 = 제거해야하는 거임
-> (기존 높이 - 현재 높이) * 2 = 시간

기존 높이 < 확인 높이 = 쌓아야 하는 거임
-> (확인 높이 - 기존 높이) = 시간
단, 인벤토리에 땅이 있어야 함

인벤토리는 어떻게 관리?
tmp로 관리
*/

import java.io.*;
import java.util.*;

public class Main {
	static int n,m,b, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		arr = new int[n][m];

		//땅 입력 받고 min, max 구하기
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(arr[i][j], max);
				min = Math.min(arr[i][j], min);
			}
		}

		int ansTime = Integer.MAX_VALUE;
		int ansHigh = 0;
		for(int h = min; h <= max; h++) {
			int tmp = b;
			int time = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					//돌 제거해야 함
					if(arr[i][j] >= h) {
						time += (arr[i][j] - h) * 2;
						tmp += (arr[i][j] - h);
					}
					//돌 추가
					else {
						time += (h - arr[i][j]);
						tmp -= (h - arr[i][j]);
					}
				}
			}
			//가능한 높이라면?
			if(tmp >= 0 && ansTime >= time) {
				ansTime = time;
				ansHigh = h;
			}
			//tmp가 음수야 -> 즉 불가능한거임
			//그럼 더 높은 높이에서도 가능하냐? ㄴㄴ 불가능함
			else break;
		}
		System.out.println(ansTime + " " + ansHigh);
	}
}