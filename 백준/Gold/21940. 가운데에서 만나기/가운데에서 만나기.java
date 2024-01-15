import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int INF = 1000000000;
        int[][] arr = new int[n + 1][n + 1]; //최단 거리 테이블
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++){
                if(i != j) arr[i][j] = INF;
            }
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            arr[from][to] = Math.min(arr[from][to], edge);
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int[][] goback = new int[n + 1][n + 1];
        //왕복 거리 구하기
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                goback[i][j] = arr[i][j] + arr[j][i];
            }
        }
        int k = Integer.parseInt(br.readLine());
        int[] max = new int[n + 1];
        st = new StringTokenizer(br.readLine(), " ");

        while(st.hasMoreTokens()) {
            int start = Integer.parseInt(st.nextToken());
            
            for(int i = 1; i <= n; i++) {
                max[i] = Math.max(max[i], goback[start][i]);
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++) {
            if(max[i] < min) {
                min = max[i];
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            if(max[i] == min) list.add(i);
        }

        list.sort((o1, o2) -> o1 - o2);
        StringBuilder sb = new StringBuilder();
        for(int i : list) sb.append(i).append(" ");

        System.out.println(sb);

    }
}