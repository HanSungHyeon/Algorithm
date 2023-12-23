import java.io.*;
import java.util.*;

public class Main {
    public static class Info{
        int  node;
        int count;

        public Info(int node, int count) {
            this.count = count;
            this.node = node;
        }
    }
    static ArrayList<Integer>[] list;
    static boolean[] flag;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        flag = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }
        //양방향
        for (int i = 0; i < m; i++) {
             st = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }

        int num = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 1; i <= n; i++) {
            flag = new boolean[n + 1];
            int tmp = bfs(i);
            if(tmp != 0 && num > tmp) {
                ans = i;
                num = tmp;
            }
        }
        System.out.println(ans);

    }

    public static int bfs(int num) {
        int tmp = 0;
        flag[num] = true;
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(num,0));

        while(!q.isEmpty()) {
            int node = q.peek().node;
            int count = q.peek().count;
            q.poll();

            if(node != num) {
                tmp += count;
            }

            for(int i : list[node]) {
                if(!flag[i]) {
                    q.add(new Info(i,count + 1));
                    flag[i] = true;
                }
            }
        }
        return tmp;
    }
}
