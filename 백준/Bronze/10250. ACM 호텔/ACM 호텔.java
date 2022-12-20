import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());   
            int W = Integer.parseInt(st.nextToken());   
            int N = Integer.parseInt(st.nextToken());
            int yy = N % H, xx = N / H;

            if(yy == 0) {
                yy = H;
            }
            else {
                xx += 1;    
            }
            System.out.println(yy * 100 + xx);
        }
    }
}