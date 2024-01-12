import java.io.*;
import java.util.*;

public class Main {
    static class J {
        int x, y, cost;

        public J(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static class Fire {
        int x, y;

        public Fire(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static String[][] map;
    static boolean[][] flag;
    static int[][] delta = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static Queue<J> q = new LinkedList<>();
    static Queue<Fire> fq = new LinkedList<>();
    static int r, c, ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new String[r][c];
        flag = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().split("");
            for (int j = 0; j < c; j++) {
                if (map[i][j].equals("J")) {
                    q.add(new J(i, j, 0));
                    flag[i][j] = true;
                } else if (map[i][j].equals("F")) {
                    fq.add(new Fire(i, j));
                }
            }
        }

        if(q.peek().x == 0 || q.peek().x == r - 1 || q.peek().y == 0 || q.peek().y == c -1)
            System.out.println(1);
        else{
            while(!q.isEmpty()) {
                fm(fq.size());
                if(jm(q.size())) break;
            }

            if(ans != 0) System.out.println(ans + 1);
            else System.out.println("IMPOSSIBLE");
        }

        // print();

    }

    //불 먼저 이동
    static void fm(int size) {
        while (size-- > 0) {
            int x = fq.peek().x;
            int y = fq.peek().y;
            fq.poll();

            for (int i = 0; i < delta.length; i++) {
                int dx = x + delta[i][0];
                int dy = y + delta[i][1];

                if (dx < 0 || dy < 0 || dx >= r || dy >= c || map[dx][dy].equals("#") || map[dx][dy].equals("F"))
                    continue;

                fq.add(new Fire(dx, dy));
                map[dx][dy] = "F";
            }
        }
    }

    //그 다음 지훈 이동
    //이동 가능 경로 : 벽 x, 불 x, 방문 한 곳 x -> 방문하지 않았고 .인곳만 이동 가능
    //벽 끝에 붙으면 사실상 탈출 ans = 벽 끝까지 붙는 비용 + 1
    static boolean jm(int size) {
        boolean run = false;

        while (size-- > 0&& !run) {
            int x = q.peek().x;
            int y = q.peek().y;
            int cost = q.peek().cost;
            q.poll();
            // System.out.println("size : " + (size + 1) + " cost : " + cost);
            for (int i = 0; i < delta.length; i++) {
                int dx = x + delta[i][0];
                int dy = y + delta[i][1];

                if (dx == 0 || dy == 0 || dx == r - 1 || dy == c - 1) {
                    if(map[dx][dy].equals(".") && !flag[dx][dy]) {
                        run = true;
                        ans = cost + 1;
                        break;
                    }
                }

                if (flag[dx][dy] || map[dx][dy].equals("F") || map[dx][dy].equals("#"))
                    continue;

                flag[dx][dy] = true;
                q.add(new J(dx, dy, cost + 1));
            }
        }
        return run;
    }

    static void print() {
        for(int i = 0; i < r; i++) System.out.println(Arrays.toString(map[i]));
    }
}
