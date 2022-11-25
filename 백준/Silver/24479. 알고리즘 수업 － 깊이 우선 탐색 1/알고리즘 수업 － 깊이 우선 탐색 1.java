import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static List<Integer>[] list;
    public static int node, line, start, count = 0;
    public static int[] flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        list = new ArrayList[node + 1];
        flag = new int[node + 1];
        for (int i = 1; i <= node; i++) list[i] = new ArrayList<>();

        while (line-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        for(int i = 1; i <= node; i++) Collections.sort(list[i]);
        dfs(start);
        for (int i = 1; i < flag.length; i++)
            System.out.println(flag[i]);
    }

    public static void dfs(int start) {
        flag[start] = ++count;

        for (int i : list[start]) {
            if(flag[i] == 0)
                dfs(i);
        }
    }
}
