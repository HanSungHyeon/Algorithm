import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        while(n-- > 0) {
            String[] arr = br.readLine().split("");
            Stack<String> stack = new Stack<>();

            for(String s : arr) {
                if(stack.isEmpty()) stack.push(s);

                else if(s.equals(")") && stack.peek().equals("(")) stack.pop();

                else stack.push(s);
            }
            if(stack.isEmpty()) sb.append("YES");
            else sb.append("NO");

            sb.append("\n");
        }
        System.out.println(sb);
    }
}