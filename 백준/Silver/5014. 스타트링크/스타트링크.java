import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int v, cost;
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    static boolean[] flag;
    static int f,s,g,u,d;

    public static int bfs() {
        if(s == g) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(s, 0));
        flag[s] = true;
        int ans = -1;
        while(!q.isEmpty()) {
            int v = q.peek().v;
            int cost = q.peek().cost;
            q.poll();

            int up = v + u;
            int down = v - d;

            if(up == g || down == g) return cost + 1;

            if(up < f && !flag[up]) {
                q.add(new Node(up, cost + 1));
                flag[up] = true;
            }

            if(down > 0 && !flag[down]){
                q.add(new Node(down, cost + 1));
                flag[down] = true;
            }
        }

        return ans;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        flag = new boolean[f + 1];

        int ans = bfs();

        if(ans == -1) System.out.println("use the stairs");
        else System.out.println(ans);

    }
}