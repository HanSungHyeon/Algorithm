import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) list.add(arr[i] + arr[j]);
        }

        list.sort((o1, o2) -> o1 - o2);

        int ans = 0;
        for(int i : arr) {
            for(int i2 : arr) {
                int lastNum = i - i2;

                if(lastNum >= 0 && binarySearch(lastNum)) ans = Math.max(ans, i);
            }
        }
        System.out.println(ans);
    }

    public static boolean binarySearch(int target) {
        int start = 0;
        int end = list.size() - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(list.get(mid) < target) start = mid + 1;

            else if (list.get(mid) > target) end = mid - 1;

            else return true;
        }
        return false;
    }
}
