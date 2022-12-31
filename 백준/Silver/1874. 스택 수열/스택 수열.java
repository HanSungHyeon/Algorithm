import java.util.*;
import java.io.*;

//1874 스택 수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int idx = 0;
        int[] arr = new int[tc];

        for (int i = 0; i < tc; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= tc; i++) {
            stack.push(i);
            sb.append("+").append("\n");

            while (!stack.empty()) {
                if (stack.peek() == arr[idx]) {
                    stack.pop();
                    idx++;
                    sb.append("-").append("\n");
                }
                else break;
            }
        }
        if(stack.isEmpty())
            System.out.println(sb);
        else
            System.out.println("NO");
    }
}