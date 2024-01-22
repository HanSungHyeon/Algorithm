import java.io.*;
import java.util.*;

public class Main {
    static int[] clone;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        clone = Arrays.stream(arr.clone()).distinct().sorted().toArray();

        for(int i : arr) {
            sb.append(binarySearch(i, 0, clone.length - 1)).append(" ");
        }
        System.out.println(sb);
    }
    public static int binarySearch(int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;

            if(target < clone[mid]) end = mid - 1;
            else if (target > clone[mid]) start = mid + 1;
            else return mid;
        }
        return 0;
    }
}
