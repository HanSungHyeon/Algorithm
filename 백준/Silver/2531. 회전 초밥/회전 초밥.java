import java.io.*;
import java.util.*;
public class Main {
	static int n, d, k, c;
	static int[] arr;
	static int[] flag;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		arr = new int[n];
		flag = new int[d + 1];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		flag[c]++;
		System.out.println(solution());
	}
	static int solution () {
		int ans = 0;
		//초기 작업
		for(int i = 0; i < k; i++) {
			flag[arr[i]]++;
		}
		ans = Math.max(isCheck(), ans);

		//8 % 8 = 0
		//logic
		for (int i = 1; i < n; i++) {
			flag[arr[i - 1]]--;
			int idx = (i + k - 1) % n;
			flag[arr[idx]]++;
			ans = Math.max(isCheck(), ans);
		}
		return ans;
	}

	static int isCheck() {
		int count = 0;
		flag[c] = 1;
		for(int i : flag) {
			if(i > 0) count++;
		}
		return count;
	}
}