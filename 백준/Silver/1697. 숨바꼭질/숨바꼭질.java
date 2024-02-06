import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] dist;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if(n == k) System.out.println(0);
        else {
            dist = new int[200001];
            Arrays.fill(dist,Integer.MAX_VALUE);
            bfs(n);
            System.out.println(dist[k]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;

        while(!q.isEmpty()) {
            int cur = q.poll();

            if(isCheck(cur + 1) && min(cur, cur + 1)) {
                q.add(cur + 1);
            }

            if(isCheck(cur - 1) && min(cur, cur - 1)) {
                q.add(cur - 1);
            }

            if(isCheck(cur * 2) && min(cur, cur * 2)) {
                q.add(cur * 2);
            }
        }
    }
    static boolean isCheck(int next) {
        return next >= 0 && next < dist.length;
    }

    static boolean min(int cur, int next){
        if(dist[next] > dist[cur] + 1) {
            dist[next] = dist[cur] + 1;
            return true;
        }
        return false;
    }

}
