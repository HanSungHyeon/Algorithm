import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int num, h;
        public Node(int num, int h){
            this.num = num;
            this.h = h;
        }
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        Stack<Node> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            int high = Integer.parseInt(st.nextToken());
                while(true) {
                    if(stack.isEmpty()){
                        sb.append(0).append(" ");
                        stack.push(new Node(i +1, high));
                        break;
                    }

                    int num = stack.peek().num;
                    int h = stack.peek().h;

                    if(h < high) {
                        stack.pop();
                    }
                    else {
                        sb.append(num).append(" ");
                        stack.push(new Node(i + 1, high));
                        break;
                    }
                }
            }
        System.out.println(sb);
    }
}
