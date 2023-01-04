import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            sb = new StringBuilder("#" + i + " ");
            int result = 1;
            int[][] input = new int[9][9];
            //입력
            for (int j = 0; j < 9; j++) {
                st = new StringTokenizer(br.readLine()," ");
                for (int z = 0; z < 9; z++) {
                    input[j][z] = Integer.parseInt(st.nextToken());
                }
            }

            //가로
            for (int j = 0; j < 9; j++) {
                Set<Integer> set = new HashSet<>();
                for (int z = 0; z < 9; z++) {
                    set.add(input[j][z]);
                }
                if (set.size() != 9) {
                    result = 0;
                    break;
                }
            }
            //세로
            for (int j = 0; j < 9; j++) {
                Set<Integer> set = new HashSet<>();
                for (int z = 0; z < 9; z++) {
                    set.add(input[z][j]);
                }
                if (set.size() != 9) {
                    result = 0;
                    break;
                }
            }
            //격자
            for (int j = 0; j <= 6; j += 3) {
                Set<Integer> set = new HashSet<>();
                for (int z = 0; z <= 6; z += 3) {
                    for (int a = j; a < j + 3; a++) {
                        for (int b = z; b < z + 3; b++) {
                            set.add(input[a][b]);
                        }
                    }
                    if (set.size() != 9) {
                        result = 0;
                        break;
                    }
                }
            }
            System.out.println(sb.append(result));
        }
    }
}