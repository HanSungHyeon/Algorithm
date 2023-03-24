import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] result,arr;
    static boolean[] flag;
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[m];
        flag = new boolean[n];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        p(0);
        for(String s : list) sb.append(s + "\n");
        System.out.println(sb);
    }
    private static void p(int num){
        if(num == m){
            String str = "";
            for(int i = 0 ;i < m; i++)
                str += result[i] + " ";
            list.add(str);
            return;
        }

        for (int i = 0; i < n; i++) {
            if(!flag[i]){
                flag[i] = true;
                result[num] = arr[i];
                p(num + 1);
                flag[i] = false;
            }
        }
    }
}