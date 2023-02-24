import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
	static List<Integer>[] list = new ArrayList[5];
	static int gear, dir;
	static boolean[] flag;
	static int[] delta = { 1, -1 }, sol1 = { 0, 1, -1, 1, -1 }, sol2 = { 0, -1, 1, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 1; i < 5; i++)
			list[i] = new ArrayList<>();

		for (int i = 1; i < 5; i++) {
			String[] temp = br.readLine().split("");
			for (int j = 0; j < temp.length; j++)
				list[i].add(Integer.parseInt(temp[j]));
		}
		int k = Integer.parseInt(br.readLine());
		for (int i = 0; i < k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			gear = Integer.parseInt(st.nextToken());
			dir = Integer.parseInt(st.nextToken());
			check(gear);
			turn(gear, dir);
		}
		System.out.println(score());
	}

	public static void check(int gear) {
		Queue<Integer> q = new LinkedList<>();
		flag = new boolean[5];
		q.add(gear);
		flag[gear] = true;

		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 0; i < delta.length; i++) {
				int d = tmp + delta[i];

				if (d < 1 || d > 4)
					continue;

				if (d < tmp && list[d].get(2) != list[tmp].get(6) && !flag[d]) {
					flag[d] = true;
					q.add(d);
				} else if (d > tmp && list[d].get(6) != list[tmp].get(2) && !flag[d]) {
					flag[d] = true;
					q.add(d);
				}
			}
		}
	}

	public static void turn(int gear, int dir) {
		int[] tmp = new int[4];
		
		if (sol1[gear] == dir)
			tmp = sol1.clone();
		else
			tmp = sol2.clone();

		for (int i = 1; i < flag.length; i++) {
			if (flag[i] && tmp[i] == 1)
				list[i].add(0, list[i].remove(7));

			else if (flag[i] && tmp[i] == -1)
				list[i].add(list[i].remove(0));
		}
	}

	public static int score() {
		int ans = 0;

		if (list[1].get(0) == 1)
			ans += 1;
		if (list[2].get(0) == 1)
			ans += 2;
		if (list[3].get(0) == 1)
			ans += 4;
		if (list[4].get(0) == 1)
			ans += 8;
		return ans;
	}
}