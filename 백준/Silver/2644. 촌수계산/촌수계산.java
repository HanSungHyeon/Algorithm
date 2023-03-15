import java.io.*;
import java.util.*;

public class Main {
    static int n,m,start, end,ans = -1;
    static List<Integer>[] list;
    static boolean[] flag;

    private static void dfs(int node,int line) {


        if(node == end) {
            ans =  line;
            return;
        }
        flag[node] = true;
        for(int i : list[node]) {
            if(!flag[i])
                 dfs(i,line + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        flag = new boolean[n + 1];
        list = new ArrayList[n + 1];
        for(int i = 1 ; i<= n; i++)
            list[i] = new ArrayList<>();

        m = Integer.parseInt(br.readLine());
        for(int i = 0 ; i< m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }
        dfs(start,0);
        System.out.println(ans);
    }
}