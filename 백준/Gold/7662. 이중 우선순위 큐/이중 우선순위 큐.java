import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for(int t = 0; t < tc; t++) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for(int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                //삽입
                if(str.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
                //삭제
                else {
                    int key = 0;
                    if(map.isEmpty()) continue;
                    else if(num == -1) key = map.firstKey();
                    else key = map.lastKey();

                    int v = map.getOrDefault(key, 0);
                    if(v > 1) map.put(key, v - 1);
                    else if(v == 1) map.remove(key);
                }
            }
            if(map.isEmpty()) sb.append("EMPTY");
            else sb.append(map.lastKey()).append(" ").append(map.firstKey());
            sb.append("\n");
        }
        System.out.println(sb);
    }
}