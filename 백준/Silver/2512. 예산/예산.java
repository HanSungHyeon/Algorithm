//모든 요청이 배정 될 수 있는 경우에는 요청 금액 그대로 배정 진행
//만약 안된다면 국가 예산에서 최대로 줄 수 있는 만큼을 줌
//상한선을 잡고 그만큼만 준다는 거임
//모든 지방이 만족 할 순 없다 이겁니다.

//상한선이 127 -> 원하는 요청만큼 일단 배분 진행
//120 110 127 127
//상한선보다 요청금액이 적다면 걍 다 줘버리고
//상한선보다 요청금액이 크다면 상한선까지만 준다
//국가 예산은 이분탐색으로 진행
//배열의 합이 국가예산보다 적은 경우 배열의 max값 그대로 리턴해버림

import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int max = 0, m, sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
            sum += arr[i];
        }
        int m = Integer.parseInt(br.readLine());

        if(m == sum) System.out.println(max);
        else {
            int ans = binarySearch(m);
            System.out.println(ans);
        }
    }

    static int binarySearch(int m) {
        int start = 1;
        int end = max;

        while(start <= end) {
            int mid =  (start + end) / 2;

            int amount = 0;
            for(int i : arr) {
                if(mid >= i) amount += i;
                else amount += mid;
            }

            //국가가 줄 수 있느
            if(amount > m) end = mid - 1;
            else start = mid + 1;
        }
        return end;
    }
}