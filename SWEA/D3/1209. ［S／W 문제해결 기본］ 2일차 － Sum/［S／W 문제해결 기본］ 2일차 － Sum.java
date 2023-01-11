import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        int t = 1;
 
        while (t <= 10) {
            int input = Integer.parseInt(br.readLine());
            sb = new StringBuilder("#" + t++ + " ");
            int[][] arr = new int[100][100];
 
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
 
            int result = 0;
            
            for (int i = 0; i < 100; i++) {
                int row = 0;
                for (int j = 0; j < 100; j++) row += arr[i][j];
                
                result = Math.max(result, row);
            }
           
            for (int j = 0; j < 100; j++) {
                int column = 0;
                for (int i = 0; i < 100; i++) column += arr[i][j];
               
                result = Math.max(result, column);
            }
            
            for (int i = 0; i < 100; i++) {
                int leftDiagonal = 0;
                for (int j = i; j <= i; j++) leftDiagonal += arr[i][j];
                
                result = Math.max(result, leftDiagonal);
            }
            
            for(int i = 99; i <= 0; i--) {
                int rightDiagonal = 0;
                for(int j = i; j == i; j--) rightDiagonal += arr[i][j];
                
                result = Math.max(result, rightDiagonal);
            }
            System.out.println(sb.append(result));
        }
    }
}