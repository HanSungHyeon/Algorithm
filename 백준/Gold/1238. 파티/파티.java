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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        int[] distR = new int[n + 1];
        List<Node>[] list = new ArrayList[n + 1];
        List<Node>[] listR = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
            listR[i] = new ArrayList<>();
            dist[i] = INF;
            distR[i] = INF;
        }
        dist[x] = 0;
        distR[x] = 0;

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            list[start].add(new Node(end, weight));
            listR[end].add(new Node(start, weight));
        }

        dijkstra(x, dist, list); //파티 -> 집
        dijkstra(x, distR, listR); //집 -> 파티

        int ans = 0;
        for(int i = 1; i <= n; i++) {
            ans = Math.max(ans, dist[i] + distR[i]);
        }
        System.out.println(ans);
    }
    public static void dijkstra(int x, int[] dist, List<Node>[] list) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(x,0));

        while(!pq.isEmpty()) {
            int cur = pq.peek().v;
            int cost = pq.peek().cost;
            pq.poll();

            if(dist[cur] != cost) continue;

            for(Node next : list[cur]) {
                if(dist[next.v] > dist[cur] + next.cost) {
                    dist[next.v] = dist[cur] + next.cost;
                    pq.add(new Node(next.v, dist[next.v]));
                }
            }
        }
    }
}
