//팀 조건 -> 여2 남1
//N명 M명 -> 이 중 K명은 인턴십에 참여해야함
//K명은 대회 참가 못 함
//가장 많은 팀을 만들어야함

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int count = 0;
		while (true) {
			if (n < 2 || m < 1 || n + m < k + 3) break;
			n -= 2;
			m -= 1;
			count++;
		}
		System.out.println(count);
	}
}