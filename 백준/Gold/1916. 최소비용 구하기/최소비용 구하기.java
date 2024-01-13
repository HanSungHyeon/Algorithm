import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int v, cost;
        public Node(int v, int cost){
            this.v = v;
            this.cost = cost;
        }
    }
    static int n, m, INF = Integer.MAX_VALUE;
    static List<Node>[] list;
    static int[] dist, pre;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        dist = new int[n + 1];
        pre = new int[n + 1];

        for(int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
            dist[i] = INF;
            pre[i] = INF;
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[from].add(new Node(to, weight));
        }
        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dist[start] = 0;
        pre[start] = 0;
        dijkstra(start);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[end]);
        System.out.println(sb);
    }

    public static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(start,0));

        while(!pq.isEmpty()) {
            int cur = pq.peek().v;
            int cost = pq.peek().cost;
            pq.poll();

            if(dist[cur] != cost) continue;

            for(Node next : list[cur]) {
                if(dist[next.v] > dist[cur] + next.cost) {
                    dist[next.v] = dist[cur] + next.cost;
                    pre[next.v] = cur;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
