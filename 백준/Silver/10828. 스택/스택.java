import java.io.*;
import java.util.*;

public class Main {
    static class CustomStack {
        int[] arr;
        int size = 0;

        public CustomStack(int size) {
            this.arr = new int[size];
        }

        public void push(int num) {
            arr[size++] = num;
        }

        public int pop() {
            if(size == 0) return - 1;
            return arr[--size];
        }

        public int size() {
            return size;
        }

        public int empty() {
            if(size == 0) return 1;
            return 0;
        }

        public int top() {
            if(size != 0) return arr[size - 1];
            return -1;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        CustomStack cs = new CustomStack(n);

        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String cmd = st.nextToken();

            switch(cmd) {
                case "push" : {
                    int num = Integer.parseInt(st.nextToken());
                    cs.push(num);
                } break;

                case "pop" : sb.append(cs.pop()).append("\n");
                break;

                case "size" : sb.append(cs.size()).append("\n");
                break;

                case "empty" : sb.append(cs.empty()).append("\n");
                break;

                case "top" : sb.append(cs.top()).append("\n");
                break;
            }
        }
        System.out.println(sb);
    }
}