import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);

        int n = Integer.parseInt(br.readLine());
        for(int i =0 ; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            pq.add(num);
        }
        int ans = 0;
        if(pq.size() == 1) System.out.println(ans);

        else {
            while(!pq.isEmpty()) {
                int f = 0;
                int s = 0;

                f = pq.poll();
                if(pq.size() != 0) s = pq.poll();

                ans += (f + s);
                if(!pq.isEmpty())
                    pq.add(f + s);
            }
            System.out.println(ans);
        }
    }
}
