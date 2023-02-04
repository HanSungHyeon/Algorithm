import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    static int n;
    static int[] arr;
    static int[] operator;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operator = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        insert(arr[0],1);
        System.out.println(max + "\n" + min);

    }
    public static void insert(int num,int depth) {
        if(depth == n){
            max = Math.max(num,max);
            min = Math.min(num,min);
            return;
        }

        for (int i = 0; i < operator.length; i++) {
            if(operator[i] > 0){
                operator[i]--;

                if(i == 0)
                    insert(num + arr[depth],depth + 1);
                else if(i ==1)
                    insert(num - arr[depth],depth + 1);
                else if(i == 2)
                    insert(num * arr[depth],depth + 1);
                else
                    insert(num / arr[depth],depth + 1);
                
                operator[i]++;
            }
        }
    }
}