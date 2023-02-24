import java.io.*;
import java.util.*;

public class Main {
	static int l, c;
	static String[] arr, result, word = { "a", "e", "i", "o", "u" };
	static boolean[] flag;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		arr = br.readLine().split(" ");
		Arrays.sort(arr);
		result = new String[l];
		flag = new boolean[c];

		//p(0);
		c(0,0);
		System.out.println(sb);
	}

	public static void p(int num) {
		if (num == l) {
//			System.out.println(Arrays.toString(result));
			int smallCount = 0;
//			int bigCount = 0;
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < word.length; j++) {
					if (word[j].equals(result[i]))
						smallCount++;
				}
			}
			if (smallCount > 0 && l - smallCount > 1) {
				String[] tmp = result.clone();
				Arrays.sort(tmp);
				if (Arrays.equals(tmp, result)) {
					Arrays.stream(result).forEach(x -> sb.append(x));
					sb.append("\n");
				}
			}
			return;
		}

		for (int i = 0; i < c; i++) {
			if (!flag[i]) {
				flag[i] = true;
				result[num] = arr[i];
				p(num + 1);
				flag[i] = false;
			}
		}
	}

	public static void c(int num, int start) {
		if (num == l) {
//			System.out.println(Arrays.toString(result));
			int smallCount = 0;
//			int bigCount = 0;
			for (int i = 0; i < l; i++) {
				for (int j = 0; j < word.length; j++) {
					if (word[j].equals(result[i]))
						smallCount++;
				}
			}
			if (smallCount > 0 && l - smallCount > 1) {
				String[] tmp = result.clone();
				Arrays.sort(tmp);
				if (Arrays.equals(tmp, result)) {
					Arrays.stream(result).forEach(x -> sb.append(x));
					sb.append("\n");
				}
			}
			return;
		}
		
		
		for (int i = start; i < c; i++) {
			result[num] = arr[i];
			c(num + 1, i + 1);
		}
	}
}