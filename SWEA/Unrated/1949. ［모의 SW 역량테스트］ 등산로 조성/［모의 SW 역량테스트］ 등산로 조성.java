import java.io.*;
import java.util.*;

public class Solution {
    static int n, k, max, ans;
    static int[][] arr, delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } },tmp;
    static List<Idx> idxList;
    static boolean[][] flag;
    static class Idx {
        int x, y;

        public Idx(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Node {
        int x, y, d;

        public Node(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            ans = Integer.MIN_VALUE;
            max = Integer.MIN_VALUE;
            arr = new int[n][n];
            idxList = new ArrayList<>();

            // 입력
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    arr[i][j] = num;
                    if (num > max)
                        max = num;
                }
            }
            // 제일 높은 봉우리 idx 저장
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] == max)
                        idxList.add(new Idx(i, j));
                }
            }
            cut();
//			print();
            System.out.println("#" + t + " " + ans);
        }
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(arr[i]));

        }
    }

    // 배열 복사
    private static int[][] copy() {
        int[][] tmp = new int[n][n];

        for (int i = 0; i < n; i++)
            tmp[i] = arr[i].clone();

        return tmp;
    }

    // 봉우리 깍기
    private static void cut() {
        tmp = copy();
        flag = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int z = 0; z <= k; z++) {
                    tmp[i][j] -= z;
                    start();
                    tmp[i][j] += z;
                }
            }
        }
    }

    //시작
    private static void start() {
        for(Idx idx : idxList) {
            dfs(idx.x,idx.y,1);
//			Arrays.fill(flag,false);
            flag = new boolean[n][n];
        }
    }

    // 등산로 탐색
    private static void dfs(int x, int y, int d) {
        flag[x][y] = true;

        if(d > ans) ans = d;
//        System.out.println(d);
        for(int i = 0; i < delta.length; i++) {
            int dx = x + delta[i][0];
            int dy = y + delta[i][1];

            if(dx < 0 || dy < 0 || dx >=n || dy >= n || flag[dx][dy]) continue;

            if(tmp[x][y] > tmp[dx][dy]) {
                dfs(dx,dy, d + 1);
                flag[dx][dy] = false;
            }
        }
    }

}