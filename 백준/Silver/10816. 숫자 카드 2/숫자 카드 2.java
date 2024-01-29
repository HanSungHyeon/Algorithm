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
        int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for(int i : tmp) {
            int s = firstBinarySearch(i);
            int e = lastBinarySearch(i);
            sb.append(e - s + 1).append(" ");
        }
        System.out.println(sb);

    }
    //해당 숫자가 처음 나온 위치
    static int firstBinarySearch(int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] < target) start = mid + 1;
            else end = mid - 1;
        }
        return start;
    }

    //해당 숫자가 마지막으로 나온 위치
    static int lastBinarySearch(int target){
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] <= target) start = mid + 1;
            else end = mid - 1;
        }
        return end;
    }
}
