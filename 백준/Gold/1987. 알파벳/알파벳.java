import java.io.*;
import java.util.*;

public class Main {
    static int r, c, ans = 0;
    static char[][] arr;
    static int[] alpa = new int[26];
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new char[r][c];

        for(int i = 0; i < r; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        dfs(0,0,1);

        System.out.println(ans);
    }

    static void dfs(int x, int y, int count) {
        if(x < 0 || x >= r || y < 0 || y >= c || alpa[arr[x][y] - 'A'] > 0) {
            ans = Math.max(ans, count - 1);

            return;
        }

        char c = arr[x][y];
        alpa[c - 'A']++;

        //상
        dfs(x - 1, y, count + 1);

        //하
        dfs(x + 1, y, count + 1);

        //좌
        dfs(x, y - 1, count + 1);

        //우
        dfs(x, y + 1, count + 1);

        alpa[c - 'A']--;
    }
}
