import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y, d;
        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static int m,n;
    static int[][] arr, delta = {{1,0},{-1,0},{0,1},{0,-1}};
    static Queue<Node> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 1) {
                    q.add(new Node(i,j,0));
                }
            }
        }
        int ans = bfs();
        System.out.println(ans);
    }
    static boolean isCheck() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0) return false;
            }
        }
        return true;
    }
    static int bfs() {
        int ans = 0;
        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int d = q.peek().d;
            q.poll();

            ans = Math.max(d, ans);
            for(int i = 0; i < delta.length; i++) {
                int dx = delta[i][0] + x;
                int dy = delta[i][1] + y;

                if(dx < 0 || dx >= n || dy < 0 || dy >= m || arr[dx][dy] != 0) continue;

                q.add(new Node(dx,dy,d + 1));
                arr[dx][dy] = 1;
            }
        }
        if(isCheck()) return ans;

        else return -1;
    }
}