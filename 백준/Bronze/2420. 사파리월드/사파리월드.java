import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long firstNum = Integer.parseInt(st.nextToken());
        long secondNum = Integer.parseInt(st.nextToken());

        long result = Math.abs(firstNum - secondNum);

        System.out.println(result);
    }
}