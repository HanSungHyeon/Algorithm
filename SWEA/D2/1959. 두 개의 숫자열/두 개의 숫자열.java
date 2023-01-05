import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;
        int[] a;
        int[] b;
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            sb = new StringBuilder("#" + i + " ");
            int result = 0;

            st = new StringTokenizer(br.readLine(), " ");

            a = new int[Integer.parseInt(st.nextToken())];
            b = new int[Integer.parseInt(st.nextToken())];

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < a.length; j++) a[j] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < b.length; j++) b[j] = Integer.parseInt(st.nextToken());

            if (a.length > b.length) {
                for (int j = 0; j < a.length - b.length + 1; j++) {
                    int newResult = 0;
                    for (int z = 0; z < b.length; z++) {
                        newResult += a[j + z] * b[z];
                    }
                    result = Math.max(result, newResult);
                }
            }
            else if (b.length > a.length) {
                for (int j = 0; j < b.length - a.length + 1; j++) {
                    int newResult = 0;
                    for (int z = 0; z < a.length; z++) {
                        newResult += a[z] * b[z + j];
                    }
                    result = Math.max(result, newResult);
                }
            } else {
                for (int j = 0; j < a.length; j++) result += a[j] * b[j];
            }
            System.out.println(sb.append(result));
        }
    }
}