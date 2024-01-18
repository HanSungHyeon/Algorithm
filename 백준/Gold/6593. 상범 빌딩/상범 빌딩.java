import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int x, y, h, d;
        public Node(int x, int y, int h, int d) {
            this.x = x;
            this.y = y;
            this.h = h;
            this.d = d;
        }
    }
    static int l, r, c;
    static char[][][] arr;
    static boolean[][][] flag;
    //동 서 남 북 상 하
    static int[][] delta = {{0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, {0, 0, 1}, {0, 0, - 1}};
    static Queue<Node> q;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if(l == 0 && r == 0 && c== 0) break;

            arr = new char[r][c][l];
            flag = new boolean[r][c][l];
            q = new LinkedList<>();

            for(int i = 0; i < l; i++) {
                for(int j = 0; j < r + 1; j++) {
                    String str = br.readLine();
                    if(str.length() == 0) break;
                    for(int k = 0; k < c; k++) {
                        char c = str.charAt(k);
                        if(c == 'S') {
                            q.add(new Node(j,k,i,0));
                            flag[j][k][i] = true;
                        }
                        arr[j][k][i] = c;
                    }
                }
            }
            int tmp = bfs();
            if(tmp == -1) sb.append("Trapped!").append("\n");
            else sb.append("Escaped in ").append(tmp).append(" minute(s).").append("\n");
        }
        System.out.println(sb);

    }
    public static int bfs() {

        while(!q.isEmpty()) {
            int x = q.peek().x;
            int y = q.peek().y;
            int h = q.peek().h;
            int d = q.peek().d;
            q.poll();

            for(int i = 0; i < delta.length; i++) {
                int dx = delta[i][0] + x;
                int dy = delta[i][1] + y;
                int dh = delta[i][2] + h;

                if(dx < 0 || dx >= r || dy < 0 || dy >= c || dh < 0 || dh >= l || arr[dx][dy][dh] == '#' || flag[dx][dy][dh])
                    continue;

                if(arr[dx][dy][dh] == 'E') return d + 1;

                flag[dx][dy][dh] = true;
                q.add(new Node(dx, dy, dh, d + 1));
            }
        }

        return -1;
    }
}
