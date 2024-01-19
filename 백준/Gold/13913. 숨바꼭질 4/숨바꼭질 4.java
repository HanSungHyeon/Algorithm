import java.io.*;
import java.util.*;
public class Main {
    static class Node{
        int start, cost;
        public Node(int start, int cost) {
            this.start = start;
            this.cost = cost;
        }
    }
    static int n, k;
    static int[] arr = new int[100001];
    static boolean[] flag = new boolean[100001];
    static Queue<Node> q = new LinkedList<>();
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack =  new Stack<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if(n == k) sb.append(0).append("\n").append(k);

        else {
            sb.append(bfs(n)).append("\n");
            route();

            while(!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
        }

        System.out.println(sb);
    }

    public static void route() {
        int end = k;
        stack.push(end);
        while(true) {
            int prev = arr[end];
            stack.push(prev);
            if(prev == n) break;

            end = prev;
        }
    }

    public static int bfs(int s) {
        flag[s] = true;
        q.add(new Node(s, 0));

        while(!q.isEmpty()) {
            int start = q.peek().start;
            int cost = q.peek().cost;
            q.poll();

            if(start == k) return cost;

            visit(start + 1, start, cost + 1);
            visit(start - 1, start, cost + 1);
            visit(start * 2, start, cost + 1);
        }

        return 0;
    }

    public static void visit(int next, int start, int cost) {
        if(isCheck(next) && !flag[next]) {
            flag[next] = true;
            q.add(new Node(next, cost));
            arr[next] = start;
        }
    }

    public static boolean isCheck(int cur) {
        return cur >= 0 && cur < 100001;
    }

}