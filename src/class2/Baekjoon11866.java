package class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//11866 요세푸스
public class Baekjoon11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[k];

        for(int i = 1; i <= k; i++){
            queue.add(i);
        }

        int i = 1, idx = 0;

        while (!queue.isEmpty()){
            if (i % n == 0) {   //ex) n = 3 -> i = 3의 배수일 때
                arr[idx] = queue.poll(); //배열에 요소 삽입 후 idx증가
                idx++;
            }
            else {
                queue.add(queue.poll()); //맨 앞 요소를 빼서 맨 뒤로 다시 넣음
            }
            i++;
        }
        System.out.println(Arrays.toString(arr).replace("[","<").replace("]",">"));
    }
}
