import java.io.*;
import java.util.*;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());

		while(t-- > 0) {
			int len = Integer.parseInt(br.readLine());
			String input = br.readLine();

			List<Character> list = new ArrayList<>();
			for(int i = 0; i < len; i++) {
				list.add(input.charAt(i));
			}

			boolean flag = true;
			while(flag && list.size() >= 3) {
				for(int i = 0; i <= list.size() - 3; i++) {
					String word = "";
					for(int j = i; j < i + 3; j++) {
						word += list.get(j);
					}
					if(word.equals("ABB")) {
						list.set(i, 'B');
						list.set(i + 1, 'A');
						list.remove(i + 2);
						flag = true;
						break;
					}
					flag = false;
				}
			}
			String ans = "";
			for(char c : list) ans += c;
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
