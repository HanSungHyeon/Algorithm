import java.io.*;
import java.util.*;

public class Main {
    static int[] b;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int count = 0;
        List<Integer> list = new ArrayList<>();
        for(int i : a) {
            if(binarySearch(i, 0, b.length - 1))  {
                count++;
                list.add(i);
            }
        }
        if(count == 0) System.out.println(0);

        else {
            sb.append(count).append("\n");
            list.sort((o1, o2) -> o1 - o2);
            for(int i : list) sb.append(i).append(" ");
            System.out.println(sb);
        }
    }
    public static boolean binarySearch(int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;

            if(target < b[mid]) end = mid - 1;
            else if(target > b[mid]) start = mid + 1;
            else return false;
        }
        return true;
    }
}
