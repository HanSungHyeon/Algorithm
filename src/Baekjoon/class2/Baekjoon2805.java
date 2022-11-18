package Baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon2805 {
    public static void main(String[] args) throws IOException {
        //이분탐색 upperbound이용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int tree = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int high = Arrays.stream(arr).max().getAsInt();
        int low = 0;

        while (low < high) {
            int mid = (low + high) / 2;
            long sum = 0;

            for (int i : arr) {
                if(i > mid)
                    sum += (i - mid);   //자른 나무의 합계
            }
            //원하는 나무 길이보다 sum이 크다면 -> 너무 많이 자름
            //높이를 높여서 적게 잘라야 할 필요성이 있음
            //low값 상승
            if(count <= sum)
                low = mid + 1; //+1의 이유  -> 이미 mid값으로 잘랐을 때 남는다는 걸 확인했음

            //원하는 나무 길이보다 sum이 작다면 -> 너무 조금 자름
            //높이는 낮춰서 더 많이 잘라야함
            //high값 하락
            else
                high = mid;
        }

        System.out.println(low - 1);
    }
}
