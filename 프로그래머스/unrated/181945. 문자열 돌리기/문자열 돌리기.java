import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        String[] strArr = a.split("");
        
        for(String s : strArr) {
            sb.append(s).append("\n");
        }
        
        System.out.println(sb);
    }
}