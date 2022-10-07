package class1;
//3052 나머지
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i = 0; i < 10; i++){
            int num = Integer.parseInt(br.readLine());
            set.add(num % 42);
        }
        System.out.println(set.size());
    }
}
