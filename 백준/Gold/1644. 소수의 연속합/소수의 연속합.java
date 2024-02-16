/*
소수의 연속 된 합으로 N을 만들 수 있는가?
연속된 소수가 아니라면 만들 수 없는거임
ex) 20 = 7 + 13 -> 7과 13 사이에는 11이 존재함
같은 수는 단 한 번만 사용
3 + 5 + 5 + 7 = 오답 -> 5가 두번 사용됨
N <= 4,000,000 -> 소수 먼저 구해놓기
소수들을 모아놓은 배열 또는 리스트 생성
투포인터로 밀고 나가면서 연속된 합이 N보다 작으면 end + 1
연속된 합이 N과 같다면 ans + 1, start + 1
연속된 합이 N보다 크다면? start + 1
start 미는 이유 -> 다른 수들을 연속 시켜서 N을 만들 수 도 있음
 */

import java.io.*;
import java.util.*;

public class Main {
	static boolean[] prime;
	static List<Integer> list = new ArrayList<>();
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		makePrime();

		for (int i = 2; i <= 4000000; i++) {
			if (prime[i]) list.add(i);
		}

		int ans = twoPointer();
		System.out.println(ans);
	}

	static int twoPointer() {
		int start = 0;
		int end = 0;
		int sum = list.get(start);
		int count = 0;
		while (start < list.size() && start <= end) {
			if (sum < n) {
				end++;
				if (end >= list.size()) break;
				sum += list.get(end);
			} else if (sum == n) {
				sum -= list.get(start++);
				count++;
			} else {
				sum -= list.get(start++);

			}
		}
		return count;
	}

	static void makePrime() {
		prime = new boolean[4000000 + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;

		for (int i = 2; i <= Math.sqrt(4000000); i++) {
			if (prime[i]) {
				for (int j = i * i; j <= 4000000; j += i) {
					prime[j] = false;
				}
			}
		}
	}
}