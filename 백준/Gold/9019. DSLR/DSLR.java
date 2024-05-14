/*
* n = ((d1 * 10 + d2) * 10 + d3) * 10 + d4
* -------------
* d : n * 2
* n > 999 -> n %= 10000
* ----------
* s : n - 1 -> 레지스터에 저장
* n == 0 -> 9999 레지스터에 저장
* -------------
* L : n을 왼편으로 회전시키고 그 결과를 레지스터에 저장
* ex) 1 2 3 4 -> 2 3 4 1
* ---------------
* R : n을 오른쪽으로 회전시키고 그 결과를 레지스터에 저장
* ex) 1 2 3 4 -> 4 1 2 3
* ---------------------
* 4자리 수가 아닐 수 있음
* 1 -> 0001
* ---------
* a -> b로 변환하기 위한 최소 횟수 출력
* 이미 해당 번호를 탐색했다면 더 이상 탐색 할 필요 없음
* */

import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int num;
		String str;
		public Node(int num , String str) {
			this.num = num;
			this.str = str;
		}
	}
	static boolean[] flag;
	static Queue<Node> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		while(n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			flag = new boolean[10000];

			sb.append(bfs(a,b)).append("\n");
		}
		System.out.println(sb);
	}

	static String bfs(int a, int b) {
		q = new ArrayDeque<>();
		q.add(new Node(a, ""));
		flag[a] = true;
		String ans = "";

		while(!q.isEmpty()) {
			int num = q.peek().num;
			String str = q.peek().str;
			q.poll();

			if(num == b) {
				ans = str;
			}

			int d = cal(num, "D");
			insert(d, str, "D");

			int s = cal(num, "S");
			insert(s, str, "S");

			int l = cal(num, "L");
			insert(l, str, "L");

			int r = cal(num, "R");
			insert(r, str, "R");
		}
		return ans;
	}

	static void insert(int num, String str, String cmd) {
		if(!flag[num]) {
			flag[num] = true;
			q.add(new Node(num, str +cmd));
		}
	}

	static int cal(int num, String cmd) {
		switch(cmd) {
			case "D" : {
				return num * 2 > 9999 ? (num * 2) % 10000 : num * 2;
			}
			case "S" : {
				return num == 0 ? 9999 : num - 1;
			}
			case "L" : {
				return (num % 1000) * 10 + (num / 1000);
			}
			case "R" : {
				return (num % 10) * 1000 + (num / 10);
			}
		}
		return 0;
	}
}