import java.io.*;
import java.util.*;

public class Main {
    static final String[] free = {"Mugunghwa", "ITX-Saemaeul", "ITX-Cheongchun"}, half = {"V-Train", "S-Train"};
    static String[] route;
    static int n, r, k, m, INF = 1000000000, idx = 1;
    static double[][] railo, origin;
    static HashMap<String, Integer> map = new HashMap<>();
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        idx = 1;
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()) {
            String city = st.nextToken();
            map.put(city, map.getOrDefault(city, idx++));
        }

        railo = new double[idx][idx];
        origin = new double[idx][idx];
        init(railo);
        init(origin);

        //여행 할 도시들
        m = Integer.parseInt(br.readLine());
        route = new String[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++) {
            String city = st.nextToken();
            route[i] = city;
        }

        //경로들
        k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String type = st.nextToken();
            int from = map.get(st.nextToken());
            int to = map.get(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            origin[from][to] = Math.min(origin[from][to], edge);
            origin[to][from] = Math.min(origin[to][from], edge);

            //내일로 무료
            if(isCheck(free, type)){
                railo[from][to] = Math.min(railo[from][to], 0);
                railo[to][from] = Math.min(railo[to][from], 0);
            }

            //반값
            else if(isCheck(half, type)){
                railo[from][to] = Math.min(railo[from][to], (double)edge / 2);
                railo[to][from] = Math.min(railo[to][from], (double)edge /2);
            }

            //원가 그대로
            else {
                railo[from][to] = Math.min(railo[from][to], edge);
                railo[to][from] = Math.min(railo[to][from], edge);
            }
        }

        //최단 거리 2가지 버전 구하기
        warshall(origin);
        warshall(railo);

        if(pay(origin) > pay(railo) + r) System.out.println("Yes");
        else System.out.println("No");

    }

    public static double pay(double[][] arr) {
        int start = map.get(route[0]);
        double pay = 0;
        for(int i = 1; i < route.length; i++) {
            int end = map.get(route[i]);
            pay += arr[start][end];
            start = end;
        }
        return pay;
    }

    public static void warshall (double[][] arr) {
        for(int k = 1; k < idx; k++) {
            for(int i = 1; i < idx; i++){
                for(int j = 1; j < idx; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
    }
    public static boolean isCheck(String[] arr, String type) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals(type)) return true;
        }
        return false;
    }

    public static void init(double[][] arr) {
        for(int i = 1; i < arr.length; i++) {
            for(int j = 1; j < arr[0].length; j++) {
                if(i != j) arr[i][j] = INF;
            }
        }
    }
}
