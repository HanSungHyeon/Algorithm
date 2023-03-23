import java.io.*;
import java.util.*;

public class Main {
	static class Info {
		int durability;
		boolean robot;

		public Info(int durability, boolean robot) {
			this.durability = durability;
			this.robot = robot;
		}
	}

	static int n, k, out;
	static Info[] belt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		out = n - 1;
		belt = new Info[n * 2];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n * 2; i++) {
			int num = Integer.parseInt(st.nextToken());

			belt[i] = new Info(num, false);
		}
		
		int ans = 0;
		while(true) {
			ans++;
			rotate();
			move();
			put();
			if(isCheck()) break;
		}
		System.out.println(ans);
	}

	// 로봇 탈출
	private static void out() {
		if (belt[out].robot)
			belt[out].robot = false;
	}

	// step1. 컨베이어 벨트 회전
	private static void rotate() {
		Info tmp = belt[belt.length - 1];

		for (int i = belt.length - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = tmp;
		out();
	}

	// step2. 로봇 이동
	// 가장 먼저 올라간 로봇 부터 이동
	private static void move() {
		for (int i = out - 1; i >= 0; i--) {
			if(belt[i].robot&&!belt[i + 1].robot && belt[i + 1].durability > 0) {
				belt[i + 1].robot = true;
				belt[i + 1].durability--;
				belt[i].robot = false;
			}
		}
		out();
	}
	
	//step3. 로봇 올리기
	private static void put() {
		if(!belt[0].robot && belt[0].durability != 0) {
			belt[0].robot = true;
			belt[0].durability--;
		}
	}
	//setp4. 내구도 0 개수랑 k랑 비교
	private static boolean isCheck() {
		long count = Arrays.stream(belt).filter(info -> info.durability == 0).count();
		if(count >= k) return true;
		return false;
	}
}