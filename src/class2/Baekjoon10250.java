package class2;
//ACM 호텔
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            int H = Integer.parseInt(st.nextToken());   //세로
            int W = Integer.parseInt(st.nextToken());   //가로
            int N = Integer.parseInt(st.nextToken());   //n번째 손님
            int yy = N % H, xx = 0;

            if(yy == 0) {
                yy = H;
                xx = N / H;
            }
            else {
                xx = (N / H) + 1;
            }
            System.out.println(yy * 100 + xx);
        }
    }
}
