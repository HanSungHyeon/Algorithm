import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int m = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        while(m-- > 0) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(target)).append("\n");
        }
        System.out.println(sb);
    }
    static int binarySearch(int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] == target) return 1;

            else if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return 0;
    }
}
