/*
m 범위가 20억이라서 완전탐색 불가
결국 이분탐색 진행을 해야함
나무 길이 배열로 주어지고
절단기 높이를 정하고 댕강~ 잘려진 나무 길이를 합쳤을 때 m보다 커야 함
절단기 높이 세팅을 이분탐색으로 진행
낭비되는 나무가 있으면 안되기 때문에 절단기 높이는 최대한 높은 수로 구해야함
절단된 나무의 합 >= m 이면 start를 땡기고
절단된 나무의 합 < m이라면 end를 땡김
일단 이분 탐색 진행하고 나무 잘라보고 절단된 나무 합 확인하고 start 또는 end값 재설정 진행
 */
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static long max = -1;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        long ans = binarySearch();
        System.out.println(ans - 1);
    }

    static long binarySearch() {
        long start = 1;
        long end = max;
        
        while(start <= end) {
            long mid = (start + end) / 2;
            
            long tree = 0;
            for(int i : arr) {
                if(i < mid) continue;
                tree += (i - mid);
            }
            
            if(tree >= m) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }
}