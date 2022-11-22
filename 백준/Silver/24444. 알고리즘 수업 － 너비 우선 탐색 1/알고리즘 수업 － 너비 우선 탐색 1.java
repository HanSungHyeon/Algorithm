import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static int node,line,start,count = 1;
    public static boolean[] flag;
    public static List<Integer>[] list;
    public static int[] result;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        node = Integer.parseInt(st.nextToken());
        line = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());

        list = new ArrayList[node + 1];
        flag = new boolean[node + 1];
        result = new int[node + 1];
        //리스트 안에 리스트 생성
        for (int i = 1; i <= node; i++) list[i] = new ArrayList<>();

        while (line-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b); // 1 4 -> 리스트 인덱스 1에 4추가
            list[b].add(a);
        }

        for(int i = 1; i <= node; i++) Collections.sort(list[i]); //각 리스트 오름차순 정렬
        bfs(start);

        for (int i = 1; i <= node; i++) { //시간 줄임
            sb.append(result[i]).append("\n");
        }
        System.out.println(sb);
    }
    public static void bfs(int strat) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        result[start] = count++;
        while (!queue.isEmpty()) {
            start = queue.poll();

            for (int i : list[start]) {
                if(result[i] != 0) continue; //방문했을 경우 -> 어차피 도는 횟수 같음
                queue.add(i);
                result[i] =count++;
            }
        }
    }
}