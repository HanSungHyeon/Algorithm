import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new LinkedList<>();
        String[] arr = br.readLine().split("");

        for(String s : arr) list.add(s);

        ListIterator<String> iter = list.listIterator();
        while(iter.hasNext()) iter.next();

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String cmd = st.nextToken();
            String str = "";
            switch(cmd) {
                case "L" : {
                    if(!iter.hasPrevious()) break;
                    iter.previous();
                } break;
                case "D" : {
                    if(!iter.hasNext()) break;
                    iter.next();
                } break;
                case "B" : {
                    if(!iter.hasPrevious()) break;
                    iter.previous();
                    iter.remove();
                } break;
                case "P" : {
                    str = st.nextToken();
                    iter.add(str);

                } break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String s : list) sb.append(s);
        System.out.println(sb);
    }
}