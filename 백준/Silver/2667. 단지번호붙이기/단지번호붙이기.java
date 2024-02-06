import java.io.*;
import java.util.*;

public class Main {
    static int n, count;
    static int[][] arr;
    static boolean[][] flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        flag = new boolean[n][n];
        for(int i = 0; i < n; i++) {
            arr[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(!flag[i][j] && arr[i][j] == 1) {
                    count = 0;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }
        list.sort((o1, o2) -> o1 - o2);
        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for(int i : list) sb.append(i).append("\n");
        System.out.println(sb);
    }
    static void dfs(int x, int y) {
        if(x < 0 || x >= n || y < 0 || y >= n || flag[x][y] || arr[x][y] == 0) return;

        //현재 위치 방문
        flag[x][y] = true;
        count++;
        //위쪽 방문
        dfs(x - 1, y);
        //아래쪽 방문
        dfs(x + 1, y);
        //왼쪽 방문
        dfs(x, y - 1);
        //오른쪽 방문
        dfs(x, y + 1);

    }
}