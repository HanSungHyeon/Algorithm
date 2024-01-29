import java.io.*;
import java.util.*;

public class Main {
    static String str, max;
    static char[] arr;
    static boolean[] flag, flag2;
    static int len;
    static StringBuilder sb = new StringBuilder();
    static List<String> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        len = str.length();
        arr = new char[len];
        flag = new boolean[len];
        flag2 = new boolean[len];

        for(int i = 0; i < len; i++) {
            max = "";
            for(int j = 0; j < 101; j++) max += "Z";
            flag = flag2.clone();
            recursion(0);
            sb.append(max).append("\n");
        }

        System.out.println(sb);
    }

    static void recursion(int num) {
        if(num == 1) {
            String tmp = "";
            for(int i = 0; i < flag.length; i++) {
                if(flag[i]) tmp += str.charAt(i);
            }
            if(tmp.compareTo(max) < 0) {
                max = tmp;
                copy();
            }
            return;
        }

        for(int i = 0; i < len; i++) {
            if(!flag2[i]) {
                flag[i] = true;
                recursion(num + 1);
                flag[i] = false;
            }
        }

    }
    static void copy() {
        flag2 = flag.clone();
    }
}
