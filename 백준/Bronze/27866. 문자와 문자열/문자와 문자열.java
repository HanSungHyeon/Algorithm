import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arrStr = br.readLine().split("");

        int i = Integer.parseInt(br.readLine());

        System.out.println(arrStr[i - 1]);
    }
}