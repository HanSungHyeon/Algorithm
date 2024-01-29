import java.io.*;
import java.util.*;
//n 범위는 6 <= n <= 100000
public class Main {
    static boolean[] flag = new boolean[1000001];
    static List<Integer> list = new ArrayList<>();
    public static void main (String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        makePrime();

        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) break;
            int a = 0;
            int b = 0;
            for(int i = num; i > 2; i--) {
                if(!flag[i]) continue;

                if(flag[num - i]) {
                    a = num - i;
                    b = i;
                    break;
                }
            }
            if(a + b != num) sb.append("Goldbach's conjecture is wrong.");
            else sb.append(num + " = " + a + " + " + b);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    //소수 만들기
    static void makePrime(){
        Arrays.fill(flag,true);
        flag[0] = false;
        flag[1] = false;

        for(int i = 2; i <= Math.sqrt(1000000); i++) {
            if(flag[i]) {
                for(int j = i * i; j <= 1000000; j += i) flag[j] = false;
            }
        }
    }
}
