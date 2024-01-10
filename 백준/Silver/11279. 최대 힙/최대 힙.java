import java.io.*;
import java.util.*;

public class Main {
    public static PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            if(num == 0) remove();
            else insert(num);
        }
        System.out.println(sb.toString());
    }
    public static void insert(int num) {
        pq.add(num);
    }

    public static void remove() {
        if(pq.isEmpty()) sb.append(0);
        else sb.append(pq.poll());
        sb.append("\n");
    }
}
