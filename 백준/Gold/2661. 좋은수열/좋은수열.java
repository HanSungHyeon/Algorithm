import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static String ans = "";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		dfs("");
		System.out.println(ans);
	}
	static void dfs(String str) {
		if(!ans.equals("")) return;

		if(str.length() == n) {
			ans = str;
			return;
		}

		for(int i = 1; i <= 3; i++) {
			//맨 뒤랑 같은 숫자면 걍 넘어감 -> 나쁜 수열임
			if(str.length() > 0 && str.charAt(str.length() - 1) == 'i') continue;

			//다른 숫자면 좋은 수열인지 확인
			if(isCheck(str + i)) {
				dfs(str + i);
			}
		}
	}
	static boolean isCheck(String str) {
		for(int i = 1; i <= str.length() / 2; i++) {
			//뒷에서 뜯어낸 문자열
			String tmp1 = str.substring(str.length() - i);
			//앞단에서 뜯어낸 문자열
			String tmp2 = str.substring(str.length() - (2 * i),str.length() - i);

			if(tmp1.equals(tmp2)) return false;
		}
		return true;
	}
}
