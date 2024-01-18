import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            String[] str = br.readLine().split("");
            Stack<String> stack = new Stack<>();
            Stack<String> tmp = new Stack<>();

            for(String s: str) {
                if(stack.isEmpty() && (s.equals("<") || s.equals("-"))) continue;

                else if(tmp.isEmpty() && s.equals(">")) continue;

                else {
                    switch(s) {
                        case "-" : {
                            stack.pop();
                        }break;
                        case "<" : {
                            tmp.push(stack.pop());
                        }break;
                        case ">" : {
                            stack.push(tmp.pop());
                        }break;
                        default : {
                            stack.push(s);
                        } break;
                    }
                }
            }
            while(!tmp.isEmpty()) stack.push(tmp.pop());
            for(String s : stack) sb.append(s);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
