import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int r;
        int c;
        int s;

        public Node(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }
    }

    static int n, m, k, answer = Integer.MAX_VALUE;
    static int[][] arr, tmp, original;
    static Node[] cal, result;
    static boolean[] flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        original = new int[n][m];
        tmp = new int[n][m];
        cal = new Node[k];
        result = new Node[k];
        flag = new boolean[k];

        for (int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            cal[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()));
        }
        copy2();
        p(0);
        System.out.println(answer);
    }

    public static void p(int num) {
        if (num == k) {
            copy3();
            for (int i = 0; i < k; i++) {
                roop(result[i].r, result[i].c, result[i].s);
                //test();
            }

            min();
            return;
        }

        for (int i = 0; i < k; i++) {
            if (!flag[i]) {
                flag[i] = true;
                result[num] = cal[i];
                p(num + 1);
                flag[i] = false;
            }
        }
    }

    // 0 n - 1, 0 , m - 1
    public static void rotation(int xStart, int xEnd, int yStart, int yEnd) {
        // 왼 -> 오
        for (int i = yStart; i < yEnd; i++) {
            tmp[xStart][i + 1] = arr[xStart][i];
        }
        // 상 -> 하
        for (int i = xStart; i < xEnd; i++) {
            tmp[i + 1][yEnd] = arr[i][yEnd];
        }
        // 우 -> 좌
        for (int i = yEnd; i > yStart; i--) {
            tmp[xEnd][i - 1] = arr[xEnd][i];
        }
        // 하 -> 상
        for (int i = xEnd; i > xStart; i--) {
            tmp[i - 1][yStart] = arr[i][yStart];
        }
    }

    public static void roop(int r, int c, int s) {
        int xStart = r - s - 1;
        int yStart = c - s - 1;
        int xEnd = r + s - 1;
        int yEnd = c + s - 1;
        int count = Math.min(yEnd, xEnd) / 2;

        for (int i = 0; i < count; i++)
            rotation(xStart + i, xEnd - i, yStart + i, yEnd - i);
        copy();
    }

    public static void copy() {
        for (int i = 0; i < n; i++)
            arr[i] = tmp[i].clone();
    }

    public static void copy2() {
        for (int i = 0; i < n; i++) {
            tmp[i] = arr[i].clone();
            original[i] = arr[i].clone();
        }
    }
    public static void copy3() {
        for (int i = 0; i < n; i++) {
            arr[i] = original[i].clone();
            tmp[i] = original[i].clone();
        }
    }

    public static void min() {
        for (int i = 0; i < n; i++) {
            answer = Math.min(answer, Arrays.stream(tmp[i]).sum());
        }
    }

    public static void test() {
        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(tmp[i]));
        System.out.println("------------------------");
    }
}