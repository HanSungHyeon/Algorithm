package Baekjoon.class2;

import java.io.*;
import java.util.Stack;

public class Baekjoon4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        while (true) {
            Stack<String> stack = new Stack<>();
            String[] input = br.readLine().split("");
            StringBuilder sb = new StringBuilder();
            if(input[0].equals("."))
                break;

            for (String s : input) {
                if(s.equals("(") || s.equals("[") || s.equals(")") || s.equals("]")){
                    if(stack.isEmpty())
                        stack.push(s);
                    else if(stack.peek().equals("(") && s.equals(")"))
                        stack.pop();
                    else if(stack.peek().equals("[") && s.equals("]"))
                        stack.pop();
                    else
                        stack.push(s);
                }
                if(s.equals("."))
                    break;

            }
            if(stack.isEmpty())
                sb.append("yes" + '\n');
            else
                sb.append("no" + '\n');
            bw.write(sb.toString());
            bw.flush();
        }
        bw.close();
    }
}
