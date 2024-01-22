import java.io.*;
import java.util.*;

public class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        HashMap<Integer, Boolean> map = new HashMap<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, true);
        }

        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i : a) {
            if(!map.getOrDefault(i, false)) {
                count++;
                list.add(i);
            }
        }

        sb.append(count).append("\n");
        for(int i : list) sb.append(i).append(" ");
        System.out.println(sb);
    }
}
