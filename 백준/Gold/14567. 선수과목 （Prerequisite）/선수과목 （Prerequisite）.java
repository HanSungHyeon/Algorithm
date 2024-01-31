import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int start, dist;
        public Node(int start, int dist) {
            this.start = start;
            this.dist = dist;
        }
    }
    static List<Node>[] list;
    static boolean[] flag;
    static int[] d;
    static int INF = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        flag = new boolean[n + 1];
        d = new int[n + 1];
        Arrays.fill(d, 1);
        Arrays.fill(flag,true);
        list = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            flag[end] = false;
            list[from].add(new Node(end,1));
        }

        for(int i = 1; i < flag.length; i++) {
            if(!flag[i]) d[i] = INF;
        }

        for(int i = 1; i< flag.length; i++) {
            if(flag[i]) {
                dijkstra(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) sb.append(d[i]).append(" ");
        System.out.println(sb);

    }
    static void dijkstra(int num) {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.dist - o2.dist);
        pq.add(new Node(num, 1));

        while(!pq.isEmpty()) {
            int start = pq.peek().start;
            int dist = pq.peek().dist;
            pq.poll();
            if(dist != d[start]) continue;

            for(Node next : list[start]) {
                if(d[next.start] < d[start] + 1) {
                    d[next.start] = d[start] + 1;
                    pq.add(new Node(next.start, d[next.start]));
                }
            }
        }
    }
}
