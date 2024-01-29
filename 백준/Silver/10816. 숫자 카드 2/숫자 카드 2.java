import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static HashMap<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int count = map.getOrDefault(num, 0);

            if(count == 0) arr[i] = num;
            map.put(num, count + 1);
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(target, 0, arr.length - 1)).append(" ");
        }
        System.out.println(sb);
    }
    public static int binarySearch(int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;

            if(target < arr[mid]) end = mid - 1;
            else if(target > arr[mid]) start = mid + 1;
            else return map.get(target);
        }

        return 0;
    }
}
