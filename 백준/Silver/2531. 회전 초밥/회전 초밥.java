import java.io.*;
import java.util.*;

public class Main {
    static int N, d, k, c;
    static int[] sushi;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken())-1;
        sushi = new int[N];
        int[] eat = new int[d];	// 해당 종류의 초밥을 몇개 먹었는지 저장하는 배열
        for(int i =0 ; i < N ; i++){
            sushi[i] = Integer.parseInt(br.readLine())-1;
        }
        int res = 0;
        int cnt = 0;
        for(int i =0 ; i < k ; i++){
            if(eat[sushi[i]]++ == 0) cnt++;
        }
        for(int i =0 ; i < N ; i++){
            if(res <= cnt){     // MAX 값 새로 갱신
                if(eat[c] == 0) res = cnt+1;
                else res = cnt;
            }
            int j = (i+k)%N;  // end 값 (순환 → 인덱스 초과할 때의 처리)
            if(eat[sushi[j]] ++ == 0) cnt++;
            if(-- eat[sushi[i]] == 0) cnt--;
        }
        System.out.println(res);
    }
}