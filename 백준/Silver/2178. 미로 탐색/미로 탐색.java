import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x,y,d;
        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static int n, m;
    static int[][] arr, delta = {{1,0},{0,1},{-1,0},{0,-1}};
    static boolean[][] flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        flag = new boolean[n][m];

        for(int i = 0; i < n; i++) arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        int ans = bfs(0,0);

        System.out.println(ans);
    }
    static int bfs(int sx, int sy) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sx,sy,1));
        flag[sx][sy] = true;

        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int d = q.peek().d;
            q.poll();

            if(x == n - 1 && y == m - 1) return d;

            for(int i = 0; i < delta.length; i++) {
                int dx = x + delta[i][0];
                int dy = y + delta[i][1];

                if(dx < 0 || dx >= n || dy < 0 || dy >= m || flag[dx][dy] || arr[dx][dy] == 0) continue;

                flag[dx][dy] = true;
                q.add(new Node(dx,dy,d + 1));
            }
        }
        return 0;
    }
}