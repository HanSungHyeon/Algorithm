package Baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            Stack<String> stack = new Stack<>();
            String[] input = br.readLine().split("");

            for (String s : input) {
                if(stack.isEmpty())
                    stack.push(s);

                else if(stack.peek().equals("(") && s.equals(")"))
                    stack.pop();

                else
                    stack.push(s);
            }
            System.out.println(stack.isEmpty() ? "YES" : "NO");
        }
    }
}
