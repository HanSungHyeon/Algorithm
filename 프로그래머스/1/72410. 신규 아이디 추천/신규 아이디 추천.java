import java.io.*;
import java.util.*;

class Solution {
    public String solution(String new_id) {
        new_id = step1(new_id);
        new_id = step2(new_id);
        new_id = step3(new_id);
        new_id = step4(new_id);
        new_id = step5(new_id);
        new_id = step6(new_id);
        new_id = step7(new_id);
        return new_id;
    }
    
    //1단계
    public static String step1 (String str) {
        return str.toLowerCase();
    }
    
    //2단계 - 알파벳 소문자, 숫자, -, _, .
    public static String step2 (String str) {
        return str.replaceAll("[^a-z\\d-_.]*","");
    }
    
    //3단계
    public static String step3 (String str) {
        return str.replaceAll("[.]{2,}",".");
    }
    
    //4단계
    public static String step4 (String str) {
        return str.replaceAll("^[.]|[.]$","");
    }
    
    //5단계
    public static String step5 (String str) {
        if(str.length() == 0) return "a";
        return str;
    }
    
    //6단계
    public static String step6 (String str) {
        if(str.length() >= 16) {
            str = str.substring(0,15);  
            return str.replaceAll("[.]$","");
        } 
        return str;
    }
    
    //7단계
    public static String step7 (String str) {
        if(str.length() <= 2) {
            char c = str.charAt(str.length() - 1);
            
            while(str.length() != 3) {
                str += c;
            }
        }
        return str;
    }
}