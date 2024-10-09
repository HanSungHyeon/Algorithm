/*
* 개미 일렬 이동
* 선두 빼고는 다 앞에 누가 있음
* 서로 반대방향으로 오는 그룹이 만나면 서로 점프한다고함???????
* a 점프 b 이동 -> 고수네,,
* init = cba def
* 1s = cbd aef
* 2s = cdb eaf
* 개미의 길이는 입력으로 안주어짐
* */
import java.io.*;
import java.util.*;

class Main {
	static class Node {
		char ant;
		int d;
		boolean flag;
		public Node(char ant, int d, boolean flag) {
			this.ant = ant;
			this.d = d;
			this.flag  = flag;
		}
	}
	static List<Node> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());

		String s1 = br.readLine();
		for(int i = n1 - 1; i >= 0; i--) {
			list.add(new Node(s1.charAt(i),1, false));
		}
		String s2 = br.readLine();
		for(int i = 0; i < n2; i++) {
			list.add(new Node(s2.charAt(i), -1, false));
		}

		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			int idx = 0;

			for(int j = 0; j < n1 + n2; j++) {
				Node node = list.get(j);
				list.set(j, new Node(node.ant, node.d,false));
			}
			while(idx < n1 + n2) {
				Node node = list.get(idx);
				int d = node.d;
				//-> <-
				if(d == 1 && idx != n1 + n2 - 1 && list.get(idx + d).d == -1) {
					if(isCheck(idx, idx + d)) {
						swap(idx, idx + 1);
					}
				} else if(d == -1 && idx != 0 && list.get(idx + d).d == 1) {
					if(isCheck(idx, idx + d)) {
						swap(idx, idx - 1);
					}
				}
				idx++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(Node node : list) {
			sb.append(node.ant);
		}
		System.out.println(sb);
	}
	static boolean isCheck(int a, int b) {
		return !list.get(a).flag && !list.get(b).flag;
	}

	static void swap(int a, int b) {
		Node tmp = new Node(list.get(a).ant, list.get(a).d, true);
		list.set(a, new Node(list.get(b).ant, list.get(b).d, true));
		list.set(b, new Node(tmp.ant, tmp.d, true));

	}
}
