import java.io.*;
import java.util.*;

public class Main {
    static int n, m ,v;
    static List<Integer>[] list;
    static boolean[] flag;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        v = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        flag = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[from].add(end);
            list[end].add(from);
        }

        for(int i = 1; i <= n; i++) list[i].sort((o1, o2) -> o1 - o2);

        dfs(v);
        sb.append("\n");
        Arrays.fill(flag, false);
        bfs(v);
        System.out.println(sb);
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        flag[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();
            sb.append(cur).append(" ");

            for(int i : list[cur]) {
                if(!flag[i]) {
                    flag[i] = true;
                    q.add(i);
                }
            }
        }
    }

    static void dfs(int cur) {
        if(flag[cur]) return;

        sb.append(cur).append(" ");

        flag[cur] = true;
        for(int i : list[cur]) {
            dfs(i);
        }
    }
}
