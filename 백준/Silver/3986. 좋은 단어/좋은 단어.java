import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        for(int i = 0; i < n; i++) {
            String str = br.readLine();

            if(str.length() % 2 != 0) continue;

            Stack<Character> stack = new Stack<>();

            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(stack.isEmpty()) stack.push(c);

                else if(stack.peek() == c) {
                    stack.pop();
                }

                else {
                    stack.push(c);
                }
            }
            if(stack.isEmpty()) ans++;
        }
        System.out.println(ans);
    }
}