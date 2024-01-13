import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        int node, d;
        public Node(int node, int d) {
            this.node = node;
            this.d = d;
        }
    }
    static int v, e, k, INF = Integer.MAX_VALUE;
    static int[] dist;
    static List<Node>[] list;

    public static void main(String[] arsg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());
        dist = new int[v + 1];
        list = new ArrayList[v + 1];

        for(int i = 0; i < v + 1; i++) {
            list[i] = new ArrayList<>();
            dist[i] = INF;
        }
        dist[k] = 0;

        for(int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v,w));
        }

        dijkstra();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < v + 1; i++) {
            if(dist[i] == INF) sb.append("INF");
            else sb.append(dist[i]);
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.d - o2.d);
        pq.add(new Node(k,0));

        while(!pq.isEmpty()) {
            int node = pq.peek().node;
            int d = pq.peek().d;
            pq.poll();

            if(dist[node] != d) continue; //확정된 거리와 다를 경우 걍 넘겨버림

            for(Node n : list[node]) {
                if(dist[n.node] > dist[node] + n.d) {
                    dist[n.node] = dist[node] + n.d;
                    pq.add(new Node(n.node, dist[n.node]));
                }
            }

        }
    }
}
