import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        long num;
        int count;

        public Node(long num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int from = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int ans = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(from, 1));

        while (!q.isEmpty()) {
            long num = q.peek().num;
            int count = q.peek().count;
            q.poll();

            long tmp1 = num * 2;
            long tmp2 = Long.parseLong(num + "1");

            if (tmp1 == end || tmp2 == end) {
                ans = count + 1;
                break;
            }

            if (tmp1 < end)
                q.add(new Node(tmp1, count + 1));
            if (tmp2 < end)
                q.add(new Node(tmp2, count + 1));
        }
        if(ans != 0) System.out.println(ans);
        else System.out.println(-1);
    }
}