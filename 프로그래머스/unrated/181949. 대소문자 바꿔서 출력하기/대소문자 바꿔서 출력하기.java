import java.util.Scanner;
import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        
        char[] charArr = a.toCharArray();
        
        for(char c : charArr){
            sb.append(change(c)); 
        }
        
        System.out.println(sb);
    }
    
    public static String change(char c){
        if(Character.isUpperCase(c)) return Character.toString(c).toLowerCase();
        
        else return Character.toString(c).toUpperCase();
    }
}