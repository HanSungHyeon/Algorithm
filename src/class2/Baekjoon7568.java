package class2;
//7568 덩치
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon7568 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int[][] arr = new int[tc][2];

        for (int i = 0; i < tc; i++) { //몸무게 키 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        while (idx < tc){
            int rank = 1;

            for(int i = 0; i < tc; i++){
                if(arr[idx][0] < arr[i][0] && arr[idx][1] < arr[i][1]){
                    rank++;
                }
            }
            sb.append(rank + " ");
            idx++;
        }
        System.out.println(sb);
    }
}
