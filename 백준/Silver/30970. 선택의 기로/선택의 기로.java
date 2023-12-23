import java.io.*;
import java.util.*;

public class Main {
    public static class Info {
        int q;
        int p;

        public Info(int q, int p) {
            this.q = q;
            this.p = p;
        }
    }

    static List<Info> infoList = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            infoList.add(new Info(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        //첫번째 방법
        infoList.sort((i1, i2) -> {
            if (i1.q - i2.q == 0)
                return i1.p - i2.p;
            return i2.q - i1.q;
        });

        build();
        //2번째 방법
        infoList.sort((i1, i2) -> {
            if (i1.p - i2.p == 0)
                return i2.q - i1.q;
            return i1.p - i2.p;
        });
        build();

        System.out.println(sb);
    }

    public static void build() {
        for (int i = 0; i <= 1; i++) {
            sb.append(infoList.get(i).q)
                .append(" ")
                .append(infoList.get(i).p)
                .append(" ");
        }
        sb.append("\n");
    }

}
