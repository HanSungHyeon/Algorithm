import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int v, cost;
        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
    static int n, e, INF = Integer.MAX_VALUE;
    static int[] dist;
    static List<Node>[] list;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        dist = new int[n + 1];

        for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, edge));
            list[to].add(new Node(from, edge));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] arr = new int[2];
        arr[0] = test(v1, v2);
        arr[1] = test(v2, v1);
        if(arr[0] == -1 && arr[1] == -1) System.out.println(-1);
        else {
            int ans = Arrays.stream(arr)
                .filter(n -> n > 0)
                .min()
                .getAsInt();
            System.out.println(ans);
        }
    }

    public static int test(int f, int s) {
        init(1);
        dijkstra(1, f, 0);
        int tmp1 = dist[f];
        init(f);
        dijkstra(f,s,0);
        int tmp2 = dist[s];
        init(s);
        dijkstra(s,n,0);
        int tmp3 = dist[n];

        if(tmp1 == INF || tmp2 == INF ||tmp3 == INF) return -1;
        return tmp1 + tmp2 + tmp3;
    }

    public static void dijkstra(int from, int to, int w) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(from,w));

        while(!pq.isEmpty()) {
            int start = pq.peek().v;
            int cost = pq.peek().cost;
            pq.poll();

            if(cost != dist[start]) continue;

            for(Node next : list[start]) {
                if(dist[next.v] > dist[start] + next.cost) {
                    dist[next.v] = dist[start] + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }

    public static void init(int start) {
        for(int i = 1; i <= n; i++) {
            if(i != start) dist[i] = INF;
            else dist[i] = 0;
        }
    }
}
