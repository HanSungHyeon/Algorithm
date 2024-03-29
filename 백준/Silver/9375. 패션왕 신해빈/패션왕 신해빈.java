import java.io.*;
import java.util.*;
import java.util.Map.Entry;

//9375
public class Main {
	public static int[][] dp = new int[32][32];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		

		while (tc-- > 0) {
			int clothes = Integer.parseInt(br.readLine());
			if(clothes == 0) {
				sb.append(0 + "\n");
				continue;
			}
			Map<String, Integer> map = new HashMap<>();

			for (int i = 0; i < clothes; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String wear = st.nextToken(); // 버림
				String type = st.nextToken();

				map.put(type, map.getOrDefault(type, 0) + 1); //옷의 종류 = key 갯수 = value
			}
			int result = 1;

			for (Entry<String, Integer> s : map.entrySet()) {
				result *= (s.getValue() + 1); //nCk 
			}

			sb.append(result - 1 + "\n"); //몸에 뭐라도 걸쳐야함 (null,null,null)불가하기 때문에 -1
		}
		System.out.println(sb);
	}

	public static int solution(int a, int b) {
		if (a == b || b == 0)
			return dp[a][b] = 1;
		if (dp[a][b] > 0)
			return dp[a][b];

		return dp[a][b] = solution(a - 1, b - 1) + solution(a - 1, b);
	}
}