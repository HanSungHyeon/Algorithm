import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static boolean[] flag;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        flag = new boolean[n + 1];
        for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list[from].add(end);
            list[end].add(from);
        }
        int count = 0;
        for(int i = 1; i <= n; i++) {
            if(!flag[i]) {
                bfs(i);
                count++;
            }
        }
        System.out.println(count);
    }
    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        flag[start] = true;

        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int i : list[cur]) {
                if(!flag[i]) {
                    flag[i] = true;
                    q.add(i);
                }
            }
        }
    }

}
