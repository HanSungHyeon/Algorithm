import java.io.*;
import java.util.*;

public class Main {
    static class Doc {
        int num, rank;
        public Doc(int num, int rank){
            this.num = num;
            this.rank = rank;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
            Queue<Doc> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < n; i++) {
                int rank = Integer.parseInt(st.nextToken());
                q.add(new Doc(i, rank));
                pq.add(rank);
            }

            int count = 0;
            while(!q.isEmpty()) {
                //큐 맨 앞이 먼저 빠질 수 있다면
                if(q.peek().rank == pq.peek()) {
                    Doc doc = q.poll();
                    pq.poll();
                    count++;
                    //내가 찾던 친구면 반복 걍 끝냄
                    if(doc.num == m) break;
                }
                else q.add(q.poll());
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}