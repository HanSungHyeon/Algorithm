import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int start, cost;
        public Node(int start, int cost) {
            this.start = start;
            this.cost = cost;
        }
    }
    static int n, k, INF = Integer.MAX_VALUE;
    static int[] dist = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < dist.length; i++) {
            if (i != n)
                dist[i] = INF;
        }

        if(n >= k) System.out.println(n - k);
        else{
            dijkstra();
            System.out.println(dist[k]);
        }
    }
    public static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(n,0));

        while(!pq.isEmpty()) {
            int start = pq.peek().start;
            int cost = pq.peek().cost;
            pq.poll();

            if(dist[start] != cost) continue;

            if(isCheck(start + 1) && dist[start + 1] > dist[start] + 1) {
                dist[start + 1] = dist[start] + 1;
                pq.add(new Node(start + 1, dist[start + 1]));
            }

            if(isCheck(start - 1) && dist[start - 1] > dist[start] + 1) {
                dist[start - 1] = dist[start] + 1;
                pq.add(new Node(start - 1, dist[start - 1]));
            }

            if(isCheck(start * 2) && dist[start * 2] > cost) {
                dist[start * 2] = cost;
                pq.add(new Node(start * 2, dist[start * 2]));
            }
        }
    }
    public static boolean isCheck(int cur) {
        return cur > 0 && cur < dist.length;
    }
}