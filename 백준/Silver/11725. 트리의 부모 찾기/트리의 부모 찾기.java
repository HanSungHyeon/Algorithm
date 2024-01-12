import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Integer>[] list = new ArrayList[n + 1];
        boolean[] flag = new boolean[n + 1];
        int[] arr = new int[n + 1];
        for(int i = 1; i <= n; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            //양방향
            list[from].add(to);
            list[to].add(from);
        }

        for(int i = 1; i <= n; i++) list[i].sort((o1, o2) -> o1 - o2);

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        flag[1] = true;
        while(!q.isEmpty()) {
            int node = q.poll();

            for(int v : list[node]) {
                if(!flag[v]) {
                    flag[v] = true;
                    arr[v] = node;
                    q.add(v);
                }
            }
        }
        Arrays.stream(arr).filter(i -> i != 0).forEach(i -> sb.append(i).append("\n"));
        System.out.println(sb);
    }
}