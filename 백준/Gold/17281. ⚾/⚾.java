import java.io.*;
import java.util.*;

public class Main {
	static int inning, ans = 0;
	static int[] pick;
	static boolean[] flag, base = new boolean[4];;
	static int[][] player;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		inning = Integer.parseInt(br.readLine());
		player = new int[inning][10];
		flag = new boolean[10];
		pick = new int[10];
		// 입력
		for (int i = 0; i < inning; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j < 10; j++) {
				player[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		play();
		
		flag[4] = true;
		pick[4] = 1;
		p(2);
		System.out.println(ans);
	}

	// 선수 명단 순열
	public static void p(int num) {
		if (num == 10) {		
			ans = Math.max(ans, play());
			return;
		}

		for (int i = 1; i < 10; i++) {
			if (!flag[i]) {
				flag[i] = true;
				pick[i] = num;
				p(num + 1);
				flag[i] = false;
			}
		}
	}

	private static int play() {
		int score = 0;
		int out = 0;
		Arrays.fill(base,false);
		int curInning = 0;
		A: while (true) {
			for (int i = 1; i < 10; i++) {
				int hitter = player[curInning][pick[i]];

				if (hitter == 0)
					out++;
				else
					score += hit(hitter);

				if (out == 3) {
					out = 0;
					curInning++;
					Arrays.fill(base,false);
					if (curInning == inning)
						break A;
				}
			}
		}

		return score;
	}

	private static int hit(int num) {
		int score = 0;
		// 1루타
		if (num == 1) {
			for (int i = 3; i >= 0; i--) {
				if (i == 3 && base[i]) {
					score++;
					base[i] = false;
				} else if (i <= 2 && base[i]) {
					base[i + 1] = true;
					base[i] = false;
				} else if (i == 0) {
					base[i + 1] = true;
				}
			}
		}
		// 2루타
		else if (num == 2) {
			for (int i = 3; i >= 0; i--) {
				if (i >= 2 && base[i]) {
					score++;
					base[i] = false;
				} else if (i < 2 && base[i]) {
					base[i + 2] = true;
					base[i] = false;
				} else if (i == 0) {
					base[i + 2] = true;
				}
			}
		}
		// 3루타
		else if (num == 3) {
			for (int i = 3; i >= 0; i--) {
				if (i >= 1 && base[i]) {
					score++;
					base[i] = false;
				} else if (i == 0) {
					base[i + 3] = true;
				}
			}
		} else if (num == 4) {
			score++;
			for (int i = 3; i >= 0; i--) {
				if (base[i]) {
					score++;
					base[i] = false;
				}
					
			}
		}
		return score;
	}
}