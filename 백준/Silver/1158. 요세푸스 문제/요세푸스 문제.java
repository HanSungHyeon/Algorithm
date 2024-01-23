import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= n; i++) q.add(i);

        sb.append("<");
        int count = 1;
        while(!q.isEmpty()) {
            if(q.size() == 1) {
                sb.append(q.poll()).append(">");
                break;
            }

            else if(count == k){
                sb.append(q.poll()).append(", ");
                count = 1;
            }

            else {
                q.add(q.poll());
                count++;
            }
        }
        System.out.println(sb);
    }

}