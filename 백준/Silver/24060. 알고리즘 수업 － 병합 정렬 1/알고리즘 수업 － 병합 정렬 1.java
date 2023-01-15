import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int[] temp;
    public static int count = 0;
    public static int k;
    public static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        temp = new int[arr.length];
        merge_sort(arr, 0, arr.length - 1);
        System.out.println(result);
    }

    //분할
    public static void merge_sort(int[] arr, int p, int r) {
        if (p == r) return;

        int mid = (p + r) / 2;
        merge_sort(arr, p, mid);
        merge_sort(arr, mid + 1, r);
        merge(arr, p, mid, r);

    }

    //합병
    public static void merge(int[] arr, int p, int q, int r) {
        int leftStart = p;
        int rightStart = q + 1;
        int idx = leftStart;

        //임시 배열에 넣기
        while (leftStart <= q && rightStart <= r) {
            if (arr[leftStart] <= arr[rightStart]) {
                temp[idx] = arr[leftStart];
                leftStart++;
            } else {
                temp[idx] = arr[rightStart];
                rightStart++;
            }
            idx++;
        }

        //좌측이 먼저 다 들어갔을 경우
        if (leftStart > q) {
            while (rightStart <= r) {
                temp[idx] = arr[rightStart];
                idx++;
                rightStart++;
            }
        } else {
            while (leftStart <= q) {
                temp[idx] = arr[leftStart];
                idx++;
                leftStart++;
            }
        }

        for (int i = p; i <= r; i++) {
            count++;
            arr[i] = temp[i];
            if (count == k) {
                result = arr[i];
            }
        }
    }
}