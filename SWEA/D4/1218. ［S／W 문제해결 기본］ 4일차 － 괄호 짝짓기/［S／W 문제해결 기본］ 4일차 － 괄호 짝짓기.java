import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int tc = 0;
		while (++tc <= 10) {
			int n = Integer.parseInt(br.readLine());
			String[] arr = br.readLine().split("");
			Stack<String> stack = new Stack<>();

			for (int i = 0; i < n; i++) {
				String str = arr[i];
				if (stack.isEmpty()) {
					stack.push(str);
				} else if (stack.peek().equals("<") && str.equals(">")) {
					stack.pop();
				} else if (stack.peek().equals("(") && str.equals(")")) {
					stack.pop();
				} else if (stack.peek().equals("[") && str.equals("]")) {
					stack.pop();
				} else if (stack.peek().equals("{") && str.equals("}")) {
					stack.pop();
				} else
					stack.push(str);
			}

			System.out.println("#" + tc + " " + (stack.isEmpty() ? 1 : 0));

		}
	}
}