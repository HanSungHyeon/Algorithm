import java.io.*;
import java.util.*;

public class Main {
    static int t, n, ans;
    static int[] arr;
    static boolean[] com, flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            ans = 0;
            arr = new int[n + 1];
            com = new boolean[n + 1];
            flag = new boolean[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] == i){
                    com[i] = true;
                    ans++;
                }

            }

            for (int i = 1; i <= n; i++) {
                if (!com[i]) {
                    Arrays.fill(flag, false);
                    dfs(i);
                }
            }
            sb.append(n - ans).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start) {

        //이미 한 번 왔던 친구 -> 사이클이 생성된 친구
        if(flag[start]) {
            ans++;
            com[start] = true; //팀편성도 된거임
        }
        //아직 초면인 친구 -> 이제 만남
        else flag[start] = true;

        //이 친구는 누굴 만나고 싶을까
        int next = arr[start];

        //얘 만나고 싶은데 아직 팀 없대
        if(!com[next]) {
            dfs(next);
        }

        //이미 있나봄..
        //나만 팀 없어
        com[start] = true;

    }
}