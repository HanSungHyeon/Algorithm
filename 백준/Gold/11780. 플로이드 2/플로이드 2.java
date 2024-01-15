import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int [n + 1][n + 1]; //최단 거리
        int[][] nxt = new int [n + 1][n + 1]; //최단 경로
        int INF = 100000000;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i != j) arr[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            if(arr[from][end] > edge) {
                arr[from][end] = edge;
                nxt[from][end] = end;
            }
        }

        //최단 경로 그래프 만들기
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                        nxt[i][j] = nxt[i][k];
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(arr[i][j] == INF) arr[i][j] = 0;
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if(i == j || arr[i][j] == 0) {
                    sb.append(0).append("\n");
                }
                else {
                    root(i,j, nxt);
                }
            }
        }
        System.out.println(sb);
    }
    public static void root(int start, int end, int[][] nxt){
        int count = 1;
        List<Integer> list = new ArrayList<>();
        list.add(start);
        while(nxt[start][end] != end) {
            start = nxt[start][end];
            list.add(start);
            count++;
        }
        list.add(end);
        sb.append(count + 1).append(" ");

        for(int i : list) sb.append(i).append(" ");
        sb.append("\n");
    }
}
