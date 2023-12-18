import java.io.*;
import java.util.*;

public class Main {

    public static class Info {
        int x, y;

        public Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] map;
    static boolean[][] flag;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        flag = new boolean[n][n];

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < n; j++) {
                max = Math.max(max, map[i][j]);
            }
        }

        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= max; i++) {
            raining(i);
            ans = Math.max(ans, safeArea());
            flag = new boolean[n][n];
        }

        System.out.println(ans);
    }

    //비 내리기
    public static void raining(int num) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] <= num)
                    flag[i][j] = true;
            }
        }
    }

    //안전영역 카운트
    public static int safeArea() {
        Queue<Info> q = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (!flag[i][j]) {
                    q.add(new Info(i, j));
                    flag[i][j] = true;

                    while (!q.isEmpty()) {
                        int x = q.peek().x;
                        int y = q.peek().y;
                        q.poll();

                        for (int k = 0; k < delta.length; k++) {
                            int r = delta[k][0] + x;
                            int c = delta[k][1] + y;

                            if (r < 0 || r >= n || c < 0 || c >= n || flag[r][c])
                                continue;

                            q.add(new Info(r, c));
                            flag[r][c] = true;
                        }
                    }
                    count++;
                }
            }
        }
        return count;
    }
}